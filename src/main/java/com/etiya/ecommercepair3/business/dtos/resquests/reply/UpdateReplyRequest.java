package com.etiya.ecommercepair3.business.dtos.resquests.reply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReplyRequest {
    private Integer id;
    private String message;
    private Integer commentId;
    private Integer salesmanId;
}
