package whoscared.esoftdemo.esoft.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import whoscared.esoftdemo.esoft.demo.models.Client;
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

        if (clientService.findByEmail(client.getEmail()) != null) {
            errors.rejectValue("email", "", "Client with this email already exist");
        }
    }
}
