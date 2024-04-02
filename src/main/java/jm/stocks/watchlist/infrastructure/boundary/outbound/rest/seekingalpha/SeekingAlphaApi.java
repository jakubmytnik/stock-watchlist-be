package jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha;

import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.model.SearchSymbolResponse;
import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.model.StockMetrics;
import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@FeignClient(value = "seeking-alpha", url = "${api.seekingAlpha.url}")
public interface SeekingAlphaApi {

    List<String> METRICS = List.of(
            "dividend_yield", "dividend_growth", "payout_ratio","div_grow_rate5","div_grow_rate3","cf_payout"
    );
    String DELIMITER = ",";
    String SEARCH_TYPE = "symbols";
    String LIST_PARAM = "all";
    String PERIOD_PARAM = "all";
    String DEFUALT_PAGE_SIZE = "10";
    String DEFAULT_PAGE_NR = "1";

    default List<StockMetrics> getMetrics(@NonNull Collection<String> symbols){
        return getMetrics(String.join(DELIMITER, symbols),
                String.join(DELIMITER, METRICS),
                Boolean.TRUE.toString());
    }

    @GetMapping("/metrics")
    List<StockMetrics> getMetrics(@RequestParam("filter[slugs]") String symbols,
                                  @RequestParam(value = "filter[fields]") String fields,
                                  @RequestParam(value = "minified", defaultValue = "true") String minified);

    default SearchSymbolResponse searchBySymbol(String query){
        return searchBySymbol(query, SEARCH_TYPE, LIST_PARAM, PERIOD_PARAM, DEFUALT_PAGE_SIZE, DEFAULT_PAGE_NR);
    }

    @GetMapping("/searches")
    SearchSymbolResponse searchBySymbol(@RequestParam("filter[query]") String query,
                                        @RequestParam("filter[type]") String type,
                                        @RequestParam("filter[list]") String list,
                                        @RequestParam("filter[period]") String period,
                                        @RequestParam("page[size]") String size,
                                        @RequestParam("page[number]") String number
                        );
}
