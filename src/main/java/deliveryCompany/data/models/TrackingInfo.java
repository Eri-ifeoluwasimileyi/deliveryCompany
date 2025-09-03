package deliveryCompany.data.models;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class TrackingInfo {

    private LocalDateTime createdAt;
    private String event;
}
