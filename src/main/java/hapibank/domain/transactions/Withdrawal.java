package hapibank.domain.transactions;

import hapibank.domain.Account;
import hapibank.domain.enums.TransactionState;

import java.time.LocalDate;

public class Withdrawal extends Transaction {

    private Account account;

    public Withdrawal(long id, double amount, LocalDate date, TransactionState state, Account account) {
        super(id, amount, date, state);
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
