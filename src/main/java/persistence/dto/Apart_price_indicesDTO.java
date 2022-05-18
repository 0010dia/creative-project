package persistence.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

public class Apart_price_indicesDTO {
    private String id;
    private String date;
    private String jeonguk_indices;
    private String seoul_indices;
    private String busan_indices;
    private String daegu_indices;
    private String incheon_indices;
    private String gwangju_indices;
    private String daejeon_indices;
    private String ulsan_indices;
    private String sejong_indices;
    private String Gyeonggi_indices;
    private String Gangwon_indices;
    private String Chungbuk_indices;
    private String Chungnam_indices;
    private String Jeonbuk_indices;
    private String Jeonnam_indices;
    private String Gyeongbuk_indices;
    private String Gyeongnam_indices;
    private String Jeju_indices;
}