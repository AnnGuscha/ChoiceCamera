package by.gstu.choicecamera.web.controller;

import by.gstu.choicecamera.domain.User;
import by.gstu.choicecamera.service.UserService;
import by.gstu.choicecamera.util.SessionUtil;
import by.gstu.choicecamera.web.validator.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    public UserService userService;
    @Autowired
    UserFormValidator userFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userFormValidator);
    }


    // edit user
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("userForm") @Validated User user,
                           BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "user/userForm";
        } else {
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
            userService.edit(user);

            // POST/REDIRECT/GET
            return "redirect:/user";
        }

    }

    // show update form
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showUserForm(Model model) {

        User user = userService.get(SessionUtil.getSessionUser().getId());
        model.addAttribute("userForm", user);

        return "user/userForm";

    }

    // delete user
    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public String deleteUser(final RedirectAttributes redirectAttributes) {

        userService.remove(SessionUtil.getSessionUser().getId());

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "User is deleted!");

        return "redirect:/index";

    }
}
