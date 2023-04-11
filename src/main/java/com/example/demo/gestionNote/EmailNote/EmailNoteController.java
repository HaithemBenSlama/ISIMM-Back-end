package com.example.demo.gestionNote.EmailNote;

import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/chargeNote/EmailNote")
public class EmailNoteController {

    private final EmailNoteService emailNoteService;

    public EmailNoteController(EmailNoteService emailNoteService) {
        this.emailNoteService = emailNoteService;
    }

    @GetMapping("/{mail}")
    public void getnewpassword(@PathVariable String mail) throws MessagingException {

    }
}
