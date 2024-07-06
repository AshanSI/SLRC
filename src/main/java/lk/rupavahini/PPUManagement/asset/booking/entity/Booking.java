package lk.rupavahini.PPUManagement.asset.booking.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.rupavahini.PPUManagement.util.audit.AuditEntity;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("Booking")
@ToString
public class Booking extends AuditEntity {



    /*@Size(min = 5, message = "Please Enter Studio Name")*/
    private String SCode;



  /*  @Size(min = 2 , message = "Enter Studio Condition")
    private String location;

    @Size(min = 2 , message = "Enter Studio Condition")
    private String code;

    @ManyToOne
    private Programme programme;*/

}
