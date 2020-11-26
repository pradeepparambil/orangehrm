package ca.qaguru.models.jobcategory;

import ca.qaguru.models.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JCModel {
    private UserModel user;
    private String jobCategory;

}
