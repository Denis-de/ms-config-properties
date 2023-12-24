package com.exemle.creationbookservice.model;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.integration.annotation.IdempotentReceiver;

@Data
@NoArgsConstructor
public class Book {
    @Id
    private int id;
    private String name;
    private String description;
    private String status;
    private int price;

    @Builder
    public Book(int id, String name, String description, String status, int price) {
        this.id=id;
        this.name=name;
        this.description=description;
        this.status=status;
        this.price=price;
    }
}
