package com.rehan.spendsmart.transaction;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transaction> getTransactions(
            @RequestParam(required = false) TransactionType type,
            @RequestParam(required = false) TransactionCategory category) {
        if (type != null) return service.findByType(type);
        if (category != null) return service.findByCategory(category);
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction createTransaction(@Valid @RequestBody TransactionRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id,
                                         @Valid @RequestBody TransactionRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTransaction(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/summary")
    public TransactionService.Summary getSummary() {
        return service.getSummary();
    }
}
