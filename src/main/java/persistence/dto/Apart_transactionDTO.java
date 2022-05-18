package persistence.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

public class Apart_transactionDTO {
    private String id;
    private String si_gun_gu;
    private String road_name;
    private String danji_name;
    private String area;
    private String contract_y_m;
    private String contract_d;
    private int trade_amount;
    private String floor;
    private String build_year;
}
