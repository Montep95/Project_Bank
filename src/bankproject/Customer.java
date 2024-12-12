package bankproject;

import java.util.Scanner;

public class Customer {
    // 객체 생성 Part-----
    static Customer customer = new Customer();
    static Account account = new Account();
    static Scanner sc = new Scanner(System.in);

    // 필드 생성 Part-----
    private String userName;
    private String userID;
    private String userAccount;

    // [추가된 기능] Part-----

    // =====Methods=====
    // 기본생성자
    public Customer() {

    }

    public Customer(String userName, String userID) {
        this.userName = userName;
        this.userID = userID;
    }

    public Customer(String userName, String userID, String userAccount) {
        this.userName = userName;
        this.userID = userID;
        this.userAccount = userAccount;
    }

    // 계좌 추가 메소드
    public void addAccount(){
        System.out.println("고객 ID 입력 : ");

        // 고객 ID가 존재한다면,
        if(userID.equals(sc.nextLine())){

        }
    }

    // 계좌 조회 서비스 메소드
    public void findAccount(String inputAccount){

    }
}
