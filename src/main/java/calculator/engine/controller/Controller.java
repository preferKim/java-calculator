package calculator.engine.controller;

import calculator.application.io.Input;
import calculator.application.io.Output;
import calculator.application.io.enums.SelectOption;
import calculator.application.model.UserSelection;
import calculator.engine.model.CalculationResult;
import calculator.engine.model.Expression;
import calculator.engine.repository.History;

public class Controller implements Runnable{
    private final Input input;
    private final Output output;
    private final Calculator calculator;
    private final History history;

    public Controller(Calculator calculator, Input input, Output output, History history) {
        this.calculator = calculator;
        this.input = input;
        this.output = output;
        this.history = history;
    }

    @Override
    public void run() {
        while(true) {
            UserSelection selection = input.getUserSelection(SelectOption.getLiterals());

            if (selection.isEqualTo(SelectOption.CALCULATE)) {
                Expression infix = input.getExpression();
                CalculationResult result = calculator.calculate(infix);
                history.record(infix, result);
            }

            if (selection.isEqualTo(SelectOption.QUERY)) {
                output.log(history.getLiterals());
            }

            // TODO: Exit

        }
    }
}
