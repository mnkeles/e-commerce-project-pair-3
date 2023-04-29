package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.discount.DiscountDetailsResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.ListDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.DistrictDetailResponse;
import com.etiya.ecommercepair3.entities.concrete.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiscountDao extends JpaRepository<Discount,Integer> {

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.discount.DiscountDetailsResponse" +
            "(d.id,d.discountAmount,d.discountExpire) from Discount d")
    List<ListDiscountResponse> getAll();

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.discount.DiscountDetailsResponse" +
            "(d.id,d.discountAmount,d.discountExpire) from Discount d where d.id=:id")
    DiscountDetailsResponse getByDiscountId(Integer id);

    @Query("SELECT d FROM Discount d")
    List<Discount> findAllByDiscount();
}
