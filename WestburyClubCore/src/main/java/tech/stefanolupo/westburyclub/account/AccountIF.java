package tech.stefanolupo.westburyclub.account;

import com.hubspot.immutables.style.HubSpotStyle;
import org.immutables.value.Value;

@Value.Immutable
@HubSpotStyle
public interface AccountIF extends AccountCore {
    int getId();
}
