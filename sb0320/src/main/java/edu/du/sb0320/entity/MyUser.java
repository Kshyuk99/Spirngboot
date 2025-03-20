package edu.du.sb0320.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "myuser") // DB table 이름 지정
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {createdAt = LocalDateTime.now();}
}
