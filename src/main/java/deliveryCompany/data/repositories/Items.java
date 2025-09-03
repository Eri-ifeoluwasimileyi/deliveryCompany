package deliveryCompany.data.repositories;

import deliveryCompany.data.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface Items extends MongoRepository<Item, String> {

    Optional<Item> findItemsById(String id);

}
