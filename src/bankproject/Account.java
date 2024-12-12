package bankproject;

import java.util.Scanner;

/*
계좌 번호, 소유 고객 ID, 잔액을 속성으로 가지며,
입금과 출금을 처리하는 메서드를 구현합니다.
 */
public class Account {
    // 객체 생성 Part-----
    static Account[] accounts = new Account[500];
    static Bank bank = new Bank();
    static Scanner sc = new Scanner(System.in);

    // 필드 생성 Part-----
    private double balance;
    private String userAccount;
    private String userName;
    private String userId;
    private int AddUserIndex = 0;


    // =====Methods=====
    // 입금
    public void deposit(){
        while(true){
            System.out.print("고객 ID 입력 : ");

            String depositId = sc.nextLine();

            // 은행에 등록된 아이디인지 확인
            boolean isBankId = bank.existsUserId(depositId); // 존재하는 고객인지 확인하는 메소드 호출
            double depositMoney = 0;
            int targetUserIndex = 0;

            if(isBankId){
                System.out.print("계좌 번호 입력 : ");
                String depositAccount = sc.nextLine();

                for(int i = 0; i < accounts.length; i++){
                    if(accounts[i].userAccount.equals(depositAccount)){
                        System.out.print("입금 금액 입력 : ");
                        depositMoney = sc.nextInt();
                        targetUserIndex = i;
                        break;
                    }
                }

                // 고객 아이디와, 입력받은 계좌번호를 Account에 전달, 새 계좌 잔액은 0원으로 전달
                Account newAccount = new Account(depositId, depositAccount, depositMoney);
                // 계좌배열에 추가 후 인덱스 증가
                accounts[AddUserIndex++] = newAccount;

                System.out.println(String.format("%.1f", depositMoney) + "원이 입금되었습니다. 현재 잔액 : " + accounts[targetUserIndex].balance + "원");
                break;
            }else{
                System.out.println("존재하지 않는 ID입니다. 다시 입력해주세요.");
            }
        }
    }

    // 출금
    public void withdraw(){
        while(true){
            System.out.print("고객 ID 입력 : ");

            String withdrawId = sc.nextLine();

            // 은행에 등록된 아이디인지 확인
            boolean isBankId = bank.existsUserId(withdrawId); // 존재하는 고객인지 확인하는 메소드 호출
            double withdrawMoney = 0;
            int targetUserIndex = 0;

            if(isBankId){
                System.out.print("계좌 번호 입력 : ");
                String withdrawAccount = sc.nextLine();

                for(int i = 0; i < accounts.length; i++){
                    if(accounts[i].userAccount.equals(withdrawAccount)){
                        System.out.print("출금 금액 입력 : ");
                        withdrawMoney = sc.nextInt();
                        targetUserIndex = i;
                        break;
                    }
                }

                // 고객 아이디와, 입력받은 계좌번호를 Account에 전달, 새 계좌 잔액은 0원으로 전달
                Account newAccount = new Account(withdrawId, withdrawAccount, withdrawMoney);
                // 계좌배열에 추가 후 인덱스 증가
                accounts[AddUserIndex++] = newAccount;

                System.out.println(String.format("%.1f", withdrawMoney) + "원이 출금되었습니다. 현재 잔액 : " + (accounts[targetUserIndex].balance-withdrawMoney) + "원");
                break;
            }else{
                System.out.println("존재하지 않는 ID입니다. 다시 입력해주세요.");
            }
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
        return AddUserIndex;
    }

    public void setAddUserIndex(int addUserIndex) {
        AddUserIndex = addUserIndex;
    }
}
