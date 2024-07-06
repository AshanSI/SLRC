package lk.rupavahini.PPUManagement.asset.employee.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import lk.rupavahini.PPUManagement.asset.commonAsset.model.Enum.CivilStatus;
import lk.rupavahini.PPUManagement.asset.commonAsset.model.Enum.Gender;
import lk.rupavahini.PPUManagement.asset.commonAsset.model.Enum.Title;
import lk.rupavahini.PPUManagement.asset.commonAsset.model.FileInfo;
import lk.rupavahini.PPUManagement.asset.employee.entity.Enum.Designation;
import lk.rupavahini.PPUManagement.asset.employee.entity.Enum.EmployeeStatus;
import lk.rupavahini.PPUManagement.asset.message.entity.EmailMessage;
import lk.rupavahini.PPUManagement.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dom4j.Branch;
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
@JsonFilter("Employee")
public class Employee extends AuditEntity {


    // Get Employee Name
    @Size(min = 5, message = "Your name cannot be accepted")
    private String name;

    //Get Employee NIC
    @Size(max = 12, min = 10, message = "NIC number is contained numbers between 9 and X/V or 12 ")
    @Column(unique = true)
    private String nic;

    //Get Employee Mobile Number 01
    @Size(max = 10, message = "Mobile number length should be contained 10 and 9")
    private String mobileOne;

    //Get Employee email
    @Column(unique = true)
    private String email;

    //Get employee address
    @Column(columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NULL", length = 255)
    private String address;

    //Get employee gender
    @Enumerated(EnumType.STRING)
    private Gender gender;

    //Get employee title
    @Enumerated( EnumType.STRING )
    private Title title;

    //Get Employee designation
    @Enumerated(EnumType.STRING)
    private Designation designation;

    //Get Employee Civil status
    @Enumerated(EnumType.STRING)
    private CivilStatus civilStatus;

    //Get Employee Enum
    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

    //Get Employee Date of Birth
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    //get employee email address
    @ManyToMany(mappedBy = "employees")
    private List<EmailMessage> emailMessages;


    @Transient
    private MultipartFile file ;

    @Transient
    private List<String> removeImages = new ArrayList<>();

    @Transient
    private FileInfo fileInfo;

}
