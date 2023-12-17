package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDao {
    public ArrayList<CustomerDTO> getAllCustomer()throws SQLException,ClassNotFoundException ;
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;
    public boolean  existsCustomer(String id) throws SQLException, ClassNotFoundException;
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException ;
    public ResultSet genarateCustomerId() throws SQLException, ClassNotFoundException;
}
