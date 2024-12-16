package bankproject;

import bankproject.exception.BankOperationException;

public class Customer {
    private static final int MAX_ACCOUNT = 5; // 고객당 최대 계좌 개수
    private String userID;
    private String userName;
    private Account[] accounts;
    private int accountCount; // 현재 계좌 개수

    public Customer(String userID, String userName) {
        this.userID = userID;
        this.userName = userName;
        this.accounts = new Account[MAX_ACCOUNT]; // 최대 5개의 계좌
        this.accountCount = 0;
    }

    // 계좌 추가 메소드
    public void addAccount(String accountNumber) throws BankOperationException {
        if (accountCount >= MAX_ACCOUNT) {
            throw new BankOperationException("계좌가 최대 [" + MAX_ACCOUNT + "]개 만들어져 있습니다. 추가 불가");
        }
        accounts[accountCount++] = new Account(userID, accountNumber, 0); // 새 계좌 추가
        System.out.println("계좌가 성공적으로 생성되었습니다!");
    }

    // 고객의 계좌 목록 확인, 호출하는 곳에 계좌들 반환
    public Account[] getAccounts() {
        return accounts;
    }

    public String getUserID() {
        return userID;
    }
}