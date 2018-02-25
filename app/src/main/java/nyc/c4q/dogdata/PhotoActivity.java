package nyc.c4q.dogdata;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class PhotoActivity extends AppCompatActivity {

  ImageView urlPhoto;
  SharedPreferences userPrefs;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_photo);

    userPrefs = getSharedPreferences(getResources().getString(R.string.shared_prefs_key),
        MODE_PRIVATE);

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

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.action_menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.action_logout) {
      SharedPreferences.Editor editor = userPrefs.edit();
      editor.clear();
      editor.apply();
      Intent intent = new Intent(this, LoginActivity.class);
      startActivity(intent);
    }
    return super.onOptionsItemSelected(item);
  }

}
