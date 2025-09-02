package deliveryCompany.data.repositories;

import deliveryCompany.data.models.TrackingInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackingInfosRepo extends MongoRepository<TrackingInfo, String> {
}
