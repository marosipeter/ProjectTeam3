package com.teamthree.event.dto;

import com.teamthree.event.domain.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketInsertDto {

    private Long eventId;
    private Long userId;

/*    public static TicketInsertDto toTicketInsertDto (Ticket ticket) {
        TicketInsertDto tck = new TicketInsertDto();
        tck.eventID = ticket.getEvent().getName();
        tck.customerEmail = ticket.getUser().getEmail();
        return tck;
    }*/

}
