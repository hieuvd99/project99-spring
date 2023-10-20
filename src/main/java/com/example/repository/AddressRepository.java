package com.example.repository;

import com.example.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

  @Query(value= BaseSQL.S0002, nativeQuery = true)
  Address addressByUserID(@Param("user_id") long user_id);
}
