package jm.stocks.watchlist.domain.ports;

import jm.stocks.watchlist.infrastructure.boundary.inbound.rest.model.StockSearchResult;

import java.util.List;

public interface StockSearchInterface {
    List<StockSearchResult> search(String query);
}
