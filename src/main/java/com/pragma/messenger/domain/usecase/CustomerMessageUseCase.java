package com.pragma.messenger.domain.usecase;

import com.pragma.messenger.domain.api.ICustomerMessageServicePort;
import com.pragma.messenger.domain.model.CustomerMessage;
import com.pragma.messenger.domain.spi.ICustomerMessagePersistencePort;

public class CustomerMessageUseCase implements ICustomerMessageServicePort {
    private final ICustomerMessagePersistencePort customerMessagePersistencePort;

    public CustomerMessageUseCase(ICustomerMessagePersistencePort customerMessagePersistencePort) {
        this.customerMessagePersistencePort = customerMessagePersistencePort;
    }

    @Override
    public void sendConfirmationPin(CustomerMessage customerMessage) {
        customerMessagePersistencePort.sendConfirmationPin(customerMessage);
    }
}
