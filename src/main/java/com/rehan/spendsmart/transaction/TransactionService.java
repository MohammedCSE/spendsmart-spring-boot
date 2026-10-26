package com.rehan.spendsmart.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> findAll() {
        return repository.findAll();
    }

    public Transaction findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));
    }

    public List<Transaction> findByType(TransactionType type) {
        return repository.findByType(type);
    }

    public List<Transaction> findByCategory(TransactionCategory category) {
        return repository.findByCategory(category);
    }

    public Transaction create(TransactionRequest request) {
        return repository.save(new Transaction(
                request.amount(), request.type(), request.category(),
                request.description().trim(), request.transactionDate()));
    }

    @Transactional
    public Transaction update(Long id, TransactionRequest request) {
        Transaction existing = findById(id);
        existing.setAmount(request.amount());
        existing.setType(request.type());
        existing.setCategory(request.category());
        existing.setDescription(request.description().trim());
        existing.setTransactionDate(request.transactionDate());
        return existing;
    }

    public void delete(Long id) {
        Transaction existing = findById(id);
        repository.delete(existing);
    }

    public Summary getSummary() {
        BigDecimal income = BigDecimal.ZERO;
        BigDecimal expenses = BigDecimal.ZERO;

        for (Transaction transaction : repository.findAll()) {
            if (transaction.getType() == TransactionType.INCOME) {
                income = income.add(transaction.getAmount());
            } else {
                expenses = expenses.add(transaction.getAmount());
            }
        }
        return new Summary(income, expenses, income.subtract(expenses));
    }

    public record Summary(BigDecimal totalIncome, BigDecimal totalExpenses, BigDecimal balance) { }
}
