package jm.stocks.watchlist.configuration.feign;


import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.QuotesApi;
import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.SeekingAlphaApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableFeignClients(clients = {
        SeekingAlphaApi.class,
        QuotesApi.class
})
public class FeignClientConfiguration {

    @Bean
    HeadersInterceptor headersInterceptor(){
        return new HeadersInterceptor();
    }
}
