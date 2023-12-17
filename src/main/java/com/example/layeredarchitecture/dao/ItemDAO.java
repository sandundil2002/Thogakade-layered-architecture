package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {
    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    void deleteItem(String id) throws SQLException, ClassNotFoundException;

    boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    void updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean exitItem(String code) throws SQLException, ClassNotFoundException;

    String generateId() throws SQLException, ClassNotFoundException;

    ItemDTO searchItem(String newValue)throws SQLException, ClassNotFoundException;

    boolean updateItemPlaceOrder(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
}
