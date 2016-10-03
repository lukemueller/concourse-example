package org.luke.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AdditionController {

    private AdditionService additionService;

    @Autowired
    public AdditionController(AdditionService additionService) {
        this.additionService = additionService;
    }

    @RequestMapping("/add")
    public AddApiResponse add(
        @RequestParam("operand1") String operand1,
        @RequestParam("operand2") String operand2
    ) {
        int firstOperand = Integer.parseInt(operand1);
        int secondOperand = Integer.parseInt(operand2);
        int result = additionService.add(firstOperand, secondOperand);

        AddApiResponse addApiResponse = new AddApiResponse();
        addApiResponse.setOperands(Arrays.asList(firstOperand, secondOperand));
        addApiResponse.setResult(result);

        return addApiResponse;
    }

    static class AddApiResponse {
        private List<Integer> operands;
        private int result;

        public List<Integer> getOperands() {
            return operands;
        }

        public void setOperands(List<Integer> operands) {
            this.operands = operands;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }
    }
}
