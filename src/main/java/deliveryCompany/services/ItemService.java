package deliveryCompany.services;

import deliveryCompany.dtos.requests.SendItemRequest;
import deliveryCompany.dtos.responses.SendItemResponse;

public interface ItemService {

    SendItemResponse sendItemResponse(SendItemRequest sendItemRequest);
}
