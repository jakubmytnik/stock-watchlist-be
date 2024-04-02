package jm.stocks.watchlist.infrastructure.boundary.inbound.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddStockPayload {
    String companyName;
}
