package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public interface OrderDao {
     ResultSet generateNewOrderId() throws SQLException, ClassNotFoundException;
     void selectOrderId(String orderId) throws SQLException, ClassNotFoundException;
     boolean saveOrder(String orderId,LocalDate date,String customerId) throws SQLException, ClassNotFoundException;
}
