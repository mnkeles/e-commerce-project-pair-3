package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.entities.concrete.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressDao extends JpaRepository <Address,Integer> {
    @Query("SELECT a FROM Address a")
    List<Address>findAllByAddress();

    @Query("SELECT a.description,s.streetName FROM Address a JOIN a.street s")
    List<Address> getAddressByStreet();

    Address getById(Integer id);
}
