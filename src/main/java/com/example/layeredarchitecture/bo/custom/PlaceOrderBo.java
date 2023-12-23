package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBo {
    boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);

    CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;

    ItemDTO searchItem(String id) throws SQLException, ClassNotFoundException;
    boolean existItem(String id) throws SQLException, ClassNotFoundException;
     boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    public ResultSet genareteOrderId() throws SQLException, ClassNotFoundException ;
     ArrayList<CustomerDTO> loadAllCustomer() throws SQLException, ClassNotFoundException;
    public java.util.ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException ;
    }