package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.CustomerBo;
import com.example.layeredarchitecture.dao.custom.CustomerDao;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDaoImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDao=new CustomerDaoImpl();
    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
    return customerDao.save(customerDTO);
    }
    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDao.update(customerDTO);
    }
    @Override
    public boolean  existCustomer(String id) throws SQLException, ClassNotFoundException{
        return customerDao.exist(id);
    }
    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.delete(id);
    }
    @Override
    public ResultSet genarateCustomerId() throws SQLException, ClassNotFoundException{
        return customerDao.genarateId();
    }
    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException{
        return customerDao.search(id);
    }

}
