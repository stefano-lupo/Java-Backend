package tech.stefanolupo.westburyclub.data;

import tech.stefanolupo.westburyclub.account.Account;

public class AccountService {

    public Account getAccount() {
        return Account.builder()
                .setId(1)
                .setFirstName("Stefano")
                .setLastName("Lupo")
                .setEmail("lupos@tcd.ie")
                .setPhoneNumber("0869999999")
                .build();
    }
}
