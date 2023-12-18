package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface OrderDetailsDAO {
    boolean saveOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;
}
