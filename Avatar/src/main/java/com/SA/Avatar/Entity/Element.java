package com.SA.Avatar.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Element {
    @Id
    private String id;
    private ElementType elementType;
    private double price;
}
