package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.CommentService;
import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.comment.AddCommentResponse;
import com.etiya.ecommercepair3.business.dtos.responses.comment.CommentDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.comment.ListCommentResponse;
import com.etiya.ecommercepair3.business.dtos.responses.comment.UpdateCommentResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.AddDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.DiscountDetailResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.UpdateCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.comment.AddCommentRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.comment.UpdateCommentRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.discount.AddDiscountRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentsController {
    private final CommentService commentService;

    @GetMapping()
    public DataResult<List<ListCommentResponse>> getAll(){
        return commentService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<CommentDetailResponse> getById(@PathVariable Integer id){
        return commentService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<AddCommentResponse> addDiscount(AddCommentRequest addCommentRequest){
        return commentService.addComment(addCommentRequest);
    }

    @PutMapping("/update")
    private DataResult<UpdateCommentResponse> updateComment(@RequestBody@Valid UpdateCommentRequest updateCommentRequest){
        return commentService.updateComment(updateCommentRequest);
    }

    @DeleteMapping("/{id}")
    public Result deleteComment(@PathVariable Integer id){
        return commentService.deleteComment(id);
    }
}
