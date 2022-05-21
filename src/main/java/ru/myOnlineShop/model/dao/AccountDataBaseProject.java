package ru.myOnlineShop.model.dao;

import ru.myOnlineShop.model.constanta.StatusAccount;
import ru.myOnlineShop.model.customer.Client;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.model.customer.clientServise.clientAccountService.AccountService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class AccountDataBaseProject {

    private Client client;
    private ClientAccount clientAccount;
    private AccountService accountService;
    private final List<ClientAccount> clientAccountBase = new ArrayList<>();


    public ClientAccount getById(int idAccount) {

        ClientAccount result = new ClientAccount();
        result.setIdAccount(-1);

        for (ClientAccount clientAccount : clientAccountBase) {
            if (clientAccount.getIdAccount() == idAccount) {
                result = clientAccount;
            }
        }

        return result;
    }

    public ClientAccount getUserByLoginPassword(final String login, final String password) {

        ClientAccount result = new ClientAccount();
        result.setIdAccount(-1);

        for (ClientAccount clientAccount : clientAccountBase) {
            if (clientAccount.getLogin().equals(login) && clientAccount.getPassword().equals(password)) {
                result = clientAccount;
            }
        }

        return result;
    }

    public boolean add(final ClientAccount clientAccount) {

        for (ClientAccount clientAccount1 : clientAccountBase) {
            if (clientAccount1.getLogin().equals(clientAccount.getLogin()) && clientAccount1.getPassword().equals(clientAccount.getPassword())) {
                return false;
            }
        }

        return clientAccountBase.add(clientAccount);
    }

    public StatusAccount getRoleByLoginPassword(final String login, final String password,HttpServletRequest request) {
        StatusAccount result = StatusAccount.UNKNOWN;

        for (ClientAccount clientAccount : clientAccountBase) {
            if (clientAccount.getLogin().equals(login) && clientAccount.getPassword().equals(password)) {
                result = clientAccount.getStatusAccount();
                request.getSession().setAttribute("clientAccount",clientAccount);
            }
        }

        return result;
    }

    public boolean clientAccountIsExist(final String login, final String password) {

        boolean result = false;

        for (ClientAccount clientAccount : clientAccountBase) {
            if (clientAccount.getLogin().equals(login) && clientAccount.getPassword().equals(password)) {
                result = true;
                break;
            }
        }

        return result;
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

    public List<ClientAccount> getClientAccountBase() {
        return clientAccountBase;
    }


}
