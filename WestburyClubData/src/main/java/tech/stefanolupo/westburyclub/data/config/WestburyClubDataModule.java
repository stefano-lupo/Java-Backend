package tech.stefanolupo.westburyclub.data.config;

import com.google.common.collect.ImmutableList;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.skife.jdbi.v2.DBI;
import tech.stefanolupo.westburyclub.data.daos.AccountDao;
import tech.stefanolupo.westburyclub.data.DatabaseWrapper;
import tech.stefanolupo.westburyclub.data.daos.PokerDao;

public class WestburyClubDataModule extends AbstractModule {

    private final static ImmutableList<Class<?>> UNBOUND_DAOS = ImmutableList.of(
            AccountDao.class
    );

    private DBI dbi;

    @Override
    protected void configure() {
        this.dbi = new DatabaseWrapper().getDbi();
    }

    @Provides
    AccountDao providesAccountDao() {
        return dbi.open(AccountDao.class);
    }

    @Provides
    PokerDao providesPokerDao() {
        return dbi.open(PokerDao.class);
    }
}
