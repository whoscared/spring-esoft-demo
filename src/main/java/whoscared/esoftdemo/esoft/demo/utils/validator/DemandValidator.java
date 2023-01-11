package whoscared.esoftdemo.esoft.demo.utils.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import whoscared.esoftdemo.esoft.demo.models.Demand;

@Component
public class DemandValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Demand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Demand demand = (Demand) target;

        if (demand.getTypeOfRealEstate() == null) {
            errors.rejectValue("typeOfRealEstate", "", "You need to choose type of real estate");
        }
        if (demand.getRealtor() == null) {
            errors.rejectValue("realtor", "", "You need to choose realtor");
        }
        if (demand.getClient() == null) {
            errors.rejectValue("realtor", "", "You need to choose client");
        }

        if ((demand.getMinFloat() != null && demand.getMaxFloat() != null) && demand.getMaxFloat() < demand.getMinFloat()) {
            errors.rejectValue("maxFloat", "", "Min float cannot be greater than Max float");
        }
        if ((demand.getMinRoom() != null && demand.getMaxRoom() != null) && demand.getMaxRoom() < demand.getMinRoom()) {
            errors.rejectValue("maxRoom", "", "Min count of room cannot be greater than Max ");
        }
        if ((demand.getMinArea() != null && demand.getMaxArea() != null) && demand.getMaxArea() < demand.getMinArea()) {
            errors.rejectValue("maxArea", "", "Min area cannot be greater than Max area");
        }
    }
}
