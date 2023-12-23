package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.entity.Customer;
import com.example.layeredarchitecture.entity.Item;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBO {
    boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;
    ItemDTO findItem(String code);

    CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;
    ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException;

    boolean existItem(String code)throws SQLException, ClassNotFoundException;

    boolean existCustomer(String id)throws SQLException, ClassNotFoundException;

    String generateOrderID()throws SQLException, ClassNotFoundException;

    ArrayList<Customer> getAllCustomer()throws SQLException, ClassNotFoundException;

    ArrayList<Item> getAllItems()throws SQLException, ClassNotFoundException;
}
