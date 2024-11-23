package com.sapient.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Testa extends BaseModel {

    private String aname;

    @OneToMany(mappedBy = "testa")
    private List<Testb> testb;
}
