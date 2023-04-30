package com.etiya.ecommercepair3.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="replys")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="message")
    private String message;

    @OneToOne()
    @JoinColumn(name="comment_id",referencedColumnName="id")
    private Comment comment;

    @ManyToOne()
    @JoinColumn(name="salesman_id")
    private Salesman salesman;




}
