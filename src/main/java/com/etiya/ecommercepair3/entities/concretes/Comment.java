package com.etiya.ecommercepair3.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="message")
    private String message;

    @OneToOne(mappedBy = "comment")
    private Reply reply;

    @ManyToOne()
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne()
    @JoinColumn(name="customer_id")
    private Customer customer;


}
