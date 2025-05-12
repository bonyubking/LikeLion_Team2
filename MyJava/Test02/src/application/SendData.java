package application;

import java.io.Serializable;

public class SendData implements Serializable {

    private static final long serialVersionUID = 1L;

    private double num1;
    private double num2;
    private String operator;
    private double result;

    public SendData(double num1, double num2, String operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public String getOperator() {
        return operator;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
