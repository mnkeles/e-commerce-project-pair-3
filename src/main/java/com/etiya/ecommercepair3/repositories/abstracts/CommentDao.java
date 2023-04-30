package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.comment.CommentDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.comment.ListCommentResponse;
import com.etiya.ecommercepair3.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Integer> {

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.comment.ListCommentResponse" +
            "(c.id,c.title,c.message,p.id,cu.id) from Comment c join Product p join Customer  cu")
    List<ListCommentResponse> getAll();

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.comment.CommentDetailResponse" +
            "(c.id,c.title,c.message,p.id,cu.id) from Comment c join Product p join Customer  cu" +
            " where c.id=:id")
    CommentDetailResponse getByCommentId(Integer id);
}
