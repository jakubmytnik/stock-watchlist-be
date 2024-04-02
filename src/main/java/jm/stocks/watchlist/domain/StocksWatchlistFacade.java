package jm.stocks.watchlist.domain;

import jm.stocks.watchlist.domain.model.StockData;
import jm.stocks.watchlist.domain.ports.WatchlistRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StocksWatchlistFacade {

    public static final long USER_ID = 1L;

    private final WatchlistRepository watchlistRepository;

    public void addToWatchlist(String symbol, String companyName){
        watchlistRepository.addToWatchlist(USER_ID, symbol, companyName);
    }

    public void removeFromWatchlist( String symbol){
       watchlistRepository.removeFromWatchlist(USER_ID, symbol);
    }

    public List<StockData> getWatchlist(){
       return watchlistRepository.getWatchlist(USER_ID);
    }


}
