package com.teamthree.event.service;

import com.teamthree.event.domain.Ticket;
import com.teamthree.event.dto.TicketInsertDto;
import com.teamthree.event.dto.TicketViewDto;

import java.util.List;

public interface TicketService {

    void buy (TicketInsertDto ticketInsertDto);

    List<TicketViewDto> getAll ();

}
