package deliveryCompany.utils;

import deliveryCompany.data.models.Item;
import deliveryCompany.dtos.requests.SendItemRequest;
import deliveryCompany.dtos.responses.SendItemResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static Item convertToItem(SendItemRequest sendItemRequest) {
        Item item = new Item();
        item.setDescription(sendItemRequest.getDescription());
        item.setSenderName(sendItemRequest.getSenderName());
        item.setReceiverName(sendItemRequest.getReceiverName());
        item.setPhoneNumber( sendItemRequest.getPhoneNumber());
        item.setWeightInGrammes(sendItemRequest.getWeightInGrammes());
        return new Item();
    }

    public static SendItemResponse convertToSendItemResponse(Item item) {
        SendItemResponse sendItemResponse = new SendItemResponse();
        sendItemResponse.setTrackingNumber(item.getId());
        sendItemResponse.setDescription(item.getDescription());
        sendItemResponse.setReceiverName(item.getReceiverName());
        sendItemResponse.setSenderName(item.getSenderName());
        sendItemResponse.setPhoneNumber(item.getPhoneNumber());
        sendItemResponse.setWeightInGrammes(item.getWeightInGrammes());
        sendItemResponse.setDateSent(DateTimeFormatter.ofPattern("EEE, dd MM yyyy, hh:mm:ss a"));

        return new SendItemResponse();
    }
}
