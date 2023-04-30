package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.CommentService;
import com.etiya.ecommercepair3.business.dtos.responses.comment.AddCommentResponse;
import com.etiya.ecommercepair3.business.dtos.responses.comment.CommentDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.comment.ListCommentResponse;
import com.etiya.ecommercepair3.business.dtos.responses.comment.UpdateCommentResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.comment.AddCommentRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.comment.UpdateCommentRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.Comment;
import com.etiya.ecommercepair3.repositories.abstracts.CommentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentManager implements CommentService {

    private final CommentDao commentDao;

    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<List<ListCommentResponse>> getAll() {
        return new SuccessDataResult<>(commentDao.getAll());
    }

    @Override
    public DataResult<CommentDetailResponse> getById(Integer id) {
        return new SuccessDataResult<>(commentDao.getByCommentId(id));
    }

    @Override
    public DataResult<AddCommentResponse> addComment(AddCommentRequest addCommentRequest) {
        // iş kuralı
        Comment comment = modelMapperService.forRequest().map(addCommentRequest, Comment.class);
        commentDao.save(comment);
        AddCommentResponse addCommentResponse = modelMapperService.forResponse().map(comment, AddCommentResponse.class);


        return new SuccessDataResult<>(addCommentResponse);
    }

    @Override
    public DataResult<UpdateCommentResponse> updateComment(UpdateCommentRequest updateCommentRequest) {
        // iş kuralı
        Comment comment = modelMapperService.forRequest().map(updateCommentRequest, Comment.class);
        comment.setId(updateCommentRequest.getId());
        commentDao.save(comment);
        UpdateCommentResponse updateCommentResponse = modelMapperService.forResponse().map(comment, UpdateCommentResponse.class);
        return new SuccessDataResult<>(updateCommentResponse);
    }

    @Override
    public Result deleteComment(Integer id) {
        commentDao.deleteById(id);
        return new SuccessResult("X");
    }
}
