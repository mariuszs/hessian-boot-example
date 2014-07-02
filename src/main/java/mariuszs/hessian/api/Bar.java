package mariuszs.hessian.api;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bar implements Serializable {

    private BigDecimal amount = BigDecimal.ONE;
    private List<Long> longs = new ArrayList<>();

    public Bar() {
    }

    public Bar(BigDecimal amount, List<Long> longs) {
        this.amount = amount;
        this.longs = longs;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<Long> getLongs() {
        return longs;
    }

    public void setLongs(List<Long> longs) {
        this.longs = longs;
    }
}
