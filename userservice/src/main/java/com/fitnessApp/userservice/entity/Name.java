package com.fitnessApp.userservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Name {
        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;
}
