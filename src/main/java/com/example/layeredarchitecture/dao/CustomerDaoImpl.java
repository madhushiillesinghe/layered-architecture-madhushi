package com.example.layeredarchitecture.dao;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;
public class CustomerDaoImpl  implements  CustomerDao{

        @Override
        public ArrayList<CustomerDTO>getAllCustomer()throws SQLException,ClassNotFoundException {
            Connection connection = DBConnection.getDbConnection().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
            ArrayList<CustomerDTO> allcustomer = new ArrayList<>();

            while (rst.next()) {
                CustomerDTO customerDTO = new CustomerDTO(
                        rst.getString("id"),
                        rst.getString("name"),
                        rst.getString("address"));
                allcustomer.add(customerDTO);
            }
            return allcustomer;
        }
        @Override
        public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
            Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
            pstm.setString(1,dto.getName());
            pstm.setString(2, dto.getAddress());
            pstm.setString(3, dto.getId());
            return pstm.executeUpdate() > 0;
        }
        @Override
        public boolean  existsCustomer(String id) throws SQLException, ClassNotFoundException {
            Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
            pstm.setString(1, id);
            return pstm.executeQuery().next();
        }
        @Override
        public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
            Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
            pstm.setString(1, id);
            return pstm.executeUpdate()>0;
        }
        @Override
        public ResultSet genarateCustomerId() throws SQLException, ClassNotFoundException {
            Connection connection = DBConnection.getDbConnection().getConnection();
            ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
            return  rst;
        }
    }
