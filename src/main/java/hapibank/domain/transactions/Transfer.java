package hapibank.domain.transactions;

import hapibank.domain.Account;
import hapibank.domain.enums.TransactionState;

import java.time.LocalDate;

public class Transfer  extends Transaction{
    private Account originAccount;
    private Account destinationAccount;

    public Transfer(long id, double amount, LocalDate date, TransactionState state, Account originAccount, Account destinationAccount) {
        super(id, amount, date, state);
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
    }


    public Account getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(Account originAccount) {
        this.originAccount = originAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }
}
