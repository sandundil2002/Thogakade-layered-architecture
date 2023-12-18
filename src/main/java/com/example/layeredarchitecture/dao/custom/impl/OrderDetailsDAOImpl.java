package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.OrderDetailsDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;
import com.example.layeredarchitecture.utill.SQLUtill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public boolean saveOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtill.sql("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",dto.getOid(),dto.getItemCode(),dto.getUnitPrice(),dto.getQty());
    }
}
