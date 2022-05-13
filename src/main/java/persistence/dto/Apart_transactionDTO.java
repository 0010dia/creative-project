package persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Apart_transactionDTO {
    private int id;
    private String si_gun_gu;
    private String road_name;
    private String danji_name;
    private String area;
    private String floor;
    private String build_year;
    private String contract_y_m;
    private String contract_d;
    private int trade_amount;
}
