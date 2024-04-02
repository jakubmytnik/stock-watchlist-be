package jm.stocks.watchlist.infrastructure.adapter;

import jakarta.transaction.Transactional;
import jm.stocks.watchlist.domain.ports.WatchlistRepository;
import jm.stocks.watchlist.domain.model.StockData;
import jm.stocks.watchlist.infrastructure.boundary.outbound.jpa.watchlist.StockEntity;
import jm.stocks.watchlist.infrastructure.boundary.outbound.jpa.watchlist.UserStocksJpaRepository;
import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.QuotesApi;
import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.SeekingAlphaApi;
import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.model.Quote;
import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.model.StockMetrics;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
public class WatchlistRepositoryAdapter implements WatchlistRepository {

    private final QuotesApi quotesApi;
    private final SeekingAlphaApi seekingAlphaApi;
    private final UserStocksJpaRepository repository;

    @Transactional
    public void addToWatchlist(Long userId, String symbol, String companyName){
        if (repository.findByUserIdAndSymbol(userId, symbol).isPresent()){
            log.info(String.format("Stock with symbol %s is already on the watchlist", symbol));
            return;
        }
        repository.save(StockEntity.of(userId, symbol, removeHTMLTags(companyName)));
    }

    @Transactional
    public void removeFromWatchlist(Long userId, String symbol){
        repository.deleteByUserIdAndSymbol(userId, symbol);
    }

    public List<StockData> getWatchlist(Long userId){
        List<StockEntity> stocks = repository.findByUserId(userId);
        if (stocks.isEmpty()){
            return Collections.emptyList();
        }
        List<String> symbols = stocks.stream().map(StockEntity::getSymbol).toList();
        Map<String, StockMetrics> metrics = seekingAlphaApi.getMetrics(symbols).stream().collect(Collectors.toMap(StockMetrics::getSlug, Function.identity()));
        Map<String, Quote> quotes = quotesApi.getQuotes(symbols)
                .getReal_time_quotes().stream().collect(Collectors.toMap(Quote::getSa_slug, Function.identity()));
        return stocks.stream().map(
                stock -> StockData.of(stock, quotes.get(stock.getSymbol()), metrics.get(stock.getSymbol()))
        ).toList();
    }

    private String removeHTMLTags(String input){
        return input.replaceAll("<[^>]*>", "");
    }
}
