package dev.ky3he4ik.pr.pr11;

import java.util.HashMap;

public interface Operand {
    public double evaluate(double var) ;

    public double evaluate(HashMap<String, Integer> varMap);
}
