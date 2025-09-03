package deliveryCompany.services;

import deliveryCompany.data.models.Item;
import deliveryCompany.data.repositories.Items;
import deliveryCompany.data.repositories.TrackingInfosRepo;
import deliveryCompany.dtos.requests.SendItemRequest;
import deliveryCompany.dtos.responses.SendItemResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ItemServiceImplTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private Items items;

    @Autowired
    private TrackingInfosRepo trackingInfosRepo;

    @BeforeEach
    public void setUp() {
        items.deleteAll();
        trackingInfosRepo.deleteAll();
    }

    @Test
    public void saveItemTest() {
        SendItemRequest sendItemRequest = new SendItemRequest();
        itemService.sendItemResponse(sendItemRequest);
        assertEquals(1, items.count());
    }

    @Test
    public void sendItem_RetrieveSentItemReturnSaveItemTest() {
        SendItemRequest sendItemRequest = new SendItemRequest();
        sendItemRequest.setDescription("A pack of Condom");
        sendItemRequest.setSenderName("John");
        sendItemRequest.setReceiverName("Purity");
        sendItemRequest.setPhoneNumber("1234567890");
        sendItemRequest.setWeightInGrammes(3);
        SendItemResponse response = itemService.sendItemResponse(sendItemRequest);

       Item item =  items.findItemsById(response.getTrackingNumber()).get();
       assertEquals("A pack of Condom", item.getDescription());
       assertEquals("John", item.getSenderName());
       assertEquals("Purity", item.getReceiverName());
       assertEquals("1234567890", item.getPhoneNumber());
       assertEquals(3, item.getWeightInGrammes());
    }

    @Test
    public void sendItem_trackingInfoIsOneTest() {
        SendItemRequest sendItemRequest = new SendItemRequest();
        sendItemRequest.setDescription("A pack of Condom");
        sendItemRequest.setSenderName("John");
        sendItemRequest.setReceiverName("Purity");
        sendItemRequest.setPhoneNumber("1234567890");
        sendItemRequest.setWeightInGrammes(3);
        SendItemResponse response = itemService.sendItemResponse(sendItemRequest);
        assertEquals(1, trackingInfosRepo.count());
    }

}