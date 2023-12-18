package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailDao {
     boolean saveOrderDetail(String  orderId,OrderDetailDTO orderdeatail) throws SQLException, ClassNotFoundException;

}
