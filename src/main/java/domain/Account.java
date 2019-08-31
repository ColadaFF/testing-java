package domain;

import java.math.BigDecimal;

public class Account {
    AccountId id;
    String customerName;
    float interest;
    BigDecimal creditLimit;
    AccountId fallbackAccount;
    AccountId checkingAccount;


    public Account() {
    }

}
