package com.SA.Avatar.Entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Reward {
    @Id
    private String id;
    private String name;
    private String quantity;
    private RewardType type;
    private int price;

    public Reward(String id,String name, String quantity, RewardType type, int price) {
        this.id=id;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.price = price;
    }
}
