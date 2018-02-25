package nyc.c4q.dogdata.utils;

import nyc.c4q.dogdata.model.DogResponse;
import nyc.c4q.dogdata.model.RandomDogImageResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by c4q on 2/25/18.
 */

public interface DogCeoAPIService {

  @GET("api/breed/{breed_name}/images")
  Call<DogResponse> getDogBreed(@Path("breed_name") String breedName);

  @GET("api/breed/{breed_name}/images/random")
  Call<RandomDogImageResponse> getRandomDogImage(@Path("breed_name") String breedName);
}
