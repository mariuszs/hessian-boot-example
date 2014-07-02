package mariuszs.hessian.api;

import java.io.Serializable;
import java.math.BigDecimal;

public class FooRequest implements Serializable{

    private  String name;
    private  int i;
    private  BigDecimal amount;

    public FooRequest() {
    }

    public FooRequest(String name, int i, BigDecimal amount) {
        this.name = name;
        this.i = i;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FooRequest{" +
            "name='" + name + '\'' +
            ", i=" + i +
            ", amount=" + amount +
            '}';
    }
}
