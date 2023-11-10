package com.example.service;

import com.example.model.Address;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
  Address save(Address address);
  Address addressByUserID(long user_id);
}
