package com.pragma.messenger.infrastructure.output.twilio.adapter;

import com.pragma.messenger.domain.model.CustomerMessage;
import com.pragma.messenger.domain.spi.ICustomerMessagePersistencePort;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;

public class TwilioAdapter implements ICustomerMessagePersistencePort {
    @Value("${twilio.account_sid}")
    public String accountSid;
    @Value("${twilio.auth_token}")
    public String authToken;
    @Value("${twilio.trail_number}")
    public String trailNumber;


    @Override
    public void sendConfirmationPin(CustomerMessage customerMessage) {
        Twilio.init(accountSid, authToken);
        PhoneNumber to = new PhoneNumber(customerMessage.getCustomerPhone());
        PhoneNumber from = new PhoneNumber(trailNumber);
        String bodyMessage = "Hola, este es tu pin de seguridad: " + customerMessage.getPin() + " " +
                "para tu pedido N°" + customerMessage.getOrderId();

        Message message = Message.creator(to, from,
                        bodyMessage)
                .create();
    }
}
