package ru.myOnlineShop.model.dataBaseProject;

import ru.myOnlineShop.model.constanta.StatusAccount;
import ru.myOnlineShop.model.customer.Client;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.model.customer.clientServise.clientAccountService.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountDataBaseProject implements DataBaseProject {

    private Client client;
    private ClientAccount clientAccount;
    private AccountService accountService;
    private final List<ClientAccount> clientAccountBase = new ArrayList<>();

    @Override
    public ClientAccount findElement(String name) throws Exception {
        return clientAccount;
    }

    @Override
    public void dataBaseWrite(HttpServletRequest request, HttpServletResponse response) {
        try (FileWriter fw = new FileWriter("src/main/dataBase/dataBaseCatalog/AccountBaseInput.txt", true)) {
            accountService = new AccountService();
            clientAccount = accountService.registrationAccount(request, response);
            fw.write(String.valueOf(clientAccount));
            fw.write("\n");
            fw.flush();
            response.getWriter().print(clientAccount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void dataBaseRead(HttpServletRequest request, HttpServletResponse response) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/dataBase/dataBaseCatalog/AccountBaseInput.txt"))) {
            String currentLine = "";
            while ((currentLine = br.readLine()) != null) {
                // System.out.println(currentLine);
                if (!currentLine.isEmpty())
                    clientAccountBase.add(convertStringToBase(currentLine));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ClientAccount convertStringToBase(String currentLine) {
        String[] splitted = currentLine.split(" , ");
        ClientAccount clientAccount = new ClientAccount();

        for (String s : splitted) {
            getLoginAndSet(s, clientAccount);
            getPasswordAndSet(s, clientAccount);
            getIdAccountAndSet(s, clientAccount);
            getStatusAccountAndSet(s, clientAccount);
        }

        return clientAccount;
    }

    @Override
    public void exportFromDataBase() {

        try (FileWriter fw = new FileWriter("src/main/dataBase/dataBaseCatalog/AccountBaseExport.txt")) {
            for (ClientAccount clientAccount : clientAccountBase)
                fw.write(clientAccount + "\n");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void importToDataBase() {

    }

    private static void getLoginAndSet(String s, ClientAccount clientAccount) {
        if (s != null && s.contains("Логин:")) {
            clientAccount.setLogin(s.split(":")[1]);
        }
    }

    private static void getPasswordAndSet(String s, ClientAccount clientAccount) {
        if (s != null && s.contains("Пароль:")) {
            clientAccount.setPassword(s.split(":")[1]);
        }
    }

    private static void getIdAccountAndSet(String s, ClientAccount clientAccount) {
        if (s != null && s.contains("Номер аккаунта:")) {
            clientAccount.setIdAccount(Integer.parseInt(s.split(":")[1]));
        }
    }

    private static void getStatusAccountAndSet(String s, ClientAccount clientAccount) {
        if (s != null && s.contains("Статус:")) {
            clientAccount.setStatusAccount(StatusAccount.valueOf(s.split(":")[1]));
        }
    }

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
