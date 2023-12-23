package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.SuperDao;

import java.sql.*;
import java.time.LocalDate;

public interface OrderDao extends SuperDao {
     ResultSet generateNewOrderId() throws SQLException, ClassNotFoundException;
     void selectOrderId(String orderId) throws SQLException, ClassNotFoundException;
     boolean saveOrder(String orderId,LocalDate date,String customerId) throws SQLException, ClassNotFoundException;
}
