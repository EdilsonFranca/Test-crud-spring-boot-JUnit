package com.example.TestJunit.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@Entity
@Table
public class Product {
    @Id
    private Long id;

    private String name;

    @Column(name="description")
    private String description;

    private Double price;
}
