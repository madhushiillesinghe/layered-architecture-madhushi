package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.OrderDao;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.utill.SQLUtil;

import java.sql.*;
import java.time.LocalDate;

public class OrderDaoImpl implements OrderDao {
    private static Connection connection;

    static {
        try {
            connection = DBConnection.getDbConnection().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet generateNewOrderId() throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst;*/
        return SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
    }
    @Override
    public void selectOrderId(String orderId) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
        stm.setString(1, orderId);
        *//*if order id already exist*//*
       if( stm.executeQuery().next()) {
       }*/
        SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
    }
    @Override
    public boolean saveOrder(String orderId,LocalDate date,String customerId) throws SQLException, ClassNotFoundException {
       /*connection.setAutoCommit(false);
      PreparedStatement  stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1, orderId);
        stm.setDate(2, Date.valueOf(date));
        stm.setString(3, customerId);
        if (stm.executeUpdate() != 1) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }
        return true;*/
        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",orderId,date,customerId);
    }
}
