package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.ReplyService;
import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.reply.AddReplyResponse;
import com.etiya.ecommercepair3.business.dtos.responses.reply.ListReplyResponse;
import com.etiya.ecommercepair3.business.dtos.responses.reply.ReplyDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.reply.UpdateReplyResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.UpdateCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.reply.AddReplyRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.reply.UpdateReplyRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class RepliesController {
    private final ReplyService replyService;

    @GetMapping()
    public DataResult<List<ListReplyResponse>> getAll(){
        return replyService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<ReplyDetailResponse> getById(@PathVariable Integer id){
        return replyService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<AddReplyResponse> addReply(AddReplyRequest addReplyRequest){
        return replyService.addReply(addReplyRequest);
    }

    @PutMapping("/update")
    private DataResult<UpdateReplyResponse> updateReply(@RequestBody@Valid UpdateReplyRequest updateReplyRequest){
        return replyService.updateReply(updateReplyRequest);
    }

    @DeleteMapping("/{id}")
    public Result deleteReply(@PathVariable Integer id){
        return replyService.deleteReply(id);
    }
}
