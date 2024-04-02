package jm.stocks.watchlist;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@Slf4j
public class StocksWatchlistApplication {
    public static void main(String[] args) {
        SpringApplication.run(StocksWatchlistApplication.class, args);
        log.info("Application is up and running");
    }
}
