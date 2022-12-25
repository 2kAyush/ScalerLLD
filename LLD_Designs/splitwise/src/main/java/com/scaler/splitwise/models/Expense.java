package com.scaler.splitwise.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Expense extends BaseModel {
    private String description;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @ManyToOne
    private User createdBy;
    @ManyToMany
    private List<User> participants;
    private Date createdAt;
}
