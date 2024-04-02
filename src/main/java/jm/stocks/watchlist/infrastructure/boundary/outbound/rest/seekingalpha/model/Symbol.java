package jm.stocks.watchlist.infrastructure.boundary.outbound.rest.seekingalpha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Symbol {
    Integer id;
    String content;
    String slug;
}
