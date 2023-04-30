package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.reply.ListReplyResponse;
import com.etiya.ecommercepair3.business.dtos.responses.reply.ReplyDetailResponse;
import com.etiya.ecommercepair3.entities.concretes.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyDao extends JpaRepository<Reply,Integer> {
    @Query("SELECT new com.etiya.ecommercepair3.business.dtos.responses.reply.ListReplyResponse" +
            "(r.id,r.message,c.id,r.id) from Reply r  join Salesman s join Comment  c")
    List<ListReplyResponse> getAll();

    @Query("SELECT new com.etiya.ecommercepair3.business.dtos.responses.reply.ReplyDetailResponse" +
            "(r.id,r.message,c.id,s.id) from Reply r join Salesman s join Comment  c  where r.id=:id")
    ReplyDetailResponse getByReplyId(Integer id);

    @Query("SELECT r FROM Reply r")
    List<Reply> findAllByReply();
}
