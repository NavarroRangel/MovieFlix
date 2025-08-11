package br.com.movieflix.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.experimental.UtilityClass;

@Entity
@Table(name = "category")
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)
    private String name;


    public Category(Long categoryId) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
    }

}
