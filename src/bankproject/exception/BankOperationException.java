package bankproject.exception;

// [은행시스템] 예외처리 - 일반적인 은행 관련 오류 처리를 담당
public class BankOperationException extends Exception{
    public BankOperationException() {
        super("[은행시스템오류]");
    }

    public BankOperationException(String message) {
        super(message);
    }
}
