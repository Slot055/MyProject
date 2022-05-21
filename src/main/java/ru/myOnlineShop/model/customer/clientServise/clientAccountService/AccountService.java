package ru.myOnlineShop.model.customer.clientServise.clientAccountService;

import ru.myOnlineShop.model.BuilderObject;
import ru.myOnlineShop.model.constanta.StatusAccount;
import ru.myOnlineShop.model.customer.Client;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.model.customer.clientServise.ClientServise;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountService implements ClientServise {
    private Client client;
    private ClientAccount clientAccount;

    public AccountService() {

    }

    public ClientAccount registrationAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ClientAccount clientAccount = BuilderObject.buildClientAccount(request, response);

        return clientAccount;
    }

    public ClientAccount registrationClient(HttpServletRequest request, HttpServletResponse response) {
        ClientAccount clientAccount = (ClientAccount) request.getSession().getAttribute("clientAccount");
        Client client = BuilderObject.buildClient(request, response);
        clientAccount.setClient(client);
        return clientAccount;
    }

    @Override
    public int generateId(Object object) {
        clientAccount = (ClientAccount) object;
        int id = clientAccount.hashCode() / 10;
        if (id < 0) {
            int idFinal = Math.abs(-id);
            clientAccount.setIdAccount(idFinal);
            return clientAccount.getIdAccount();
        } else clientAccount.setIdAccount(id);

        return clientAccount.getIdAccount();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }
}
