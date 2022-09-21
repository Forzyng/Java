package com.example.newspring.controllers;

import com.example.newspring.entities.Contact;
import com.example.newspring.repos.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class ContactController {
    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

   // Read Route
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("contacts", contactRepository.findAll());
        return "index";
    }

    // Create Route Return index

    @GetMapping("/contacts/create")
    public String create(){
        return "index";
    }

    // Update Route return contact-update with Contact

    @GetMapping("/contacts/update/{id}")
    public String updateR(
            Model model,
            @PathVariable(name="id") Long id
    ){
        Contact p = contactRepository.findById(id).get();
        model.addAttribute("contact", p);
        return "contact-update";
    }

    // Delete

    @GetMapping("/contacts/delete/{id}")
    public RedirectView delete(
            @PathVariable(name="id") Long id
    ) {
        contactRepository.deleteById(id);
        return new RedirectView("/");
    }

    // Create

    @PostMapping("/contacts/create")
    public RedirectView create(Contact contact){
        contactRepository.save(contact);
        return new RedirectView("/");
    }

   /* // Update

    @PostMapping("/contacts/update/{id}")
    public RedirectView update(Contact contact, @PathVariable(name="id") Long id){
        Contact p = contactRepository.findById(id).get();
        p
        return new RedirectView("/");
    }*/

}
