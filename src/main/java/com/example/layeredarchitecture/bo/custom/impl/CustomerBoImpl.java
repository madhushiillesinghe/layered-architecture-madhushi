package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.CustomerBo;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDao;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDao= (CustomerDao) DAOFactory.getDADFactory().getDao(DAOFactory.DADType.CUSTOMER);
    @Override
    public boolean saveCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {
    return customerDao.save(new Customer(customer.getId(),customer.getName(),customer.getAddress()));
    }
    @Override
    public boolean updateCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return customerDao.update(new Customer(customer.getName(), customer.getAddress(), customer.getId()));
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
        Customer customer=customerDao.search(id);
        CustomerDTO customerDTO=new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());
        return customerDTO;
    }

}
