package bankproject.exception;

// [고객입력오류] 예외처리
public class InvalidUserInputException extends Exception{
    public InvalidUserInputException() {
        super("[고객입력오류]");
    }

    public InvalidUserInputException(String message) {
        super(message);
    }
}
