package tech.stefanolupo.westburyclub.service.resources;

import com.google.inject.Inject;
import tech.stefanolupo.westburyclub.account.Account;
import tech.stefanolupo.westburyclub.account.AccountRequest;
import tech.stefanolupo.westburyclub.data.daos.AccountDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    private final AccountDao accountDao;

    @Inject
    public AccountResource(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @GET
    public Collection<Account> getAccounts() {
        return accountDao.getAccounts();
    }

    @GET
    @Path("{id}")
    public Account getAccountById(@PathParam("id") int id) {
        return accountDao.getAccountById(id);
    }

    @POST
    public Account createAccount(AccountRequest accountRequest) {
        return accountRequest.toAccount(accountDao.createAccount(accountRequest));
    }

    @PUT
    public Account updateAccount(Account updatedAccount) {
       accountDao.updateAccount(updatedAccount);
       return updatedAccount;
    }
}
