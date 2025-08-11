package br.com.movieflix.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "streaming")
@Builder
public class Streaming {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)
    private String name;

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

    public Streaming() {
    }

    public Streaming(String name, Long id) {
        this.name = name;
        this.id = id;
    }
}
