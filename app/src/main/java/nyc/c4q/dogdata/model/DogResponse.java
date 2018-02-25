package nyc.c4q.dogdata.model;

import java.util.List;

/**
 * Created by c4q on 2/25/18.
 */

public class DogResponse {

  private List<String> message;
  private String status;

  public List<String> getMessage() {
    return message;
  }

  public String getStatus() {
    return status;
  }
}
