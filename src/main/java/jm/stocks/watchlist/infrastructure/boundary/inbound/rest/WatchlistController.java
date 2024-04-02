package jm.stocks.watchlist.infrastructure.boundary.inbound.rest;

import jm.stocks.watchlist.domain.StocksWatchlistFacade;
import jm.stocks.watchlist.domain.model.StockData;
import jm.stocks.watchlist.infrastructure.boundary.inbound.rest.model.AddStockPayload;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/watchlist")
@AllArgsConstructor
@Slf4j
public class WatchlistController {
    private final StocksWatchlistFacade watchlistFacade;

    @PostMapping("/{symbol}")
    public void addToWatchlist(@PathVariable("symbol") String symbol, @RequestBody AddStockPayload addStockPayload){
        watchlistFacade.addToWatchlist(symbol.toUpperCase(), addStockPayload.getCompanyName());
    }

    @DeleteMapping("/{symbol}")
    public void removeFromWatchlist(@PathVariable("symbol") String symbol){
       watchlistFacade.removeFromWatchlist(symbol);
    }

    @GetMapping
    public List<StockData> getWatchlist(){
        return watchlistFacade.getWatchlist();
    }

}
