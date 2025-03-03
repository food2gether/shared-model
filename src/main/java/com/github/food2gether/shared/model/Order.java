package com.github.food2gether.shared.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private State state = State.OPEN;

    public enum State {
        OPEN,
        SUBMITTED,
        PAYED,
        REJECTED
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DTO {

        private Long id;
        private List<OrderItem.DTO> items;
        private Long profileId;
        private State state;

        public static DTO fromOrder(Order order) {
            return new DTO(
                order.getId(),
                order.getItems().stream().map(OrderItem.DTO::fromOrderItem).toList(),
                order.getProfile().getId(),
                order.getState()
            );
        }
    }

}
