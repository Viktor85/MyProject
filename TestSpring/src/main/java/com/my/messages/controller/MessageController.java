package com.my.messages.controller;


import com.my.messages.model.Message;
import com.my.messages.service.MessageService;
import com.my.messages.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;


@Controller
@SessionAttributes

public class MessageController {


    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    @ModelAttribute("mess")
    public Message getFormErrorMessage() {

        return new Message();

    }






    @RequestMapping(value = "/addSendMessage", method = RequestMethod.POST)
    public String addMessage(@ModelAttribute("mess")@Valid Message message, BindingResult result) {
        if (result.hasErrors()) {
            return "send_message";
        } else {
        messageService.addMessage(message);
        return "redirect:sending_message.html";
    }
    }
    @RequestMapping("/deleteMessage/{id}")
    public String deleteMessage(@PathVariable("id") int id) {
        messageService.deleteMessage(id);
        return "redirect:/sending_message/{id}";
    }


    @RequestMapping("/sending_message")
    public ModelAndView sendingMessage(Principal principal) {
        String userName =principal.getName();
        Map<String, Object> modelSendingMessage = new HashMap<String, Object>();
        modelSendingMessage.put("userName", userName);
        modelSendingMessage.put("messageList", messageService.getAllSendingMessage() );
        return new ModelAndView("sending_message", "modelSendingMessage", modelSendingMessage);
    }





    @RequestMapping("/incoming_message")
    public ModelAndView incomingMessage() {
        Map<String, Object> modelIncomingMessage = new HashMap<String, Object>();
        modelIncomingMessage.put("messageList", messageService.getAllIncomingMessage());
        return new ModelAndView("incoming_message", "modelIncomingMessage", modelIncomingMessage);

    }

    @RequestMapping("/incoming_message/{id}")
    public ModelAndView incomingMessageById(@PathVariable("id") int id,Principal principal) {
        String userName =principal.getName();


        Map<String, Object> modelIncomingMessage = new HashMap<String, Object>();
        modelIncomingMessage.put("messageList", messageService.getIncomingMessagesForUser(id));
        modelIncomingMessage.put("userNameById", userService.getUserNameById(id));
        modelIncomingMessage.put("userName", userName);
        return new ModelAndView("incoming_message", "modelIncomingMessage", modelIncomingMessage);

    }
    @RequestMapping(value ="/sending_message/{id}")
    public ModelAndView sendingMessageById(@PathVariable("id") int id, Principal principal) {
        String userName =principal.getName();
        Map<String, Object> modelSendingMessage = new HashMap<String, Object>();
        modelSendingMessage.put("messageList", messageService.getSendingMessagesForUser(id));
        modelSendingMessage.put("userNameById", userService.getUserNameById(id));
        modelSendingMessage.put("userName", userName);
        return new ModelAndView("sending_message", "modelSendingMessage", modelSendingMessage);
    }

    @RequestMapping("/send_message")
    public ModelAndView sendMessage() {

        return new ModelAndView("send_message", "command", new Message());
    }



}








