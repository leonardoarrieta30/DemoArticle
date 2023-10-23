package com.example.demo.Application.domain.model;

import com.example.demo.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "categories")
public class Category extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String Image;


//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER, mappedBy = "category")
//    private Set<Article> articles = new HashSet<>();


}
