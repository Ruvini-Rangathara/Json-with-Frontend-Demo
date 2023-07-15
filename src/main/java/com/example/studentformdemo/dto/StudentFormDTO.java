package com.example.studentformdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity(name="studentForm")
public class StudentFormDTO implements Serializable {
    @Id
    private String name;
    private String city;
    private String email;
    private int level;

}
