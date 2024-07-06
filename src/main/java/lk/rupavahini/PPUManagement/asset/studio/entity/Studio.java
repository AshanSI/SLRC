package lk.rupavahini.PPUManagement.asset.studio.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.rupavahini.PPUManagement.asset.programme.entity.Programme;
import lk.rupavahini.PPUManagement.util.audit.AuditEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("Studio")
@ToString
public class Studio extends AuditEntity {

    @Size(min = 5, message = "Please Enter Studio Name")
    private String studioName;

    @Size(min = 2 , message = "Enter Studio Condition")
    private String location;

    @Size(min = 2 , message = "Enter Studio Condition")
    private String code;

    @ManyToOne
    private Programme programme;

}
