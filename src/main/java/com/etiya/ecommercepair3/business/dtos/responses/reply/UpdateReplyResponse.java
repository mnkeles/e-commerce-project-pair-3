package com.etiya.ecommercepair3.business.dtos.responses.reply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReplyResponse {
    private Integer id;
    private String message;
    private Integer commentId;
    private Integer salesmanId;
}
