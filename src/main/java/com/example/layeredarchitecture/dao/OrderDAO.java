package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO {
    String generateId()throws SQLException, ClassNotFoundException;

    boolean checkOrderId(String oid) throws SQLException, ClassNotFoundException;

    boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
}
