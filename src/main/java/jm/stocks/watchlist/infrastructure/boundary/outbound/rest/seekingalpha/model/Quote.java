package jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quote {
    String ticker_id;
    String sa_slug;
    BigDecimal last;
    BigDecimal prev_close;

    public String getSa_slug() {
        return sa_slug.toUpperCase();
    }
}
