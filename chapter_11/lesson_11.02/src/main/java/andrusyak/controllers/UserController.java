package andrusyak.controllers;

import andrusyak.models.User;
import andrusyak.storages.UserStorage;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by bogdan on 9/13/16.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final UserStorage userStorage;

    @Autowired
    public UserController(final UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@ModelAttribute User user) {
        this.userStorage.add(user);
        return "redirect:car/viewall";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("name") String name, @RequestParam("login") String login, @RequestParam("password") String password) {

        this.userStorage.add(new User(name, login, password));
        return "redirect:/car/viewall.do";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ModelMap modelMap, HttpSession session, @RequestParam("login") String login, @RequestParam("password") String password) {
        if (login.equals("") || password.equals("")) {
            modelMap.addAttribute("error", "Credential invalid");
            return "AuthForm";
        } else {
            Optional<User> result = this.userStorage.findByCredential(login, password);
            if(result.isPresent()) {
                User user = result.get();
                synchronized (session) {
                    session.setAttribute("user", user);
                }
                return "AuthForm";
            } else {
                modelMap.addAttribute("error", "Credential invalid");
                return "AuthForm";
            }
        }
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String authenticationForm() {
        return "AuthForm";
    }
}
