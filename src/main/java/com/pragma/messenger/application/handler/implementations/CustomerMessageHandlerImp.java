package com.pragma.messenger.application.handler.implementations;

import com.pragma.messenger.application.dto.CustomerMessageDto;
import com.pragma.messenger.application.handler.interfaces.ICustomerMessageHandler;
import com.pragma.messenger.application.mapper.CustomerMessageDtoMapper;
import com.pragma.messenger.domain.api.ICustomerMessageServicePort;
import com.pragma.messenger.domain.model.CustomerMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
public class CustomerMessageHandlerImp implements ICustomerMessageHandler {
    private final ICustomerMessageServicePort customerMessageServicePort;
    public final CustomerMessageDtoMapper messageDtoMapper;
    @Override
    public void sendConfirmationPin(CustomerMessageDto customerMessageDto) {
        CustomerMessage customerMessage = messageDtoMapper.toDomain(customerMessageDto);
        customerMessage.setPin(generatePin());
        customerMessageServicePort.sendConfirmationPin(customerMessage);
    }
    private static int generatePin() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder pinBuilder = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int digit = secureRandom.nextInt(10);
            pinBuilder.append(digit);
        }

        return Integer.parseInt(pinBuilder.toString());
    }
}
