package deliveryCompany.dtos.responses;

import deliveryCompany.dtos.requests.SendItemRequest;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class SendItemResponse {

    private String description;
    private int weightInGrammes;
    private String senderName;
    private String receiverName;
    private String phoneNumber;
    private String trackingNumber;
    private DateTimeFormatter dateSent;


}
