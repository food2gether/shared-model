package com.github.food2gether.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String displayName;

    @Column(nullable = true)
    private String profilePictureUrl;

    // TODO Replace email with ref to account
    @Column(nullable = false, unique = true)
    private String primaryEmail;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContactInformation> contactInformation;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DTO {

        private Long id;
        private String name;
        private String displayName;
        private String profilePictureUrl;
        private String primaryEmail;

        public static Profile.DTO fromProfile(Profile profile) {
            return new Profile.DTO(
                profile.getId(),
                profile.getName(),
                profile.getDisplayName(),
                profile.getProfilePictureUrl(),
                profile.getPrimaryEmail()
            );
        }

    }

}
