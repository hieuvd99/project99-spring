package com.example.serviceImpl;

import com.example.dao.repository.AddressRepository;
import com.example.model.Address;
import com.example.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

  @Autowired
  private AddressRepository addressRepository;

  @Override
  public Address save(Address address) {
    return addressRepository.save(address);
  }

  @Override
  public Address addressByUserID(long user_id) {
    return addressRepository.addressByUserID(user_id);
  }
}
