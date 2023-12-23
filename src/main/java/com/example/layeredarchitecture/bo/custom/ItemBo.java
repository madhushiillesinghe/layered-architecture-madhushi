package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.dao.SuperDao;
import com.example.layeredarchitecture.dto.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo extends SuperDao {
    boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean UpdateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    boolean ExistItem(String  id) throws SQLException, ClassNotFoundException ;
    boolean deleteItem(String  id) throws SQLException, ClassNotFoundException;
    ResultSet genarateItemId() throws SQLException, ClassNotFoundException;
    ArrayList<ItemDTO> getAllItem()throws SQLException,ClassNotFoundException;
}
