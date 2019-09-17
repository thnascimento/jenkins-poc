package br.com.dimed.jenkinspoc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jenkins-poc/")
public class MessageController {

    @GetMapping
    public String message() {
        return "I'm deployed!";
    }
}
