import jm.stocks.watchlist.infrastructure.adapter.WatchlistRepositoryAdapter
import jm.stocks.watchlist.infrastructure.boundary.outbound.jpa.watchlist.StockEntity
import jm.stocks.watchlist.infrastructure.boundary.outbound.jpa.watchlist.UserStocksJpaRepository
import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.QuotesApi
import jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.SeekingAlphaApi
import spock.lang.Specification

class WatchlistRepositoryAdapterSpec extends Specification{

    def quotesApi = Mock(QuotesApi)
    def seekingAlphaApi = Mock(SeekingAlphaApi)
    def userStocksRepo = Mock(UserStocksJpaRepository)

    def watchlistRepositoryAdapter = new WatchlistRepositoryAdapter(quotesApi, seekingAlphaApi, userStocksRepo)

    def "Should not add stock to watchlist if it already exists"(){
        given:
            def userId = 100L
            def stockSymbol = "XYZ"
            userStocksRepo.findByUserIdAndSymbol(userId, stockSymbol) >> Optional.of(StockEntity.of(100L, stockSymbol, "name"))
        when:
            watchlistRepositoryAdapter.addToWatchlist(userId, stockSymbol, "SampleName")
        then:
            0 * userStocksRepo.save(_)
    }
}
