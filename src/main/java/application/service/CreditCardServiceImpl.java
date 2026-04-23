package application.service;

import application.domain.CreditCard;
import application.domain.Transaction;
import application.domain.enums.AccountState;
import application.domain.enums.TransactionType;

import application.service.outputs.CreditCardService;
import application.service.ports.CreditCardRepositoryPort;

import java.util.Optional;

public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepositoryPort repository;

    public CreditCardServiceImpl(CreditCardRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public CreditCard createCreditCard(CreditCard creditCard) {
        return null;
    }

    @Override
    public CreditCard updateCreditCard(CreditCard creditCard) {
        return null;
    }

    @Override
    public void purchase(String cardNumber, double amount, int installments) {
        Optional<CreditCard> cardOpt = repository.findById(cardNumber);

        if (cardOpt.isEmpty()) {
            System.out.println("Error: La tarjeta " + cardNumber + " no existe.");
            return;
        }

        CreditCard card = cardOpt.get();

        if (card.getAccountState() != AccountState.ACTIVE) {
            System.out.println("Error: La tarjeta no está activa.");
            return;
        }

        if (amount < 0) {
            System.out.println("Error: El monto debe ser mayor a cero.");
            return;
        }

        if (card.getBalance() < amount) {
            System.out.println("Error: Saldo insuficiente. Tu saldo es: $" + card.getBalance());
            return;
        }

        double newBalance = card.getBalance() - amount;
        card.setBalance(newBalance);

        double cuota = calculateMonthlyInstallment(amount, installments);

        Transaction purchaseRecord = new Transaction(
                card.getTransactions().size() + 1,
                TransactionType.CREDIT_PAYMENT,
                amount,
                newBalance,
                "Compra con tarjeta de crédito en " + installments + " cuotas. Cuota mensual: $" + cuota
        );
        card.getTransactions().add(purchaseRecord);

        repository.update(card);
        System.out.println("Compra realizada. Cuota mensual: $" + cuota);
    }

    @Override
    public void pay(String cardNumber, double amount) {
        Optional<CreditCard> cardOpt = repository.findById(cardNumber);

        if (cardOpt.isEmpty()) {
            System.out.println("Error: La tarjeta " + cardNumber + " no existe.");
            return;
        }

        CreditCard card = cardOpt.get();

        double newBalance = card.getBalance() + amount;
        card.setBalance(newBalance);

        Transaction paymentRecord = new Transaction(
                card.getTransactions().size() + 1,
                TransactionType.CREDIT_PAYMENT,
                amount,
                newBalance,
                "Pago realizado a la tarjeta de crédito"
        );
        card.getTransactions().add(paymentRecord);

        repository.update(card);
        System.out.println("Pago exitoso. Nuevo saldo: $" + newBalance);
    }

    @Override
    public double calculateMonthlyInstallment(double amount, int installments) {
        double rate = getRateByInstallments(installments);

        if (rate == 0.0) {
            return amount / installments;
        }

        return (amount * rate) / (1 - Math.pow(1 + rate, -installments));
    }

    private double getRateByInstallments(int installments) {
        if (installments <= 2) return 0.0;
        if (installments <= 6) return 0.019;
        return 0.023;
    }
}

