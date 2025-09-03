package deliveryCompany.dtos.requests;

import lombok.Data;

@Data
public class SendItemRequest {

    private String description;
    private int weightInGrammes;
    private String senderName;
    private String receiverName;
    private String phoneNumber;

}
