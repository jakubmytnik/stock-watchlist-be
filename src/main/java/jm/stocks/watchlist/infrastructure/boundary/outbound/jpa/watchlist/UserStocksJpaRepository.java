package jm.stocks.watchlist.infrastructure.boundary.outbound.jpa.watchlist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserStocksJpaRepository extends JpaRepository<StockEntity, Long> {
    List<StockEntity> findByUserId(Long userId);

    Optional<StockEntity> findByUserIdAndSymbol(Long userId, String symbol);

    void deleteByUserIdAndSymbol(Long userId, String symbol);
}
