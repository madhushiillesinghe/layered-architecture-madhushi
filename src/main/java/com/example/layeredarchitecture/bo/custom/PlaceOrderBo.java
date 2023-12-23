package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.dao.SuperDao;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.dto.ItemDTO;
import com.example.layeredarchitecture.dto.OrderDetailDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBo extends SuperDao {
    boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

    CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;

    ItemDTO searchItem(String id) throws SQLException, ClassNotFoundException;
    boolean existItem(String id) throws SQLException, ClassNotFoundException;
     boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    public ResultSet genareteOrderId() throws SQLException, ClassNotFoundException ;
     ArrayList<CustomerDTO> loadAllCustomer() throws SQLException, ClassNotFoundException;
    public java.util.ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException ;
    }