package com.etiya.ecommercepair3.business.dtos.responses.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDetailResponse {
    private Integer id;

    private String title;

    private String message;

    private Integer productId;

    private Integer customerId;
}
