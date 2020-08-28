package com.example.portfolio.dto;

import com.opencsv.bean.CsvBindByName;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "first_name", length = 64, nullable = false)
    @CsvBindByName
    private String firstName;
    @Column(name = "last_name", length = 64, nullable = false)
    @CsvBindByName
    private String lastName;
}
