package tech.stefanolupo.westburyclub.service.config;

import com.google.inject.AbstractModule;
import tech.stefanolupo.westburyclub.data.config.WestburyClubDataModule;

public class WestburyClubServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new WestburyClubDataModule());
    }
}
