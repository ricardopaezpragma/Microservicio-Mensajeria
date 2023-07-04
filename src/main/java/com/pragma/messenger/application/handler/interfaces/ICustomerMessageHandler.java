package com.pragma.messenger.application.handler.interfaces;


import com.pragma.messenger.application.dto.CustomerMessageDto;

public interface ICustomerMessageHandler {
    void sendConfirmationPin(CustomerMessageDto customerMessage);
}
