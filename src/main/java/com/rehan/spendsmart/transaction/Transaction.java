package com.rehan.spendsmart.transaction;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionCategory category;

    @Column(nullable = false, length = 300)
    private String description;

    @Column(nullable = false)
    private LocalDate transactionDate;

    protected Transaction() { }

    public Transaction(BigDecimal amount, TransactionType type, TransactionCategory category,
                       String description, LocalDate transactionDate) {
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.description = description;
        this.transactionDate = transactionDate;
    }

    public Long getId() { return id; }
    public BigDecimal getAmount() { return amount; }
    public TransactionType getType() { return type; }
    public TransactionCategory getCategory() { return category; }
    public String getDescription() { return description; }
    public LocalDate getTransactionDate() { return transactionDate; }

    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setType(TransactionType type) { this.type = type; }
    public void setCategory(TransactionCategory category) { this.category = category; }
    public void setDescription(String description) { this.description = description; }
    public void setTransactionDate(LocalDate transactionDate) { this.transactionDate = transactionDate; }
}
