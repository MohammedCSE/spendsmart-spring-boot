package com.rehan.spendsmart.transaction;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionRequest(
        @NotNull @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
        BigDecimal amount,
        @NotNull TransactionType type,
        @NotNull TransactionCategory category,
        @NotBlank @Size(max = 300) String description,
        @NotNull LocalDate transactionDate
) { }
