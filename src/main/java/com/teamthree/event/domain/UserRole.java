
package com.teamthree.event.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity

public class UserRole {

    @Id
    @Column(length = 20)
    @Enumerated(value = EnumType.STRING)
    private Role role;
}

