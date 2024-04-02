package jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockMetrics {
    String slug;
    Integer tickerId;
    BigDecimal dividend_yield;
    Integer dividend_growth;
    BigDecimal div_grow_rate5;
    BigDecimal div_grow_rate3;
    BigDecimal cf_payout;
    BigDecimal payout_ratio;

    public String getSlug() {
        return slug.toUpperCase();
    }
}
