package deans.cameron.ticks_n_tokens_reviews;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    // initialize parameters
    EditText edUsername, edPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // create object
        edUsername = findViewById(R.id.editTextLoginUsername);
        edPassword = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textViewNewUser);

        // set event to handle user input
        btn.setOnClickListener(view -> {
            // get username and password from the user
            // cast to string method () required
            String username = edUsername.getText().toString();
            String password = edPassword.getText().toString();
            // validation step for getText method () and user input of type 0
            if (username.length() == 0 || password.length() == 0) {
                // temporary call to display btn press functionality
                // Toast takes (3) parameters values passed in
                // outcome: application will output a popup text bubble IE> alert
                Toast.makeText(getApplicationContext(), "Please fill all details!", Toast.LENGTH_SHORT).show();
            } else {
                // validate login info
                if (login(username, password) == 1) {
                    Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getSharedPreferences("shared_pref's", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username);
                    // TO save our data with key and value
                    editor.apply();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }
            }
        });

        // set event to handle moving to a new activity
        tv.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
    }

    //
    public int login(String username, String password) {
        // user created, username: cdeans, password: qwerty1!
        UserDataDB userDataDB = UserDataDB.getInstance(this);
        int result = 0;
        String[] str = new String[2];
        str[0] = username;
        str[1] = password;
        Cursor c = userDataDB.query("select * from userdata where username=? and password=?", str);
        if (c.moveToFirst()) {
            result = 1;
        }
        return result;
    }
}