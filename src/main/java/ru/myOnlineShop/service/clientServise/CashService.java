package ru.myOnlineShop.service.clientServise;

import ru.myOnlineShop.model.customer.CashAccount;
import ru.myOnlineShop.model.customer.ClientAccount;

public class CashService {

    public CashService() {

    }

    public void cashIn(ClientAccount clientAccount, double cash) {

        clientAccount.getCashAccount().setCash(clientAccount.getCashAccount().getCash() + cash);


    }

    public void cashOut(ClientAccount clientAccount, double cash) {

        clientAccount.getCashAccount().setCash(clientAccount.getCashAccount().getCash() - cash);

    }

}
