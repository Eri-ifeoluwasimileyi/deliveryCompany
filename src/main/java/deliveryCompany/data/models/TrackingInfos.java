package deliveryCompany.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class TrackingInfos {
    @Id
    private String id;
    private String packageId;
    private List<TrackingInfo> infos;
}
