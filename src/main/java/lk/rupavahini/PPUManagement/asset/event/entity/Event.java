package lk.rupavahini.PPUManagement.asset.event.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime start;
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime finish;
    private String eventtype;
}
