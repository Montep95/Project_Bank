package bankproject;

/*
계좌 번호, 소유 고객 ID, 잔액을 속성으로 가지며,
입금과 출금을 처리하는 메서드를 구현합니다.
 */
public class Account {
    // 객체 생성 Part-----
    static Account[] accounts = new Account[500];

    // 필드 생성 Part-----
    private double balance;
    private String userAccount;
    private String userName;
    private String userId;

    // =====Methods=====
    // 입금
    public void deposit(){

    }

    // 출금
    public void withdraw(){

    }

    // 기본생성자
    public Account() {
    }

    public Account(String userId, String userAccount, double balance) {
        this.userId = userId;
        this.userAccount = userAccount;
        this.balance = balance;
    }
}
