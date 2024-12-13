package bankproject;

import bankproject.exception.AccountNotFoundException;
import bankproject.exception.InvalidTransactionException;

import java.util.Scanner;

/*
계좌 번호, 소유 고객 ID, 잔액을 속성으로 가지며,
입금과 출금을 처리하는 메서드를 구현합니다.
 */
public class Account {
    // 객체 생성 Part-----
    static Account[] accounts = new Account[50];
    static Bank bank = new Bank();
    static Scanner sc = new Scanner(System.in);

    // 필드 생성 Part-----
    private double balance;
    private String userAccount;
    private String userName;
    private String userId;
    private int addUserIndex = 0;

    // =====Methods=====
    // 입금
    public void deposit() throws Exception{
        outter: while(true){
            System.out.print("고객 ID 입력 : ");
            String depositId = sc.next();

            // 은행에 등록된 아이디인지 확인
            boolean isBankId = bank.existsUserId(depositId); // 존재하는 고객인지 확인하는 메소드 호출
            double depositMoney = 0;
            int targetUserIndex = 0;

            while(true){
                if(isBankId){
                    System.out.print("계좌 번호 입력 : ");
                    String depositAccount = sc.next();

                    // 리팩토링 [24-12-12 22:44]
                    if(depositAccount.equals(accounts[Bank.customerIndex].getUserAccount())){
                        System.out.print("입금 금액 입력 : ");
                        depositMoney = sc.nextDouble();

                        // 입금 [음수입력] 예외처리
                        if(depositMoney < 0){
                            throw new InvalidTransactionException("잘못된 입금액입니다.");
                        }

                        // {입금 고객 아이디, 입금 계좌번호, 입금할 금액} 을 Account에 전달
                        Account newAccount = new Account(depositId, depositAccount, depositMoney);

                        accounts[Bank.customerIndex] = newAccount;

                        // 추가된 기능 Todo : balance += depositMoney;
                        double updateMoney = accounts[Bank.customerIndex].getBalance();
                        updateMoney += depositMoney;
                        accounts[Bank.customerIndex].setBalance(updateMoney);

                        System.out.println(String.format("%.1f", depositMoney) + "원이 입금되었습니다. 현재 잔액 : " + accounts[Bank.customerIndex].getBalance() + "원\n");
                        break outter;
                    }else{

                        // 계좌번호 조회 시 존재하지 않는 예외처리
                        throw new AccountNotFoundException("입력하신 계좌가 존재하지 않습니다.");
                        // System.out.println("존재하지 않는 계좌번호입니다. 다시 입력해주세요");
                    }
                }else{
                    System.out.println("존재하지 않는 ID입니다. 다시 입력해주세요.");
                }
            }
        }
    }

    // 출금
    public void withdraw() throws Exception {
        while (true) {
            System.out.print("고객 ID 입력 : ");
            String withdrawId = sc.next();

            // 은행에 등록된 아이디인지 확인
            boolean isBankId = bank.existsUserId(withdrawId); // 존재하는 고객인지 확인하는 메소드 호출
            double withdrawMoney = 0;
            int targetUserIndex = 0;

            outter: while(true){
                if (isBankId) {
                    System.out.print("계좌 번호 입력 : ");
                    String withdrawAccount = sc.next();

                    // 리팩토링 [24-12-12 22:44]
                    if (withdrawAccount.equals(accounts[Bank.customerIndex].getUserAccount())) {
                        System.out.print("출금 금액 입력 : ");
                        withdrawMoney = sc.nextDouble();

                        double updateMoney = accounts[Bank.customerIndex].getBalance();

                        // 출금 [잔액부족] 예외처리
                        if(updateMoney < withdrawMoney){
                            throw new InvalidTransactionException("잔액이 부족합니다.");
                        }

                        updateMoney -= withdrawMoney;
                        accounts[Bank.customerIndex].setBalance(updateMoney);

                        System.out.println(String.format("%.1f", withdrawMoney) + "원이 출금되었습니다. 현재 잔액 : " + accounts[Bank.customerIndex].getBalance() + "원\n");
                        break outter;
                    } else {

                        // 계좌번호 조회 시 존재하지 않는 예외처리
                        throw new AccountNotFoundException("입력하신 계좌가 존재하지 않습니다.");
                        //System.out.println("존재하지 않는 계좌번호입니다. 다시 입력해주세요");
                    }
                } else {
                    System.out.println("존재하지 않는 ID입니다. 다시 입력해주세요.");
                }
            }
        }
    }

    // 잔액 조회 메소드
    public void searchMyBalance() throws AccountNotFoundException{
        int targetUserIndex = 0;

        outter: while(true){
            System.out.print("조회할 계좌번호를 입력해주세요 : ");
            String searchAccount = sc.next();

            // 기능 수정 = 인덱싱 accounts.length -> Bank.customerIndex
            // Todo : 잔액조회할 계좌번호 입력 시 "[예외처리] 숫자만 입력해주세요 발생" 해결
            for(int i = 0; i < Bank.customerIndex; i++){
                if(accounts[i].userAccount.equals(searchAccount)){
                    targetUserIndex = i;

                    // 기능 수정 = 인덱싱 accounts.length -> Bank.customerIndex
                    System.out.println("입력하신 계좌[" + searchAccount + "]의 잔액은 [" + accounts[Bank.customerIndex].getBalance() + "]원입니다");
                    break outter;
                }
            }

            // 계좌번호 조회 시 존재하지 않는 예외처리
            throw new AccountNotFoundException("입력하신 계좌가 존재하지 않습니다. 다시 입력해주세요.");
            //System.out.println("존재하지 않는 계좌번호입니다. 다시 입력해주세요");
        }
    }

    // =====생성자 Part=====
    // 기본생성자
    public Account() {
    }

    public Account(String userId, String userAccount, double balance) {
        this.userId = userId;
        this.userAccount = userAccount;
        this.balance = balance;
    }

    // =====Getter/Setter Part=====
    public int getAddUserIndex() {
        return addUserIndex;
    }

    public void setAddUserIndex(int addUserIndex) {
        this.addUserIndex = addUserIndex;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}