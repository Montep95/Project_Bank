package bankproject.exception;

public class InvalidUserInputException extends Exception{
    public InvalidUserInputException() {
        super("[InvalidUserInput] : 잘못된 입력을 하셨습니다.");
    }

    public InvalidUserInputException(String message) {
        super(message);
    }
}
