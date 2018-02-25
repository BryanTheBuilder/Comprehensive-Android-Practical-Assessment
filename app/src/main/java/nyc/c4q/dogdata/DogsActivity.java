package nyc.c4q.dogdata;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import nyc.c4q.dogdata.controller.DogAdapter;
import nyc.c4q.dogdata.model.DogResponse;
import nyc.c4q.dogdata.utils.DogCeoAPIService;
import nyc.c4q.dogdata.utils.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogsActivity extends AppCompatActivity {

  RecyclerView dogsRecycler;
  DogAdapter dogAdapter;
  List<String> dogResponseList = new ArrayList<>();
  DogCeoAPIService dogCeoAPIService;
  private TextView dogBreed;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dogs);

    dogBreed = findViewById(R.id.dog_breed);
    Bundle extras = getIntent().getExtras();

    String breed = "";
    if (extras != null) {
      breed = extras.getString("breed");
    }
    dogBreed.setText(breed);
    dogCeoAPIService = ServiceGenerator.createService(DogCeoAPIService.class);
    dogsRecycler = findViewById(R.id.dog_breed_rv);
    configureRecyclerView();

    fetchDogBreedList(breed);
  }

  private void configureRecyclerView() {
    if (getApplication().getResources().getConfiguration().orientation
        == Configuration.ORIENTATION_PORTRAIT) {
      dogsRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
    } else {
      dogsRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
    }

    dogAdapter = new DogAdapter(dogResponseList);
    dogsRecycler.setAdapter(dogAdapter);

  }

  private void fetchDogBreedList(String breed) {
    Call<DogResponse> call = dogCeoAPIService.getDogBreed(breed);
    call.enqueue(new Callback<DogResponse>() {
      @Override
      public void onResponse(Call<DogResponse> call, Response<DogResponse> response) {
        dogResponseList.addAll(response.body().getMessage());
        dogAdapter.notifyDataSetChanged();
      }

      @Override
      public void onFailure(Call<DogResponse> call, Throwable t) {

      }
    });
  }
}
