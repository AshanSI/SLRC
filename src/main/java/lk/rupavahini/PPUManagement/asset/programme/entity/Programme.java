package lk.rupavahini.PPUManagement.asset.programme.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.rupavahini.PPUManagement.asset.episode.entty.Episode;
import lk.rupavahini.PPUManagement.asset.commonAsset.model.FileInfo;
import lk.rupavahini.PPUManagement.asset.employee.entity.Employee;
import lk.rupavahini.PPUManagement.asset.message.entity.EmailMessage;
import lk.rupavahini.PPUManagement.asset.studio.entity.Studio;
import lk.rupavahini.PPUManagement.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("Programme")
public class Programme extends AuditEntity {


    @Size(min = 5, message = "Enter Programme Name ")
    private String programmeName;

    @Size(min = 5, message = "Enter Producer Name ")
    private String producerName;

    @Size(min = 5, message = "Enter Sponsor Name ")
    private String sponsorName;

     @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate broadcastingDate;

    private String broadcastingTime;

    private String code;

    @ManyToOne
    private Employee employees;


    @OneToMany(mappedBy = "programme",cascade = CascadeType.ALL)
    private List<Episode> episodes;


    @OneToMany(mappedBy = "programme", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Studio> studios;

    @OneToMany(mappedBy = "programme",fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<ProgrammeSponsor> programmeSponsors;

    @ManyToMany(mappedBy = "employees")
    private List<EmailMessage> emailMessages;



}
