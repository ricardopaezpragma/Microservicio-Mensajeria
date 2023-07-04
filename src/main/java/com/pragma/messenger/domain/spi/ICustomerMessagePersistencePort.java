package com.pragma.messenger.domain.spi;

import com.pragma.messenger.domain.model.CustomerMessage;

public interface ICustomerMessagePersistencePort {
    void sendConfirmationPin(CustomerMessage customerMessage);

}
