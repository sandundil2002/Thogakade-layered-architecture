package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.entity.Order;
import com.example.layeredarchitecture.utill.SQLUtill;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtill.sql("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public Order search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean checkOrderId(String oid) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =  SQLUtill.sql("SELECT oid FROM `Orders` WHERE oid=?",oid);
        return resultSet.next();
    }

    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Order dto) throws SQLException, ClassNotFoundException {
        return SQLUtill.sql("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId());
    }

    @Override
    public boolean update(Order dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public boolean exit(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
