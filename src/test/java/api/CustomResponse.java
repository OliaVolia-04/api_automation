package api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)  // ignores other properties, it takes what we provide only
public class CustomResponse {

 private String category_title;
 private int category_id;
 private String created;
 private String category_description;
private boolean flag;


 private int seller_id;
 private String seller_name;
 private String company_name;


}
