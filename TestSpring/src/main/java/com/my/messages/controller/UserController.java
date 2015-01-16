

package com.my.messages.controller;


import com.my.messages.service.UserService;
import com.my.messages.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/start_page")
    public ModelAndView startPage(Principal principal) {
        String userName =principal.getName();


        Map<String, Object> modelUser = new HashMap<String, Object>();
        modelUser.put("userIdByUserName", userService.getUserIdByUserName(userName));
        return new ModelAndView("start_page","modelUser",modelUser);

    }

    @RequestMapping("/first_page")
    public ModelAndView startPage1() {

        return new ModelAndView("first_page");

    }

    @ModelAttribute("user")
    public User getFormError() {

        return new User();

    }

     @RequestMapping(method = RequestMethod.GET)
    public String displayFormError(ModelMap model) {

        model.addAttribute("user", new User());
        return "creating_user";
    }
    @RequestMapping(value = "/addCreatingUser", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "creating_user";
        } else {


            userService.createUser(user);

            return "redirect:user_list.html";
        }
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {

        userService.deleteUser(id);

        return "redirect:/user_list.html";

    }

    @RequestMapping(value = "/edit_page", method = RequestMethod.GET)
    public String editUser(@RequestParam(value = "id") int id, Model model) {

        model.addAttribute("user", userService.getUserId(id));


        return "edit_page";

    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveEditUs(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "edit_page";
        } else {

            userService.updateUser(user);


            return "redirect:user_list.html";


        }

    }

    @RequestMapping("/user_list")
    public ModelAndView userList(Principal principal) {
        String userName =principal.getName();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("userList", userService.getAllUsers());
        model.put("userName", userName);
        return new ModelAndView("user_list", "model", model);


    }

    @RequestMapping("/edit_page")
    public ModelAndView editPage() {

        return new ModelAndView("edit_page", "user", new User());


    }

    @RequestMapping("/creating_user")
    public ModelAndView creatingUser() {

        return new ModelAndView("creating_user", "user", new User());
    }


}


