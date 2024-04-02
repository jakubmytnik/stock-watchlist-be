package jm.stocks.watchlist.infrastructure.boundary.inbound.rest.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class StockSearchResult {
    private String symbol;
    private String companyName;
}
