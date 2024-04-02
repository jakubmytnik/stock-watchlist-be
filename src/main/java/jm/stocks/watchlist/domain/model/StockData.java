package jm.stocks.watchlist.domain.model;

import jm.stocks.watchlist.infrastructure.boundary.outbound.jpa.watchlist.StockEntity;
import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.model.Quote;
import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.model.StockMetrics;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Builder
@Value
public class StockData {
    String symbol;
    String name;
    BigDecimal price;
    BigDecimal priceChange;

    BigDecimal dividendYield; //dividend_yield
    Integer dividendGrowthYears; //dividend_growth
    BigDecimal payoutRatio; //payout_ratio
    BigDecimal divGrowth5y; //div_grow_rate5
    BigDecimal divGrowth3y; //div_grow_rate3
    BigDecimal fcfPayoutRatio; //cf_payout

    public static StockData of(StockEntity se, Quote quote, StockMetrics metrics){
        return StockData.builder()
                .symbol(se.getSymbol())
                .name(se.getCompanyName())
                .price(quote.getLast())
                .priceChange(quote.getLast().divide(quote.getPrev_close(), 4, RoundingMode.HALF_UP).subtract(BigDecimal.ONE))
                .dividendYield(metrics.getDividend_yield())
                .dividendGrowthYears(metrics.getDividend_growth())
                .divGrowth3y(metrics.getDiv_grow_rate3())
                .divGrowth5y(metrics.getDiv_grow_rate5())
                .payoutRatio(metrics.getPayout_ratio())
                .fcfPayoutRatio(metrics.getCf_payout())
                .build();
    }
}
