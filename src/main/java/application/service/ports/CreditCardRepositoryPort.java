package application.service.ports;

import application.domain.CreditCard;


import java.util.List;
import java.util.Optional;

public interface CreditCardRepositoryPort {

    void save(CreditCard creditCard);
    Optional<CreditCard> findById(String AccountNumber);
    List<CreditCard> findAll();
    void update(CreditCard creditCard);
    void delete(CreditCard creditCard);


    void purchase(String cardNumber, double amount, int installments);
}
