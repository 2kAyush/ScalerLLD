package com.scaler.schemadesign.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Exam extends BaseModel{
    private int duration;
    private String name;
}
