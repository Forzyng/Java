package com.itstep.firstspring.controllers;

import com.itstep.firstspring.entities.Contact;
import com.itstep.firstspring.repos.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ContactFormController {
    private final ContactRepository contactRepository;

    public ContactFormController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping("/contact")
    public String sendContact(
            Contact contact
            /*@RequestParam(value = "name") String name,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "phone") String phone,
            @RequestParam(value = "message") String message*/
    )
    {
        contactRepository.save(contact);
        /*return "Incoming " +
                name + " "
                + email + " " +
                phone + " " +
                message;*/
        return "Ok";
    }

    @GetMapping("/contacts")
    public Iterable<Contact> readAll()
    {
        return contactRepository.findAll();
    }
    @GetMapping("/contacts/{id}")
    public Optional<Contact> readById(
            @PathVariable(name = "id") Long id
    )
    {
        return contactRepository.findById(id);
    }

    @PutMapping("/update-contact/{id}")
    public Contact updateById(@PathVariable(name = "id") Long id,
                           Contact contact)
    {
        return contactRepository.save(contact);
    }

    @DeleteMapping("/delete-contact/{id}")
    public void deleteById(@PathVariable(name = "id") Long id)
    {
        contactRepository.deleteById(id);
    }
}
