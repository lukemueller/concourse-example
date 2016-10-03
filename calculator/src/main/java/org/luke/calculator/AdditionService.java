package org.luke.calculator;

import org.luke.addition.AdderModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdditionService {
    private AdderModule adderModule;

    @Autowired
    public AdditionService(AdderModule adderModule) {
        this.adderModule = adderModule;
    }

    public int add(int operand1, int operand2) {
        return adderModule.add(operand1, operand2);
    }
}
