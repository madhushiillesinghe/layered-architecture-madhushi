package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.ItemBo;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.ItemDao;
import com.example.layeredarchitecture.dto.ItemDTO;
import com.example.layeredarchitecture.entity.Customer;
import com.example.layeredarchitecture.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {
    ItemDao itemDao= (ItemDao) (ItemDao) DAOFactory.getDADFactory().getDao(DAOFactory.DADType.ITEM);
    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException{
        return  itemDao.save(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()));
    }
    @Override
    public boolean UpdateItem(ItemDTO dto) throws SQLException, ClassNotFoundException{
        return  itemDao.update(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()));
    }
    @Override
    public boolean ExistItem(String id) throws SQLException, ClassNotFoundException{
        return itemDao.exist(id);
    }
    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException{
        return itemDao.delete(id);
    }
    @Override
    public ResultSet genarateItemId() throws SQLException, ClassNotFoundException{
        return itemDao.genarateId();
    }
    @Override
    public ArrayList<ItemDTO> getAllItem()throws SQLException,ClassNotFoundException{
        ArrayList<Item> items=itemDao.getAll();
        ArrayList<ItemDTO> itemDTOS=new ArrayList<>();
        for (Item item:items) {
            itemDTOS.add(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));
        }
        return itemDTOS;
    }
    /*@Override
    public ItemDTO search(String newItemCode) throws SQLException, ClassNotFoundException{
        return itemDao.search(newItemCode);
    }*/
}
