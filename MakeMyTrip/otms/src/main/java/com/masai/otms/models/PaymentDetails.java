package com.masai.otms.models;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class PaymentDetails {

    @NotNull(message = "Payment Type cannot be null")
    private String paymentType;
    @NotNull(message = "Gateway Type cannot be null")
    private String gateWay;

    @DecimalMin(value = "0.0", inclusive = false, message = "Amount should be greater than 0.0")
    private Double amount;
}
