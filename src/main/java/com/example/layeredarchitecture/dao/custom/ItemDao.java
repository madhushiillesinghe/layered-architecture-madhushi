package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CRUDDao;
import com.example.layeredarchitecture.dto.ItemDTO;
import com.example.layeredarchitecture.entity.Item;

public interface ItemDao  extends CRUDDao<Item> {
    /* boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

     boolean UpdateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
     boolean ExistItem(String  id) throws SQLException, ClassNotFoundException ;
     boolean deleteItem(String  id) throws SQLException, ClassNotFoundException;
     ResultSet genarateid() throws SQLException, ClassNotFoundException;
     ArrayList<ItemDTO> getAllItem()throws SQLException,ClassNotFoundException;
     ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException;*/
}
