package nyc.c4q.dogdata;

import android.provider.ContactsContract.CommonDataKinds.Im;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class PhotoActivity extends AppCompatActivity {

  ImageView urlPhoto;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_photo);

    urlPhoto = findViewById(R.id.url_photo_view);

    Bundle extras = getIntent().getExtras();
    String url = "";
    if (extras != null) {
       url = extras.getString("url");
    }

    loadUrltoPhoto(url);
  }

  private void loadUrltoPhoto(String url) {
    Picasso.with(this).load(url).into(urlPhoto);
  }

}
