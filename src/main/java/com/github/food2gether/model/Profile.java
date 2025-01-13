package com.github.food2gether.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "display_name")
    private String displayName;

    @Embedded
    private ContactInformation[] contactInformation;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class ContactInformation {

        private String type;
        private String value;

    }
}
