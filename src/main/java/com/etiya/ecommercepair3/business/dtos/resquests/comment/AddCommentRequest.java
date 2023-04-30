package com.etiya.ecommercepair3.business.dtos.resquests.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCommentRequest {

    private String title;

    private String message;

    private Integer productId;

    private Integer customerId;
}
