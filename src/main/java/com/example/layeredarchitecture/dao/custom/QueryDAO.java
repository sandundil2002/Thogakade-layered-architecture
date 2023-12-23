package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.bo.SuperBO;
import com.example.layeredarchitecture.model.CustomerDTO;

public interface QueryDAO extends SuperDAO {
    void customerOrderDetails(CustomerDTO customerDTO);
}
