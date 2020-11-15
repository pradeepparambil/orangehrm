package ca.qaguru.models.nationality;

import ca.qaguru.models.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NationalityModel {
    private UserModel user;
    private String nationality;
}
