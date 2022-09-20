package com.itstep.firstspring.repos;

import com.itstep.firstspring.entities.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
