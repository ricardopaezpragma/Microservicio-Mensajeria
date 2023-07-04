package com.pragma.messenger.infrastructure.configuration;

import com.pragma.messenger.domain.api.ICustomerMessageServicePort;
import com.pragma.messenger.domain.spi.ICustomerMessagePersistencePort;
import com.pragma.messenger.domain.usecase.CustomerMessageUseCase;
import com.pragma.messenger.infrastructure.output.twilio.adapter.TwilioAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ICustomerMessageServicePort customerMessageServicePort(){
        return new CustomerMessageUseCase(customerMessagePersistencePort());
    }
    @Bean
    public ICustomerMessagePersistencePort customerMessagePersistencePort(){
        return new TwilioAdapter();
    }
}
