package sprint.test.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sprint.test.model.User;
import sprint.test.service.UserService;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printListUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "helloList";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping("/new")
    public String create(User user) {
        return "create";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            userService.addUser(user);
            return "redirect:/";
        }
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute(userService.getUserById(id));
        return "edit";
    }
    @PatchMapping("/edit/{id}")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            userService.updateUser(user);
            return "redirect:/";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
