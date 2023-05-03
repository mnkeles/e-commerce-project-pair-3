package com.etiya.ecommercepair3.repositories.abstracts;


import com.etiya.ecommercepair3.business.dtos.responses.refund.ListRefundResponse;
import com.etiya.ecommercepair3.business.dtos.responses.refund.RefundDetailResponse;
import com.etiya.ecommercepair3.entities.concretes.Refund;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RefundDao extends JpaRepository<Refund,Integer> {

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.refund.ListRefundResponse" +
            "(r.id,r.refundCause,r.statusType,r.order.id) From Refund r")
    Slice<ListRefundResponse> getAll(Pageable pageable);

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.refund.ListRefundResponse" +
            "(r.id,r.refundCause,r.statusType,o.id) From Refund  r join Order o  where r.id=:id")
    RefundDetailResponse getByRefundId(Integer id);
}
