package jm.stocks.watchlist.domain;

import jm.stocks.watchlist.domain.ports.StockSearchInterface;
import jm.stocks.watchlist.infrastructure.boundary.inbound.rest.model.StockSearchResult;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StockSearchFacade {

private final StockSearchInterface stockSearchInterface;

    public List<StockSearchResult> search(String query){
           return stockSearchInterface.search(query);
    }

}
