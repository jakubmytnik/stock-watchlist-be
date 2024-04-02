package jm.stocks.watchlist.infrastructure.boundary.outbound.jpa.watchlist;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "sw_schema", name = "user_stocks")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String symbol;
    private String companyName;

    public static StockEntity of (Long userId, String symbol, String name){
        StockEntity se =  new StockEntity();
        se.setUserId(userId);
        se.setSymbol(symbol);
        se.setCompanyName(name);
        return se;
    }
}
