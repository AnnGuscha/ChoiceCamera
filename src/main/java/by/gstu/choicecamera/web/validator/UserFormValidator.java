package by.gstu.choicecamera.web.validator;

import by.gstu.choicecamera.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (User.class.equals(target.getClass())) {
            User user = (User) target;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty.userForm.login");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
            //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmpassword", "NotEmpty.userForm.confirmpassword");
        }
    }
}
