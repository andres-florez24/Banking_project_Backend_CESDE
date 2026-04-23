package application.repository;

import application.domain.CreditCard;
import application.service.ports.CreditCardRepositoryPort;

import java.util.*;

public class CreditCardRepository implements CreditCardRepositoryPort {

    private final Map<String, CreditCard> database = new HashMap<>();

    @Override
    public void save(CreditCard creditCard) {
        database.put(creditCard.getAccountNumber(), creditCard);
    }

    @Override
    public Optional<CreditCard> findById(String accountNumber) {
        return Optional.ofNullable(database.get(accountNumber));
    }

    @Override
    public List<CreditCard> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public void update(CreditCard creditCard) {
        if (database.containsKey(creditCard.getAccountNumber())) {
            database.put(creditCard.getAccountNumber(), creditCard);
        } else {
            throw new IllegalArgumentException("CreditCard con número "
                    + creditCard.getAccountNumber() + " no encontrada");
        }
    }

    @Override
    public void delete(CreditCard creditCard) {
        database.remove(creditCard.getAccountNumber());
    }
}
