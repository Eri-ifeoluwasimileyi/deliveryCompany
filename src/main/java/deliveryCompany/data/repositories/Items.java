package deliveryCompany.data.repositories;

import deliveryCompany.data.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Items  extends MongoRepository<Item, String> {
}
