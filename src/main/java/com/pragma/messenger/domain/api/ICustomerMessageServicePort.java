package com.pragma.messenger.domain.api;

import com.pragma.messenger.domain.model.CustomerMessage;

public interface ICustomerMessageServicePort {
    void sendConfirmationPin(CustomerMessage customerMessage);
}
