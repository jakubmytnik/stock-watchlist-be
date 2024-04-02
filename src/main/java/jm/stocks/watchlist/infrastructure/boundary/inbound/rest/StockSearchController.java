package jm.stocks.watchlist.infrastructure.boundary.inbound.rest;

import io.swagger.v3.oas.annotations.Operation;
import jm.stocks.watchlist.domain.StockSearchFacade;
import jm.stocks.watchlist.infrastructure.boundary.inbound.rest.model.StockSearchResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/symbols")
@AllArgsConstructor
@Slf4j
public class StockSearchController {
    private final StockSearchFacade stockSearchFacade;

    @GetMapping("/search/{symbol}")
    @Operation(summary = "Search stock by symbol")
    public List<StockSearchResult> getSymbols(@PathVariable("symbol") String symbol) {
        return stockSearchFacade.search(symbol);
    }

}
