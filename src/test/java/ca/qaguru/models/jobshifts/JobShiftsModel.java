package ca.qaguru.models.jobshifts;

import ca.qaguru.models.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobShiftsModel {
        private UserModel user;
        private String ShiftName;
        private String action;
        private String FromTime;
        private String ToTime;
        private String employee;
}

