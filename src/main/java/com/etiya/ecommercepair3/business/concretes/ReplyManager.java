package com.etiya.ecommercepair3.business.concretes;


import com.etiya.ecommercepair3.business.abstracts.ReplyService;
import com.etiya.ecommercepair3.business.dtos.responses.reply.AddReplyResponse;
import com.etiya.ecommercepair3.business.dtos.responses.reply.ListReplyResponse;
import com.etiya.ecommercepair3.business.dtos.responses.reply.ReplyDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.reply.UpdateReplyResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.reply.AddReplyRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.reply.UpdateReplyRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.Reply;
import com.etiya.ecommercepair3.repositories.abstracts.ReplyDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyManager implements ReplyService {
    private final ReplyDao replyDao;

    private final ModelMapperService modelMapperService;
    @Override
    public DataResult<List<ListReplyResponse>> getAll() {
        return new SuccessDataResult<>(replyDao.getAll());
    }

    @Override
    public DataResult<ReplyDetailResponse> getById(Integer id) {
        return new SuccessDataResult<>(replyDao.getByReplyId(id));
    }

    @Override
    public DataResult<AddReplyResponse> addReply(AddReplyRequest addReplyRequest) {
        // iş kuralı
        Reply reply=modelMapperService.forRequest().map(addReplyRequest,Reply.class);
        replyDao.save(reply);
        AddReplyResponse addReplyResponse=modelMapperService.forResponse().map(reply,AddReplyResponse.class);

        return new SuccessDataResult<>(addReplyResponse);
    }

    @Override
    public DataResult<UpdateReplyResponse> updateReply(UpdateReplyRequest updateReplyRequest){
        // iş kuralı
        Reply reply=modelMapperService.forRequest().map(updateReplyRequest,Reply.class);
        reply.setId(updateReplyRequest.getId());
        replyDao.save(reply);
        UpdateReplyResponse updateReplyResponse=modelMapperService.forResponse().map(reply,UpdateReplyResponse.class);
        return new SuccessDataResult<>(updateReplyResponse);
    }

    @Override
    public Result deleteReply(Integer id){
        replyDao.deleteById(id);
        return new SuccessResult("X");
    }
}
