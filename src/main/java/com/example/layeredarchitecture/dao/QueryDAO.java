package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;

public interface QueryDAO {
    void customerOrderDetails(CustomerDTO customerDTO);
}
