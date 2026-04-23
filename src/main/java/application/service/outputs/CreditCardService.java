package application.service.outputs;

import application.domain.CreditCard;
import application.service.ports.CreditCardRepositoryPort;

import java.util.List;
import java.util.Optional;

public interface CreditCardService  {

    public CreditCard createCreditCard(CreditCard creditCard);
    public CreditCard updateCreditCard(CreditCard creditCard);


    void purchase(String cardNumber, double amount, int installments);

    void pay(String cardNumber, double amount);

    double calculateMonthlyInstallment(double amount, int installments);
}
