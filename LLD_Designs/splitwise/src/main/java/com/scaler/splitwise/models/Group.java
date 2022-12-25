package com.scaler.splitwise.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group extends BaseModel{
    private String name;
    @ManyToMany
    private List<User> participants;
    @ManyToMany
    private List<User> admins;
    @ManyToOne
    private User createdBy;
    private Date createdAt;
}
