package nyc.c4q.dogdata.utils;

import nyc.c4q.dogdata.model.DogResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by c4q on 2/25/18.
 */

public interface DogCeoAPIService {

  @GET("api/breed/{breed name}/images")
  Call<DogResponse> getDogBreed();

}
