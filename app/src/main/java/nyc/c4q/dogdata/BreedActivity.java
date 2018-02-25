package nyc.c4q.dogdata;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import nyc.c4q.dogdata.model.RandomDogImageResponse;
import nyc.c4q.dogdata.utils.DogCeoAPIService;
import nyc.c4q.dogdata.utils.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BreedActivity extends AppCompatActivity implements OnClickListener {

  private static final String SHARED_PREFS_KEY = "sharedPrefsLogin";
  private TextView welcomeText;
  private String username;
  private SharedPreferences userPrefs;
  DogCeoAPIService dogCeoAPIService;
  CardView dog1card;
  CardView dog2card;
  CardView dog3card;
  CardView dog4card;
  ImageView dog1image;
  ImageView dog2image;
  ImageView dog3image;
  ImageView dog4image;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_breed);
    userPrefs = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
    welcomeText = findViewById(R.id.welcome_tv);

    dogCeoAPIService = ServiceGenerator.createService(DogCeoAPIService.class);

    dog1card = findViewById(R.id.dog1_cv);
    dog2card = findViewById(R.id.dog2_cv);
    dog3card = findViewById(R.id.dog3_cv);
    dog4card = findViewById(R.id.dog4_cv);

    setOnClick();

    dog1image = findViewById(R.id.dog1_iv);
    dog2image = findViewById(R.id.dog2_iv);
    dog3image = findViewById(R.id.dog3_iv);
    dog4image = findViewById(R.id.dog4_iv);

    if (!userPrefs.contains("username")) {
      Intent returnIntent = new Intent(this, LoginActivity.class);
      startActivity(returnIntent);
    }
    String welcomeMessage =
        getResources().getString(R.string.breed_activity_welcome) + " " + userPrefs
            .getString("username", "") + "?";
    welcomeText.setText(welcomeMessage);
    loadCardViewImages();
  }

  private void setOnClick() {
    dog1card.setOnClickListener(this);
    dog2card.setOnClickListener(this);
    dog3card.setOnClickListener(this);
    dog4card.setOnClickListener(this);
  }

  private void loadCardViewImages() {
    callBoxerImage();
    callBulldogImage();
    callDingoImage();
    callGermanShepardImage();
  }

  private void callGermanShepardImage() {
    Call<RandomDogImageResponse> call = dogCeoAPIService.getRandomDogImage("germanshepherd");
    call.enqueue(new Callback<RandomDogImageResponse>() {
      @Override
      public void onResponse(Call<RandomDogImageResponse> call,
          Response<RandomDogImageResponse> response) {
        String url = response.message();
        Picasso.with(getApplicationContext()).load(url).into(dog4image);
      }

      @Override
      public void onFailure(Call<RandomDogImageResponse> call, Throwable t) {

      }
    });
  }

  private void callDingoImage() {
    Call<RandomDogImageResponse> call = dogCeoAPIService.getRandomDogImage("dingo");
    call.enqueue(new Callback<RandomDogImageResponse>() {
      @Override
      public void onResponse(Call<RandomDogImageResponse> call,
          Response<RandomDogImageResponse> response) {
        String url = response.message();
        Picasso.with(getApplicationContext()).load(url).into(dog3image);
      }

      @Override
      public void onFailure(Call<RandomDogImageResponse> call, Throwable t) {

      }
    });
  }

  private void callBulldogImage() {
    Call<RandomDogImageResponse> call = dogCeoAPIService.getRandomDogImage("bulldog");
    call.enqueue(new Callback<RandomDogImageResponse>() {
      @Override
      public void onResponse(Call<RandomDogImageResponse> call,
          Response<RandomDogImageResponse> response) {
        String url = response.message();
        Picasso.with(getApplicationContext()).load(url).into(dog2image);
      }

      @Override
      public void onFailure(Call<RandomDogImageResponse> call, Throwable t) {

      }
    });
  }

  private void callBoxerImage() {
    Call<RandomDogImageResponse> call = dogCeoAPIService.getRandomDogImage("boxer");
    call.enqueue(new Callback<RandomDogImageResponse>() {
      @Override
      public void onResponse(Call<RandomDogImageResponse> call,
          Response<RandomDogImageResponse> response) {
        String url = response.message();
        Picasso.with(getApplicationContext()).load(url).resizeDimen(100, 90).into(dog1image);
      }

      @Override
      public void onFailure(Call<RandomDogImageResponse> call, Throwable t) {

      }
    });
  }

  @Override
  public void onClick(View v) {
    Intent intent = new Intent(this, DogsActivity.class);
    int id = v.getId();
    switch (id) {
      case R.id.dog1_cv:
        intent.putExtra("breed", "boxer");
        startActivity(intent);
        break;
      case R.id.dog2_cv:
        intent.putExtra("breed", "bulldog");
        startActivity(intent);
        break;
      case R.id.dog3_cv:
        intent.putExtra("breed", "dingo");
        startActivity(intent);
        break;
      case R.id.dog4_cv:
        intent.putExtra("breed", "germanshepherd");
        startActivity(intent);
        break;
    }
  }
}

