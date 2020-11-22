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
public class JSModel {
        private UserModel user;
        private String shiftname;
        private String action;
        private String fromtime;
        private String totime;
        private String employee;
        private String modaddemployee;
        private String modshiftname;
        private String modfromtime;
        private String modtotime;
        private String modemployee;
        private String canceladdaction;
        private String canceladdemployee;
        private String delcancelemployee;

}

