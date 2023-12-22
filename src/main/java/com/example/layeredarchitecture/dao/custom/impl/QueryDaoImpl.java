package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.QueryDao;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerOrderDTO;
import com.example.layeredarchitecture.utill.SQLUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QueryDaoImpl implements QueryDao {
    @Override
    public List<CustomerOrderDTO> customerOrderDetail() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer join Orders on Customer.id=Orders.customerID");
        List<CustomerOrderDTO> joinquery = new ArrayList<>();

        while (rst.next()) {
            CustomerOrderDTO dto = new CustomerOrderDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDate(5).toLocalDate()
            );

            joinquery.add(dto);
        }
        return joinquery;
    }
}
