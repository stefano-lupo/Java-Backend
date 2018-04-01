package tech.stefanolupo.westburyclub.service.Resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import tech.stefanolupo.westburyclub.account.Account;
import tech.stefanolupo.westburyclub.account.AccountRequest;
import tech.stefanolupo.westburyclub.data.AccountService;
import tech.stefanolupo.westburyclub.data.daos.AccountDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    private final AccountService accountService;
    private final AccountDao accountDao;

    @Inject
    public AccountResource(AccountService accountService, AccountDao accountDao) {
        this.accountService = accountService;
        this.accountDao = accountDao;
    }

    @POST
    public Account createAccount(AccountRequest accountRequest) {
        return null;
    }

    @GET
    @Timed
    @Path("{id}")
    public Account getAccountById(@PathParam("id") int id) {
        return accountDao.getAccountById(id);
    }
}
