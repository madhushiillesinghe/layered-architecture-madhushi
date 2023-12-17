package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDao {
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public boolean UpdateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    public boolean ExistItem(String  id) throws SQLException, ClassNotFoundException ;
    public boolean deleteItem(String  id) throws SQLException, ClassNotFoundException;
    public ResultSet genarateid() throws SQLException, ClassNotFoundException;
    public ArrayList<ItemDTO> getAllItem()throws SQLException,ClassNotFoundException;
}
