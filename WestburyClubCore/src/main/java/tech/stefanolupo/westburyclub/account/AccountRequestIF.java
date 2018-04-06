package tech.stefanolupo.westburyclub.account;

import com.hubspot.immutables.style.HubSpotStyle;
import org.immutables.value.Value;

@Value.Immutable
@HubSpotStyle
public interface AccountRequestIF extends AccountCore {

    @Value.Lazy
    default Account toAccount(int id) {
        return Account.builder()
                .setId(id)
                .setFirstName(getFirstName())
                .setLastName(getLastName())
                .setEmail(getEmail())
                .setPhoneNumber(getPhoneNumber())
                .build();
    }
}
