package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.ItemDao;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.utill.SQLUtil;

import java.sql.*;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
        //Connection connection = DBConnection.getDbConnection().getConnection();
      return  SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
        /*pstm.setString(1, dto.getCode());
        pstm.setString(2, dto.getDescription());
        pstm.setBigDecimal(3,dto.getUnitPrice());
        pstm.setInt(4,dto.getQtyOnHand());*/
    }
    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        pstm.setString(1, dto.getDescription());
        pstm.setBigDecimal(2,dto.getUnitPrice());
        pstm.setInt(3, dto.getQtyOnHand());
        pstm.setString(4, dto.getCode());
        return pstm.executeUpdate()>0;*/
        return  SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
    }
    @Override
    public boolean exist(String  id) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
        pstm.setString(1, id);
        return pstm.executeQuery().next();*/
        ResultSet rst=SQLUtil.execute("SELECT code FROM Item WHERE code=?",id);
        return rst.next();
    }
    @Override
    public boolean delete(String  id) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
        pstm.setString(1, id);
        return pstm.executeUpdate()>0;*/
        return SQLUtil.execute("DELETE FROM Item WHERE code=?",id);
    }
    @Override
    public ResultSet genarateId() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        return rst;*/
        return SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
    }
    @Override
    public ArrayList<ItemDTO> getAll()throws SQLException,ClassNotFoundException {
      /*  Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");*/
        ResultSet rst=SQLUtil.execute("SELECT * FROM Item");
        ArrayList<ItemDTO> allcustomer = new ArrayList<>();

        while (rst.next()) {
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand"));
                    allcustomer.add(itemDTO);
        }
        return allcustomer;
        //return  SQLUtil.execute("SELECT * FROM Item");
    }
    @Override
   public ItemDTO search(String newItemCode) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
        pstm.setString(1, newItemCode + "");
        ResultSet rst = pstm.executeQuery();
        rst.next();
        return new ItemDTO (
                rst.getString(1),
                rst.getString(2),
                rst.getBigDecimal(3),
                rst.getInt(4)
        );*/
    ResultSet rst= SQLUtil.execute("SELECT * FROM Item WHERE code=?",newItemCode);
        rst.next();
        return new ItemDTO (
                rst.getString(1),
                rst.getString(2),
                rst.getBigDecimal(3),
                rst.getInt(4)
        );
    }

}
