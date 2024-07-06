package lk.rupavahini.PPUManagement.asset.clibrary.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.rupavahini.PPUManagement.util.audit.AuditEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("Clibrary")
@ToString
public class Clibrary extends AuditEntity {

    private int Cid;

    @Size( message = "Enter your Name ")
    private String status;


}
