package by.gstu.choicecamera.web.validator;

import by.gstu.choicecamera.domain.Camera;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CameraFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (Camera.class.equals(target.getClass())) {
            Camera camera = (Camera) target;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.cameraForm.name");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.cameraForm.price");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "releaseDate", "NotEmpty.cameraForm.releaseDate");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "matrixDot", "NotEmpty.cameraForm.matrixDot");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apertureMin", "NotEmpty.cameraForm.apertureMin");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apertureMax", "NotEmpty.cameraForm.apertureMax");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manufacturer", "NotEmpty.cameraForm.manufacturer");

            if (camera.getManufacturer().equalsIgnoreCase("none")) {
                errors.rejectValue("manufacturer", "NotEmpty.cameraForm.manufacturer");
            }
        }
    }
}
