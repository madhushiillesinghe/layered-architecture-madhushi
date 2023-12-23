package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CRUDDao;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.entity.Customer;

public interface CustomerDao extends CRUDDao<Customer> {
    /*ArrayList<CustomerDTO> getAllCustomer()throws SQLException,ClassNotFoundException ;
     boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;
     boolean  existsCustomer(String id) throws SQLException, ClassNotFoundException;
     boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException ;
     ResultSet genarateCustomerId() throws SQLException, ClassNotFoundException;
     CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException ;
     boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;*/
}
