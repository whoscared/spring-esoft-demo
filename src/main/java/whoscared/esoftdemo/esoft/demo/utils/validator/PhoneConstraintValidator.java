package whoscared.esoftdemo.esoft.demo.utils.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import whoscared.esoftdemo.esoft.demo.utils.annotation.Phone;

//реализация проверки телефонного номера на корректность
public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone phone) {
    }

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
        if (phoneField.isEmpty()) {
            return true;
        }
        return phoneField.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
    }
}
