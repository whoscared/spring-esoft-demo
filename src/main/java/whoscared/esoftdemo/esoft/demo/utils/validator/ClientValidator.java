package whoscared.esoftdemo.esoft.demo.utils.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import whoscared.esoftdemo.esoft.demo.models.people.Client;
import whoscared.esoftdemo.esoft.demo.services.ClientService;

@Component
public class ClientValidator implements Validator {
    private final ClientService clientService;

    @Autowired
    public ClientValidator(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Client client = (Client) target;

        if (client.getEmail().isEmpty() && client.getPhone().isEmpty()) {
            errors.rejectValue("email", "", "You must fill in one of the fields: email or number");
        }

        else if (!client.getEmail().isEmpty() && clientService.findByEmail(client.getEmail()) != null) {
            errors.rejectValue("email", "", "Client with this email already exist");
        }
    }
}
