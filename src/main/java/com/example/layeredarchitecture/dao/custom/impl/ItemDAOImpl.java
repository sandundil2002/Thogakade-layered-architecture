package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.entity.Customer;
import com.example.layeredarchitecture.entity.Item;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.utill.SQLUtill;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtill.sql("SELECT * FROM Item");
        ArrayList<Item> allItems = new ArrayList<>();

        while (rst.next()) {
            Item itemDTO = new Item(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("qtyOnHand"),
                    rst.getInt("unitPrice"));
            allItems.add(itemDTO);
        }
        return allItems;
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
        SQLUtill.sql("DELETE FROM item WHERE code=?",id);
    }

    @Override
    public boolean save(Item itemDTO) throws SQLException, ClassNotFoundException {
        return SQLUtill.sql("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
    }

    @Override
    public boolean update(Item dto) throws SQLException, ClassNotFoundException {
        return SQLUtill.sql("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());

    }

    @Override
    public boolean exit(String code) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =  SQLUtill.sql("SELECT code FROM Item WHERE code=?",code);
        return resultSet.next();
    }

    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtill.sql("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public Item search(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtill.sql("SELECT * FROM Item WHERE code=?",code);
        rst.next();
        return new Item(code + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }
}
