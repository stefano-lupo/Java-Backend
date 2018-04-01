package tech.stefanolupo.westburyclub.service;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import tech.stefanolupo.westburyclub.account.Account;
import tech.stefanolupo.westburyclub.account.AccountRequest;
import tech.stefanolupo.westburyclub.data.daos.AccountDao;
import tech.stefanolupo.westburyclub.data.AccountService;
import tech.stefanolupo.westburyclub.service.config.WestburyClubServiceModule;

public class TestClient {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new WestburyClubServiceModule());
        TestClient testClient = injector.getInstance(TestClient.class);
        System.out.println(testClient.fetchAccountFromService());
        System.out.println(testClient.fetchAccountFromDB());
        System.out.println(testClient.createAccount());
    }

    private final AccountService accountService;
    private final AccountDao accountDao;

    @Inject
    TestClient(AccountService accountService, AccountDao accountDao) {
        this.accountService = accountService;
        this.accountDao = accountDao;
    }

    Account fetchAccountFromService() {
        return accountService.getAccount();
    }

    Account fetchAccountFromDB() {
        return accountDao.getAccountById(1);
    }

    int createAccount() {
        AccountRequest accountRequest = AccountRequest.builder()
                .setFirstName("Lauren")
                .setLastName("O'Connell")
                .setEmail("oconnel6@tcd.ie")
                .setPhoneNumber("0861223456")
                .build();
        return accountDao.createAccount(accountRequest);
    }
}
