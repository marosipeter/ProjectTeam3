package com.teamthree.event.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity

public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private LocalDateTime dateOfBirth; //to rewrite into LocalDate

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_role", referencedColumnName = "role")
    private UserRole userRole;


}
