package jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchSymbolResponse {
    List<Symbol> symbols;
}
