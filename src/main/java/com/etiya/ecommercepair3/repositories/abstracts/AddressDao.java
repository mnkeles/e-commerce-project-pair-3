package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.address.AddressDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommercepair3.entities.concretes.Address;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressDao extends JpaRepository <Address,Integer> {
    // JPQL Jpa Query Language => Model ismi kullanır
    // SQL => tablo ismi kullanır
    //nativeQuery = false  JPQL   nativeQuery=true SQL sorgusu
    @Query(value="Select new com.etiya.ecommercepair3.business.dtos.responses.address.ListAddressResponse" +
            "(a.id,a.description,s.id,c.id) " +
            "From Address a join Street  s join Customer c " ,nativeQuery = false)
    Slice<ListAddressResponse> getAll(Pageable pageable);

    @Query(value="Select new com.etiya.ecommercepair3.business.dtos.responses.address.AddressDetailResponse" +
            "(a.id,a.description,s.id , c.id) from Address a join a.street s join a.customer c Where a.id=:id",
            nativeQuery = false)
    AddressDetailResponse getByAddressId(Integer id);


}
