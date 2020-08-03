package mss.demo.drools;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxiRide {
    private Boolean isNightSurcharge;
    private BigDecimal distanceInMile;
}
