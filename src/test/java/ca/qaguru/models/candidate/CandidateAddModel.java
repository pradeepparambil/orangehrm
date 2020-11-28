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
public class CandidateAddModel {
    private UserModel user;
    private String firstname;
    private String middlename;
    private String lastname;
    private String email;
    private String contactno;
 //   private String JV;
 //   private String keywords;
 //   private String comment;
 private String candidatename;

}
