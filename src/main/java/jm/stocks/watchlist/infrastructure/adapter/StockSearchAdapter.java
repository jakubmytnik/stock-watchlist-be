package jm.stocks.watchlist.infrastructure.adapter;

import jm.stocks.watchlist.domain.ports.StockSearchInterface;
import jm.stocks.watchlist.infrastructure.boundary.inbound.rest.model.StockSearchResult;
import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.SeekingAlphaApi;
import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.model.SearchSymbolResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StockSearchAdapter implements StockSearchInterface {

    private final SeekingAlphaApi seekingAlphaApi;
    @Override
    public List<StockSearchResult> search(String query){
        SearchSymbolResponse response = seekingAlphaApi.searchBySymbol(query);
        return response.getSymbols().stream().map(
                symbol -> StockSearchResult.builder().symbol(symbol.getSlug()).companyName(symbol.getContent()).build()
        ).toList();
    }
}
