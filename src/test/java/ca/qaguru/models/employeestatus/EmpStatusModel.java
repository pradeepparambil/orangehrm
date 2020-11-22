package ca.qaguru.models.employeestatus;
import ca.qaguru.models.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)


public class EmpStatusModel {
    private UserModel user;
    private String empStatus;
}

