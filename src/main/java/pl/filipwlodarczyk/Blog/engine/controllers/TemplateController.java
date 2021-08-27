package pl.filipwlodarczyk.Blog.engine.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TemplateController {

    @GetMapping
    public String getMainPage() {
        return "index";
    }

    @GetMapping("registration")
    public String getRegistrationPage() {
        return "registration";
    }

    //TODO: get profile page by id
//    @GetMapping
//    public String getProfilePage() {
//        return "profile id";
//    }
}
