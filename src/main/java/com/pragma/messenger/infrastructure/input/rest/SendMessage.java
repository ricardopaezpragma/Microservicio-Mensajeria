package com.pragma.messenger.infrastructure.input.rest;

import com.pragma.messenger.application.dto.CustomerMessageDto;
import com.pragma.messenger.application.handler.interfaces.ICustomerMessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
@RequiredArgsConstructor
public class SendMessage {
    private final ICustomerMessageHandler customerMessageHandler;

    @PostMapping("/notify-order")
    public ResponseEntity<HttpStatus> notifyOrder(@RequestBody CustomerMessageDto customerMessageDto) {
        customerMessageHandler.sendConfirmationPin(customerMessageDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
