package com.example.layeredarchitecture.dao.custom.impl;
import com.example.layeredarchitecture.dao.custom.CustomerDao;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.entity.Customer;
import com.example.layeredarchitecture.utill.SQLUtil;

import java.sql.*;
import java.util.ArrayList;
public class CustomerDaoImpl  implements CustomerDao {

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");*/
        ResultSet rst=SQLUtil.execute("SELECT * FROM Customer");
        ArrayList<Customer> allcustomer = new ArrayList<>();

        while (rst.next()) {
            Customer entity = new Customer(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"));
            allcustomer.add(entity);/*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");*/
        }
        return allcustomer;
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getId());
        return pstm.executeUpdate() > 0;*/
        return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?", customer.getName(),customer.getAddress(),customer.getId());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
        pstm.setString(1, id);
        return pstm.executeQuery().next();*/
        ResultSet rst= SQLUtil.execute("SELECT id FROM Customer WHERE id=?", id);
       return rst.next();
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setString(1, id);
        return pstm.executeUpdate() > 0;*/
        return SQLUtil.execute("DELETE FROM Customer WHERE id=?", id);
    }

    @Override
    public ResultSet genarateId() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        return rst;*/
        return SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
        pstm.setString(1, id + "");
        ResultSet rst = pstm.executeQuery();
        rst.next();
        return new CustomerDTO(
                rst.getString(1),
                rst.getString(2),
                rst.getString(3)
        );*/
        ResultSet rst= SQLUtil.execute("SELECT * FROM Customer WHERE id=?", id);
        rst.next();
        return new Customer(
                rst.getString(1),
                rst.getString(2),
                rst.getString(3)
        );
    }

    @Override
    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
      /*  Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3,dto.getAddress());
        return  pstm.executeUpdate()>0;*/

        return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", customer.getId(),customer.getName(),customer.getAddress());
    }
}
