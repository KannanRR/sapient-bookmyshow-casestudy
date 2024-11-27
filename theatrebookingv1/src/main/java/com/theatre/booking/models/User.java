package com.theatre.booking.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseModel {
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

}