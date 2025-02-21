package com.github.food2gether.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "restaurants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String displayName;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuItem> menu;

    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Address {

        @Column(name = "address_street", nullable = false)
        private String street;

        @Column(name = "address_city", nullable = false)
        private String city;

        @Column(name = "address_postal_code", nullable = false)
        private String postalCode;

        @Column(name = "address_county", nullable = false)
        private String country;

    }

}
