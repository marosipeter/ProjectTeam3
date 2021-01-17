package com.teamthree.event.repository;

import com.teamthree.event.domain.Ticket;
import com.teamthree.event.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
