package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.OrderDetailDao;
import com.example.layeredarchitecture.dto.OrderDetailDTO;
import com.example.layeredarchitecture.utill.SQLUtil;

import java.sql.SQLException;

public class OrderDetailDaoImpl implements OrderDetailDao {
    @Override
    public boolean saveOrderDetail(String orderId, OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
        stm.setString(1, orderId);
        stm.setString(2, dto.getItemCode());
        stm.setBigDecimal(3, dto.getUnitPrice());
        stm.setInt(4, dto.getQty());
        boolean b=stm.executeUpdate() >0;
        //System.out.println(b);
        if (b) {
           return true;
        }*/
        return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",orderId,dto.getItemCode(),dto.getUnitPrice(),dto.getQty());
}
}
