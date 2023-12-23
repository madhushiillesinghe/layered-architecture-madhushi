package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.PlaceOrderBo;
import com.example.layeredarchitecture.dao.custom.CustomerDao;
import com.example.layeredarchitecture.dao.custom.ItemDao;
import com.example.layeredarchitecture.dao.custom.OrderDao;
import com.example.layeredarchitecture.dao.custom.OrderDetailDao;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDaoImpl;
import com.example.layeredarchitecture.dao.custom.impl.ItemDaoImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDaoImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailDaoImpl;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBoImpl implements PlaceOrderBo {
    CustomerDao customerDao=new CustomerDaoImpl();
    ItemDao itemDao=new ItemDaoImpl();
    OrderDao orderDao=new OrderDaoImpl();
    OrderDetailDao orderDetailDao=new OrderDetailDaoImpl();
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) {
        /*Transaction*/
        Connection connection = null;
        boolean isOrderSaved;
        boolean isOrderDetailSaved=false;
        boolean isUpdated=false;
        try {
            /*connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
            stm.setString(1, orderId);
            *//*if order id already exist*//*
            if (stm.executeQuery().next()) {}
*/
            connection= DBConnection.getDbConnection().getConnection();
            orderDao.selectOrderId(orderId);
            connection.setAutoCommit(false);
            isOrderSaved=orderDao.saveOrder(orderId,orderDate,customerId);
            if(!(isOrderSaved)){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            /*connection.setAutoCommit(false);
            stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
            stm.setString(1, orderId);
            stm.setDate(2, Date.valueOf(orderDate));
            stm.setString(3, customerId);*/

            /*if (stm.executeUpdate() != 1) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }*/

            //stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");

            for (OrderDetailDTO detail : orderDetails) {
                isOrderDetailSaved = orderDetailDao.saveOrderDetail(orderId, detail);
                if(!(isOrderDetailSaved)){
                    connection.rollback();;
                    connection.setAutoCommit(true);
                    return  false;
                }
//                //Search & Update Item
                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                /*PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
                pstm.setString(1, item.getDescription());
                pstm.setBigDecimal(2, item.getUnitPrice());
                pstm.setInt(3, item.getQtyOnHand());
                pstm.setString(4, item.getCode());*/

                isUpdated = itemDao.update(item);
                if(!(isUpdated)){
                    connection.rollback();;
                    connection.setAutoCommit(true);
                    return  false;
                }
            }

               /* if (!(pstm.executeUpdate() > 0)) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }*/
            //System.out.println(isOrderDetailSaved);
            if(isOrderSaved && isOrderDetailSaved && isUpdated) {
                connection.commit();
                connection.setAutoCommit(true);
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    public ItemDTO findItem(String code) {
        try {
            ItemDTO dto=itemDao.search(code);
            return new ItemDTO(code, dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.search(id);

    }
    @Override
    public ItemDTO searchItem(String id) throws SQLException, ClassNotFoundException {
        return itemDao.search(id);

    }
    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.exist(id);

    }
    @Override
    public boolean existItem(String id) throws SQLException, ClassNotFoundException {
        return itemDao.exist(id);
    }
    @Override
    public ResultSet genareteOrderId() throws SQLException, ClassNotFoundException {
        return orderDao.generateNewOrderId();
    }
    @Override
    public ArrayList<CustomerDTO> loadAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDao.getAll();
    }
    @Override
    public ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException {
        return itemDao.getAll();
    }



}
