package calculator.application.io.enums;

public enum Message {
    INPUT_SELECT_GUIDE("선택 : "),
    INPUT_EXPRESSION_GUIDE("식 입력 : ");

    private final String literal;

    Message(String literal) {
        this.literal = literal;
    }

    @Override
    public String toString() {
        return literal;
    }
}
