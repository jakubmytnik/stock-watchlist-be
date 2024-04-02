package jm.stocks.watchlist.configuration;

import jm.stocks.watchlist.domain.StockSearchFacade;
import jm.stocks.watchlist.domain.StocksWatchlistFacade;
import jm.stocks.watchlist.domain.ports.StockSearchInterface;
import jm.stocks.watchlist.domain.ports.WatchlistRepository;
import jm.stocks.watchlist.infrastructure.adapter.StockSearchAdapter;
import jm.stocks.watchlist.infrastructure.adapter.WatchlistRepositoryAdapter;
import jm.stocks.watchlist.infrastructure.boundary.outbound.jpa.watchlist.UserStocksJpaRepository;
import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.QuotesApi;
import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.SeekingAlphaApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    WatchlistRepository watchlistRepository(QuotesApi quotesApi, SeekingAlphaApi seekingAlphaApi, UserStocksJpaRepository userStocksJpaRepository){
        return new WatchlistRepositoryAdapter(quotesApi, seekingAlphaApi, userStocksJpaRepository);
    }
    @Bean
    StocksWatchlistFacade stocksWatchlistFacade(WatchlistRepository watchlistRepository){
        return new StocksWatchlistFacade(watchlistRepository);
    }
    @Bean
    StockSearchInterface stockSearchInterface(SeekingAlphaApi seekingAlphaApi){
        return new StockSearchAdapter(seekingAlphaApi);
    }

    @Bean
    StockSearchFacade stockSearchFacade(StockSearchInterface stockSearchInterface){
        return new StockSearchFacade(stockSearchInterface);
    }
}
