package lk.rupavahini.PPUManagement.asset.episode.entty;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.rupavahini.PPUManagement.asset.programme.entity.Programme;
import lk.rupavahini.PPUManagement.util.audit.AuditEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("episode")
@ToString
public class Episode extends AuditEntity {

    @Size(min = 3)
    private String programmeCode;

    private String episodeNumber;

    @Column(unique = true)
    private String code;

    /*@Size(message = "Enter Recorded Date")*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate recordedDate;

    @ManyToOne
    private Programme programme;

}
