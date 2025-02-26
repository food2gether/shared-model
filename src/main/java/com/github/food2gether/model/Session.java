package com.github.food2gether.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "sessions")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Order> orders;

    @OneToOne
    private Restaurant restaurant;

    @OneToOne
    private Profile organizer;

    @Column(nullable = false)
    private LocalDateTime deadline;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DTO {

        private Long id;
        private Long restaurantId;
        private Long organizerId;
        private LocalDateTime deadline;

        public static DTO fromSession(Session session) {
            return new DTO(
                session.getId(),
                session.getRestaurant().getId(),
                session.getOrganizer().getId(),
                session.getDeadline()
            );
        }

    }

}
