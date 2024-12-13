package bankproject;

import bankproject.exception.BankOperationException;

import java.util.Scanner;

/*
고객의 ID와 이름, 그리고 계좌를 저장하는 배열을 포함합니다.
계좌를 추가하고 찾는 메서드를 제공합니다.
 */
public class Customer {
    // 객체 생성 Part-----
    static Bank bank = new Bank();
    static Account account = new Account();
    static Scanner sc = new Scanner(System.in);

    // 필드 생성 Part-----
    private String userName;
    private String userID;
    private String userAccount;

    // [추가된 기능] Part-----
    private Account[] accounts; // 계좌배열
    private int accountCount; // 현재 고객의 계좌 개수

    // =====Methods=====
    // 계좌 추가 메소드
    public void addAccount()throws BankOperationException{
        outter: while(true){
            System.out.print("고객 ID 입력 : ");
            String userInputId = sc.next();

            // 1) 은행에 등록된 아이디인지 확인
            boolean isBankId = bank.existsUserId(userInputId); // 고객 중복 확인 메소드 호출
            if(isBankId){
                // 추가된 기능
                if(accountCount >= 5){
                    throw new BankOperationException("계좌가 최대 5개가 만들어져있습니다. 생성 불가");
                } // Todo : BankOperationException 예외처리 (90%)

                System.out.print("새 계좌 번호 입력 : ");
                String userInputAccount = sc.next();

                // 고객 아이디와, 입력받은 계좌번호를 Account에 전달, 새 계좌 잔액은 0원으로 전달
                Account newAccount = new Account(userID, userInputAccount, 0);
                Account.accounts[Bank.customerIndex] = newAccount;

                // 추가된 기능
                accountCount++; // 계좌 저장 후에는 개수 증가

                System.out.println("계좌가 성공적으로 생성되었습니다!");
                break;
            }else{
                System.out.println("존재하지 않는 ID입니다. 다시 입력해주세요.");
            }
            // Todo : 일정된 형식의 계좌 번호 입력받기 구현 필요
            // Todo : 한 ID당 계좌 생성 5개 제한 구현 (85%)
        }
    }

    // 계좌 조회 서비스 메소드
    public void findAccount(String inputAccount){

    }

    // 기본생성자
    public Customer() { }

    public Customer(String userID, String userName) {
        this.userID = userID;
        this.userName = userName;

        // 추가된 기능
        this.accounts = new Account[5]; // 최대 5개의 계좌
        this.accountCount = 0;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}

// addAccount()메소드 더미코드
// 수정 2) 은행에 등록된 아이디인지 확인
//            if(userID.equals(sc.next())){
//                System.out.print("새 계좌 번호 입력 : ");
//
//                // 고객 아이디와, 입력받은 계좌번호를 Account에 전달, 새 계좌 잔액은 0원으로 전달
//                Account newAccount = new Account(userID, sc.nextLine(), 0);
//                Account.accounts[account.getAddUserIndex()] = newAccount;
//
//                System.out.println("계좌가 성공적으로 생성되었습니다!");
//                break;
//            }else{
//                System.out.println("존재하지 않는 ID입니다. 다시 입력해주세요.");
//            }
