package nyc.c4q.dogdata;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements OnClickListener {

  private static final String SHARED_PREFS_KEY = "sharedPrefsLogin";
  private SharedPreferences login;
  private EditText username;
  private EditText password;
  private Button launchButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    username = findViewById(R.id.edit_username);
    password = findViewById(R.id.edit_pass);
    launchButton = findViewById(R.id.launch_button);

    launchButton.setOnClickListener(this);
    login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
    if (login.contains("username")) {
      Intent loginIntent = new Intent(this, BreedActivity.class);
      loginIntent.putExtra("prefs_key", SHARED_PREFS_KEY);
      startActivity(loginIntent);
    }
  }

  @Override
  public void onClick(View v) {
    String user = username.getText().toString();
    String pass = password.getText().toString();
    Intent loginIntent = new Intent(this, BreedActivity.class);

    if (user.equals("")) {
      username.setError("please enter a username");
    }
    if (pass.equals("")) {
      password.setError("please enter a password");
    }

    if (!user.equals("") && !pass.equals("")) {
      if (login.contains("username")) {
        if (pass.equals(login.getString(user, null))) {
          startActivity(loginIntent);
        } else {
          password.setError("enter the correct password");
        }
      } else {
        SharedPreferences.Editor editor = login.edit();
        editor.putString("username", user);
        editor.putString(user, pass);
        editor.apply();
        startActivity(loginIntent);
      }
    }

  }
}
