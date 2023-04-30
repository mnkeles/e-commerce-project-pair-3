package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.reply.AddReplyResponse;
import com.etiya.ecommercepair3.business.dtos.responses.reply.ListReplyResponse;
import com.etiya.ecommercepair3.business.dtos.responses.reply.ReplyDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.reply.UpdateReplyResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.AddSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.ListSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.SalesmanDetailResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.reply.AddReplyRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.reply.UpdateReplyRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.saleman.AddSalesmanRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;

import java.util.List;

public interface ReplyService {
    DataResult<List<ListReplyResponse>> getAll();

    DataResult<ReplyDetailResponse>  getById(Integer id);

    DataResult<AddReplyResponse> addReply(AddReplyRequest addReplyRequest);

    DataResult<UpdateReplyResponse> updateReply(UpdateReplyRequest updateReplyRequest);

    Result deleteReply(Integer id);
}
