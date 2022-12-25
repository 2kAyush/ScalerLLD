package com.scaler.splitwise.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class UserExpensePaidBy extends BaseModel {
    @ManyToOne
    private User user;
    @ManyToOne
    private Expense expense;
    private int amount;
}
