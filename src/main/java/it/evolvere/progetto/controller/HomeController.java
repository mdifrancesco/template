package it.evolvere.progetto.controller;

import it.evolvere.progetto.model.User;
import it.evolvere.progetto.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Principal principal) {
        logger.info("calling /index");
        model.addAttribute("nome", principal != null ? principal.getName() : "");
        List<User> list = (List<User>) userRepository.findAll();
        model.addAttribute("clienti", list);
        return "index";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String version() {
        logger.info("calling /welcome");
        return "welcome";
    }



}
