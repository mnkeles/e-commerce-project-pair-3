package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.comment.AddCommentResponse;
import com.etiya.ecommercepair3.business.dtos.responses.comment.CommentDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.comment.ListCommentResponse;
import com.etiya.ecommercepair3.business.dtos.responses.comment.UpdateCommentResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.AddDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.DiscountDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.ListDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.comment.AddCommentRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.comment.UpdateCommentRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.discount.AddDiscountRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CommentService {

    DataResult<Slice<ListCommentResponse>> getAll(Pageable pageable);
    DataResult<CommentDetailResponse> getById(Integer id);

    DataResult<AddCommentResponse> addComment(AddCommentRequest addCommentRequest);

    DataResult<UpdateCommentResponse> updateComment(UpdateCommentRequest updateCommentRequest);

    Result deleteComment(Integer id);
}
