package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.SuperDao;
import com.example.layeredarchitecture.dto.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailDao extends SuperDao {
     boolean saveOrderDetail(String  orderId,OrderDetailDTO orderdeatail) throws SQLException, ClassNotFoundException;

}
