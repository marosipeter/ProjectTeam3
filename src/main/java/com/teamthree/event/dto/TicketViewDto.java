package com.teamthree.event.dto;

import com.teamthree.event.domain.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketViewDto implements Serializable {

    private String eventName;
    private String userName;

    public static TicketViewDto toTicketViewDto(Ticket ticket) {
        TicketViewDto tck = new TicketViewDto();
        tck.eventName = ticket.getEvent().getName();
        tck.userName = ticket.getUser().getEmail();
        return tck;
    }
}
