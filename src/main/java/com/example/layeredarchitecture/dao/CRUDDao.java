package com.example.layeredarchitecture.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CRUDDao<T> extends SuperDao {
    ArrayList<T> getAll()throws SQLException,ClassNotFoundException ;
    boolean update(T entity) throws SQLException, ClassNotFoundException ;
    boolean  exist(String id) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException ;
    ResultSet genarateId() throws SQLException, ClassNotFoundException;
    T search(String id) throws SQLException, ClassNotFoundException ;
    boolean save(T dto) throws SQLException, ClassNotFoundException;
}
