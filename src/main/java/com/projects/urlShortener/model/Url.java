package com.projects.urlShortener.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long urlId;

    private String originUrl;

    @Column(unique = true)
    private String shortCode;

    private LocalDateTime createdAt;
}
