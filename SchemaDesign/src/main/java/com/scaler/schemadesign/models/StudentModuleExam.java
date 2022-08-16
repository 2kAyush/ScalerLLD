package com.scaler.schemadesign.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class StudentModuleExam extends BaseModel {
    @ManyToOne
    private Student student;
    @ManyToOne
    private ModuleExam moduleExam;
    private int marks;
}
