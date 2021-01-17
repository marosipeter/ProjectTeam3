
package com.teamthree.event.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")
@Entity

public class Event implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private LocalDateTime date; //to rewrite into LocalDate
/*    @Column(nullable = false)
    private String startTime;*/
    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @Column
    private Integer ageLimit;
    @Column(nullable = false)
    private Integer maxTicketNumber;
    @Column(nullable = false)
    private Integer soldTicketNumber;
    @Column(nullable = false)
    private Double ticketPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_type", referencedColumnName = "type")
    private EventType eventType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

}

