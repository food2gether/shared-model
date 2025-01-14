package com.github.food2gether.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "session")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToOne(mappedBy = "id")
    private Restaurant restaurant;

    @OneToOne(mappedBy = "id")
    private Profile organizer;

    @Column(nullable = false)
    private LocalDateTime deadline;

}
