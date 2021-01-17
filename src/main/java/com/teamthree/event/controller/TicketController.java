package com.teamthree.event.controller;


import com.teamthree.event.domain.*;
import com.teamthree.event.dto.EventViewDto;
import com.teamthree.event.dto.TicketInsertDto;
import com.teamthree.event.dto.TicketViewDto;
import com.teamthree.event.service.EventServiceImpl;
import com.teamthree.event.service.impl.TicketServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/ticket" )
public class TicketController {

    private final TicketServiceImpl ticketService;

    public TicketController (TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(value = "/getAll")
    public List<TicketViewDto> getAll() {

        return ticketService.getAll();
    }

    @PutMapping(value = "/buy")
    public void buy () {

        ticketService.buy(new TicketInsertDto(1L,5L));

    }

}
