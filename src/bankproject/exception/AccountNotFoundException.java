package bankproject.exception;

// 존재하지 않는 계좌의 요청처리를 담당
public class AccountNotFoundException extends Exception{
    public AccountNotFoundException() {
        super("[계좌오류]");
    }

    public AccountNotFoundException(String message) {
        super(message);
    }
}
