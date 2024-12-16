package bankproject;

import bankproject.exception.InvalidTransactionException;

public class Account {
    private String userID;         // 계좌 소유 고객 ID
    private String accountNumber;  // 계좌 번호
    private double balance;        // 계좌 잔액

    public Account(String userID, String accountNumber, double balance) {
        this.userID = userID;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // 입금 메소드
    public void deposit(double amount) throws InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException("[예외] 입금 금액 음수 입력");
        }
        balance += amount;
    }

    // 출금 메소드
    public void withdraw(double amount) throws InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException("[예외] 출금 금액 음수 입력");
        }
        if (amount > balance) {
            throw new InvalidTransactionException("[예외] 잔액이 부족합니다.");
        }
        balance -= amount;
    }

    // 잔액 조회 메소드
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}