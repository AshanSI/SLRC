package lk.rupavahini.PPUManagement.asset.sponsor.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.rupavahini.PPUManagement.asset.message.entity.EmailMessage;
import lk.rupavahini.PPUManagement.asset.programme.entity.ProgrammeSponsor;
import lk.rupavahini.PPUManagement.util.audit.AuditEntity;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("Sponsor")
@ToString
public class Sponsor extends AuditEntity {


    @Size(min = 5, message = "Your Company name cannot be accepted")
    private String name;

    @Column(unique = true)
    private String code;

    /*@Size(min = 2, message = "Your BRN cannot be accepted")
    private String brn;*/

    @Size(max = 10, min = 9, message = "Mobile number length should be contained 10 and 9")
    private String contactOne;

    private String contactTwo;

    @Column(unique = true)
    private String email;

    @Column(columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NULL", length = 255)
    private String address;

    @OneToMany(mappedBy = "sponsor", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<ProgrammeSponsor> programmeSponsors;



}
