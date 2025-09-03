package deliveryCompany.services;

import deliveryCompany.data.models.Item;
import deliveryCompany.data.models.TrackingInfo;
import deliveryCompany.data.models.TrackingInfos;
import deliveryCompany.data.repositories.Items;
import deliveryCompany.data.repositories.TrackingInfosRepo;
import deliveryCompany.dtos.requests.SendItemRequest;
import deliveryCompany.dtos.responses.SendItemResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static deliveryCompany.utils.Mapper.convertToItem;
import static deliveryCompany.utils.Mapper.convertToSendItemResponse;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private Items items;

    @Autowired
    private TrackingInfosRepo trackingInfosRepo;

    @Override
    public SendItemResponse sendItemResponse(SendItemRequest sendItemRequest) {
        Item item = convertToItem(sendItemRequest);
        addTrackingInfoFor(item, String.format("%s sent a package to %s", item.getSenderName(), item.getReceiverName()));

        return convertToSendItemResponse(items.save(item));
    }

    private void addTrackingInfoFor(Item item, String info){
        Optional<TrackingInfos> optionalTrackingInfos = trackingInfosRepo.findByPackageId(item.getId());
        if(optionalTrackingInfos.isPresent()){
            TrackingInfo trackingInfo = new TrackingInfo();
            trackingInfo.setCreatedAt(LocalDateTime.now());
            trackingInfo.setEvent(info);
            optionalTrackingInfos.get().getInfos().add(trackingInfo);
            trackingInfosRepo.save(optionalTrackingInfos.get());
        }
        else {
            TrackingInfos infos = new TrackingInfos();
            TrackingInfo trackingInfo = new TrackingInfo();
            trackingInfo.setCreatedAt(LocalDateTime.now());
            trackingInfo.setEvent(info);
            infos.getInfos().add(trackingInfo);

            infos.setPackageId(items.save(item).getId());

            item.setTrackingInfos(trackingInfosRepo.save(infos));
            items.save(item);

        }
    }
}

