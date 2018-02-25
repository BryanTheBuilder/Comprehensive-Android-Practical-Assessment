package nyc.c4q.dogdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BreedActivity extends AppCompatActivity {

  private TextView welcomeText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Bundle extras = getIntent().getExtras();

    welcomeText = findViewById(R.id.welcome_tv);


  }
}

