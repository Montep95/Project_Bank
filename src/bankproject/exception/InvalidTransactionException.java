package bankproject.exception;

// 잘못된 입출금 요청 처리를 담당
public class InvalidTransactionException extends Exception{
    public InvalidTransactionException() {
        super("[잘못된입출금요청]");
    }

    public InvalidTransactionException(String message) {
        super(message);
    }
}
