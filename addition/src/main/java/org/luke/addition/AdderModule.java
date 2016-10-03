package org.luke.addition;

public class AdderModule {
    public int add(int ...operands) {
        int total = 0;
        for (int operand : operands) {
            total += operand;
        }

        return total;
    }
}
