package lk.rupavahini.PPUManagement.asset.programme.entity;

import com.fasterxml.jackson.annotation.JsonFilter;

import lk.rupavahini.PPUManagement.asset.sponsor.entity.Sponsor;
import lk.rupavahini.PPUManagement.util.audit.AuditEntity;
import lombok.*;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("ProgrammeSponsor")
@ToString
public class ProgrammeSponsor extends AuditEntity {


    @ManyToOne
    private Programme programme;

    @ManyToOne
    private Sponsor sponsor;

}
