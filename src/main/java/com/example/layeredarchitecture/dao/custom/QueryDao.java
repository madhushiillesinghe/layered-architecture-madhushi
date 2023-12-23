package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.SuperDao;
import com.example.layeredarchitecture.dto.CustomerOrderDTO;

import java.sql.SQLException;
import java.util.List;

public interface QueryDao extends SuperDao {
    List<CustomerOrderDTO>  customerOrderDetail() throws SQLException, ClassNotFoundException;
}
