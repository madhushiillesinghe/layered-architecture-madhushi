package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.ItemBo;
import com.example.layeredarchitecture.dao.custom.ItemDao;
import com.example.layeredarchitecture.dao.custom.impl.ItemDaoImpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {
    ItemDao itemDao=new ItemDaoImpl();
    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException{
        return  itemDao.save(dto);
    }
    @Override
    public boolean UpdateItem(ItemDTO dto) throws SQLException, ClassNotFoundException{
        return itemDao.update(dto);
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
        return itemDao.getAll();
    }
    /*@Override
    public ItemDTO search(String newItemCode) throws SQLException, ClassNotFoundException{
        return itemDao.search(newItemCode);
    }*/
}
