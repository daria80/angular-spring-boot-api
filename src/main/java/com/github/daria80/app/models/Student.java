package com.github.daria80.app.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Student {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String major;
    private long birthday;

}
