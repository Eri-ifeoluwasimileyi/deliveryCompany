package deliveryCompany.data.models;

import lombok.Data;

import java.time.LocalDate;


@Data
public class TrackingInfo {

    private LocalDate createdAt;
    private String event;
}
