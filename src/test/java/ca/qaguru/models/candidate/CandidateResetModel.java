package ca.qaguru.models.candidate;

import ca.qaguru.models.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)


public class CandidateResetModel {
    private UserModel user;
    private String CandidateName;
}
