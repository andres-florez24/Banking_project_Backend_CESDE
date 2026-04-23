package application.domain;

import java.time.LocalDate;
import java.util.List;

public class CreditCard  extends Account{
    private double quota ;
    private double debt ;
    private int numberOfInstallments ;



    public CreditCard( String accountNumber,double balance,
                       LocalDate dateOpened, String stateAccount,
                       String accountType, List<Transaction> transactions,
                       double quota, double debt, int numberOfInstallments)  {
        super(accountNumber, balance, dateOpened, stateAccount, accountType, transactions);
        this.quota = quota;
        this.debt = debt;
        this.numberOfInstallments = numberOfInstallments;
    }
    public double getQuota() {
        return quota;
    }

    public void setQuota(double quota) {
        this.quota = quota;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public int getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(int numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }


    @Override
    public String toString() {
        return "CreditCard{" +
                "quota=" + quota +
                ", debt=" + debt +
                ", numberOfInstallments=" + numberOfInstallments +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", dateOpened=" + dateOpened +
                ", accountState=" + accountState +
                ", accountType='" + accountType + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
