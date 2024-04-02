package jm.stocks.watchlist.domain.ports;

import jm.stocks.watchlist.domain.model.StockData;

import java.util.List;

public interface WatchlistRepository {
    void addToWatchlist(Long userId, String symbol, String companyName);
    void removeFromWatchlist(Long userId, String symbol);
    List<StockData> getWatchlist(Long userId);
}
