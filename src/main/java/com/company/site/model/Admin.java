package com.company.site.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Admin {

    @Id
    private String username;
    private String password;
}
