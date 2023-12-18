package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDao  extends CRUDDao<ItemDTO>{
    /* boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

     boolean UpdateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
     boolean ExistItem(String  id) throws SQLException, ClassNotFoundException ;
     boolean deleteItem(String  id) throws SQLException, ClassNotFoundException;
     ResultSet genarateid() throws SQLException, ClassNotFoundException;
     ArrayList<ItemDTO> getAllItem()throws SQLException,ClassNotFoundException;
     ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException;*/
}
