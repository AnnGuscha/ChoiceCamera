package by.gstu.choicecamera.web.validator;

import by.gstu.choicecamera.domain.Expert;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ExpertFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (Expert.class.equals(target.getClass())) {
            Expert expert = (Expert) target;

//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.expertForm.name");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.expertForm.price");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "releaseDate", "NotEmpty.cameraForm.releaseDate");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "matrixDot", "NotEmpty.cameraForm.matrixDot");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apertureMin", "NotEmpty.cameraForm.apertureMin");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apertureMax", "NotEmpty.cameraForm.apertureMax");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manufacturer", "NotEmpty.cameraForm.manufacturer");

//            if (expert.getManufacturer().equalsIgnoreCase("none")) {
//                errors.rejectValue("marks", "NotEmpty.expertForm.marks");
//            }
        }
    }
}
