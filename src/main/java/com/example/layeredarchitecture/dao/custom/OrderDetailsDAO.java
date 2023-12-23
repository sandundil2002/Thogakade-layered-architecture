package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.SuperDAO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailsDAO extends SuperDAO {
    boolean saveOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;
}
