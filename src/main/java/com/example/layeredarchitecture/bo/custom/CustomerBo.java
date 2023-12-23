package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.dao.SuperDao;
import com.example.layeredarchitecture.dto.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerBo extends SuperDao {
    boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;
    boolean  existCustomer(String id) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException ;
    ResultSet genarateCustomerId() throws SQLException, ClassNotFoundException;
    CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException ;

}
