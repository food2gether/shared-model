package com.github.food2gether.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "contact_information")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false) // Foreign key to profile
    private Profile profile;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String value;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DTO {
        public Long id;
        public Long profileId;
        public String type;
        public String value;

        public static DTO fromContactInformation(ContactInformation contactInformation) {
            return new DTO(
                contactInformation.getId(),
                contactInformation.getProfile().getId(),
                contactInformation.getType(),
                contactInformation.getValue()
            );
        }
    }

}
