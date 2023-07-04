package com.pragma.messenger.domain.model;

public class CustomerMessage {
    private Integer orderId;
    private String customerPhone;
    private Integer pin;

    public CustomerMessage(Integer orderId, String customerPhone, Integer pin) {
        this.orderId = orderId;
        this.customerPhone = customerPhone;
        this.pin = pin;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }
}
