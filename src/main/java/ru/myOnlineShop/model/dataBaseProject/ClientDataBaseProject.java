package ru.myOnlineShop.model.dataBaseProject;

import ru.myOnlineShop.model.BuilderObject;
import ru.myOnlineShop.model.customer.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ClientDataBaseProject implements DataBaseProject {
    private Client client;
    private List<Client> clientBase = new ArrayList<>();

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Client> getClientBase() {
        return clientBase;
    }

    public void setClientBase(List<Client> clientBase) {
        this.clientBase = clientBase;
    }


    @Override
    public Client findElement(String name) throws Exception {
        return client;
    }

    @Override
    public void dataBaseWrite(HttpServletRequest request, HttpServletResponse response) {
        try (FileWriter fw = new FileWriter("src/main/dataBase/dataBaseCatalog/ClientBaseInput.txt", true)) {
            Client client = BuilderObject.buildClient(request, response);
            synchronized (this) {
                fw.write(String.valueOf(client));
                fw.write("\n");
                fw.flush();
                response.getWriter().print(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void dataBaseRead(HttpServletRequest request,HttpServletResponse response) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/dataBase/dataBaseCatalog/ClientBaseInput.txt"))) {
            String currentLine = "";
            while ((currentLine = br.readLine()) != null) {
                // System.out.println(currentLine);
                if (!currentLine.isEmpty())
                    clientBase.add(convertStringToBase(currentLine));
            }

            //  System.out.println(clientBase);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Client convertStringToBase(String currentLine) {
        String[] splitted = currentLine.split(" , ");
        Client client = new Client();

        for (String s : splitted) {
            getNameAndSet(s, client);
            getLastNameAndSet(s, client);
            getGenderAndSet(s, client);
            getAgeAndSet(s, client);
            getPhonenumberAndSet(s, client);
            getEmailAndSet(s, client);

        }

        return client;
    }

    @Override
    public void exportFromDataBase() {

        try (FileWriter fw = new FileWriter("src/main/dataBase/dataBaseCatalog/ClientBaseExport.txt")) {
            for (Client client : clientBase)
                fw.write(client + "\n");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void importToDataBase() {

    }

    private static void getNameAndSet(String s, Client client) {
        if (s != null && s.contains("Имя:")) {
            client.setName(s.split(":")[1]);
        }
    }

    private static void getLastNameAndSet(String s, Client client) {
        if (s != null && s.contains("Фамилия:")) {
            client.setLastName(s.split(":")[1]);
        }
    }

    private static void getGenderAndSet(String s, Client client) {
        if (s != null && s.contains("Пол:")) {
            client.setGender(s.split(":")[1]);
        }
    }

    private static void getAgeAndSet(String s, Client client) {
        if (s != null && s.contains("Возраст:")) {
            client.setAge(Integer.parseInt(s.split(":")[1]));
        }
    }

    private static void getPhonenumberAndSet(String s, Client client) {
        if (s != null && s.contains("Номер телефона:")) {
            client.setPhoneNumber(s.split(":")[1]);
        }
    }

    private static void getEmailAndSet(String s, Client client) {
        if (s != null && s.contains("Email:")) {
            client.setEmail(s.split(":")[1]);
        }
    }

}


