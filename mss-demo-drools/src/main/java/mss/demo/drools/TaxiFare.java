package mss.demo.drools;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxiFare {
    private BigDecimal nightSurcharge;
    private BigDecimal  rideFare;
    public BigDecimal  total() {
        return this.nightSurcharge.add(this.rideFare);
    }
}
