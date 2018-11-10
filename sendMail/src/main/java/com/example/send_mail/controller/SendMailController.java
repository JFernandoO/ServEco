package com.example.send_mail.controller;

import com.example.send_mail.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SendMailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/")
    public String index(){
        return "send_mail_view";
    }

    @PostMapping("/sendMail")
    public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("body") String body){

        String message = body +"\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;
        mailService.sendMail("icarojf@gmail.com",mail,subject,message);

        return "send_mail_view";
    }
    
    @PostMapping(value = "/sendMailEco")
	public String postMail(@RequestBody SimpleMailMessage mail) {
    
    	mailService.sendMail("icarojf@gmail.com",mail.getTo()[0],mail.getSubject(),mail.getText());
    	return "send_mail_view";
    }
}
