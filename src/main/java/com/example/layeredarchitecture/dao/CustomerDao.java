package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDao extends CRUDDao<CustomerDTO>{
    /*ArrayList<CustomerDTO> getAllCustomer()throws SQLException,ClassNotFoundException ;
     boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;
     boolean  existsCustomer(String id) throws SQLException, ClassNotFoundException;
     boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException ;
     ResultSet genarateCustomerId() throws SQLException, ClassNotFoundException;
     CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException ;
     boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;*/
}
