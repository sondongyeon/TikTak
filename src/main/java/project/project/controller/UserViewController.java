package project.project.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class UserViewController {
    @GetMapping("/login")
    public String login() {
        return "oauthlogin";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/videoList")
    public String videoList(Model model) {

        return "videoList";
    }
}
