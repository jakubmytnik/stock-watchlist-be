package jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha;

import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.model.QuotesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@FeignClient(value = "seeking-alpha-quotes", url = "${api.seekingAlphaQuotes.url}")
public interface QuotesApi {

    default QuotesResponse  getQuotes(Collection<String> symbols){
        return getQuotes(String.join(",", symbols));
    }

    @GetMapping("/real_time_quotes")
    QuotesResponse getQuotes(@RequestParam("sa_slugs") String symbols);
}
