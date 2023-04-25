package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.entities.concrete.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyDao extends JpaRepository<Reply,Integer> {
    @Query("SELECT r FROM Reply r")
    List<Reply> findAllByReply();
}
