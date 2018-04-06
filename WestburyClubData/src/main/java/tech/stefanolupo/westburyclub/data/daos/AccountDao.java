package tech.stefanolupo.westburyclub.data.daos;

import com.hubspot.rosetta.jdbi.BindWithRosetta;
import com.hubspot.rosetta.jdbi.RosettaMapperFactory;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import tech.stefanolupo.westburyclub.account.Account;
import tech.stefanolupo.westburyclub.account.AccountRequestIF;

import java.util.Collection;

@RegisterMapperFactory(RosettaMapperFactory.class)
public interface AccountDao {

    String TABLE_NAME = "account";
    String COLUMNS = "id, firstName, lastName, email, phoneNumber";
    String SELECTOR = COLUMNS + " from " + TABLE_NAME;

    @SqlQuery("select " + SELECTOR)
    Collection<Account> getAccounts();

    @SqlQuery("select " + SELECTOR + " where id = :id")
    Account getAccountById(@Bind("id") long id);

    @GetGeneratedKeys
    @SqlUpdate("insert into " + TABLE_NAME + "(firstName, lastName, email, phoneNumber)" + " values " +
            "(:firstName, :lastName, :email, :phoneNumber)")
    int createAccount(@BindWithRosetta AccountRequestIF accountEgg);

    @SqlUpdate("update " + TABLE_NAME + " set firstName = :firstName, lastName = :lastName, email = :email," +
            " phoneNumber = :phoneNumber where id = :id")
    int updateAccount(@BindWithRosetta Account account);
}
