package bankproject;

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

    // =====Methods=====
    // 계좌 추가 메소드
    public void addAccount(){
        while(true){
            System.out.println("고객 ID 입력 : ");

            // 은행에 등록된 아이디인지 확인
            boolean isBankId = bank.existsUserId(sc.nextLine()); // 고객 중복 확인 메소드 호출
            if(isBankId){
                System.out.println("새 계좌 번호 입력 : ");

                // 고객 아이디와, 입력받은 계좌번호를 Account에 전달, 새 계좌 잔액은 0원으로 전달
                Account newAccount = new Account(userID, sc.nextLine(), 0);
                System.out.println("계좌가 성공적으로 생성되었습니다!");
                break;
            }else{
                System.out.println("존재하지 않는 ID입니다. 다시 입력해주세요.");
            }
        }
    }

    // 계좌 조회 서비스 메소드
    public void findAccount(String inputAccount){

    }

    // 기본생성자
    public Customer() { }

    public Customer(String userName, String userID) {
        this.userName = userName;
        this.userID = userID;
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
