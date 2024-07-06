package lk.rupavahini.PPUManagement.asset.employee.entity.Enum;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Designation {

    PRODUCER("Producer"),
    EDITOR("Editor"),
    BO("Booking Officer"),
    ENGINEER("Engineer"),
    CLA("Casset library admin"),
    SPONSOR("Who spend money for programme");

    private final String designation;
}

