package lk.rupavahini.PPUManagement.asset.commonAsset.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class EventModel {

    private Long id;

    private String title;
    private String description;
//    @Temporal(TemporalType.TIMESTAMP)
    private String start;
//    @Temporal(TemporalType.TIMESTAMP)
    private String finish;
    private String eventtype;
}
