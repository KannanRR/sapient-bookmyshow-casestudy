package com.sapient.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Testb extends BaseModel {

    private String bname;

    @ManyToOne
    @JoinColumn(name = "testa_id")
    @JsonIgnore
    private Testa testa;
}
