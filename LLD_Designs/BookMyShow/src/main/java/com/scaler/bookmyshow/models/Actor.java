package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Actor extends BaseModel{
    private String name;
    @ManyToMany(mappedBy = "actors", fetch = FetchType.EAGER)
    private List<Movie> movies;
}
