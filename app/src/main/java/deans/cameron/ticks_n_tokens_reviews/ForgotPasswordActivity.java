package deans.cameron.ticks_n_tokens_reviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {
    // initialize parameters
    EditText edUsername, edPassword, edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        // create object
        edUsername = findViewById(R.id.editTextUpdatePwdUsername);
        edPassword = findViewById(R.id.editTextUpdatePwdNewPassword);
        edConfirm = findViewById(R.id.editTextUpdatePwdConfirmPassword);
        btn = findViewById(R.id.buttonUpdatePwdPassword);
        tv = findViewById(R.id.textViewExistingUser);

        // set event to handle moving to a new activity
        tv.setOnClickListener(view -> startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class)));

        // set event to handle user input
        btn.setOnClickListener(view -> {
            // get username, email, password and confirm password from the user
            // cast to string method () required
            String username = edUsername.getText().toString();
            String password = edPassword.getText().toString();
            String confirm = edConfirm.getText().toString();
            AddDetailsData addDetailsData = new AddDetailsData();
            // validation step for getText method () and user input of type 0
            if (username.length() == 0 || password.length() == 0 || confirm.length() == 0) {
                // temporary call to display btn press functionality
                // Toast takes (3) parameters values passed in
                // outcome: application will output a popup text bubble IE> alert
                Toast.makeText(getApplicationContext(), "Please fill all details!", Toast.LENGTH_SHORT).show();
            } else if (password.compareTo(confirm) == 0) {
                if (isValid(password)) {
                    // insert data into the DB
                    register(password);
                    Toast.makeText(getApplicationContext(), "Record Updated", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters, having letter, digit and special symbol!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Password and Confirm didn't match!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // password validation builtin method ()
    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < passwordhere.length(); s++) {
                char c = passwordhere.charAt(s);
                if (c >= 33 && c <= 48 || c == 64) {
                    f3 = 1;
                }
            }
            return f1 == 1 && f2 == 1 && f3 == 1;
        }
    }

    //
    public void register(String newPassword) {
        UserDataDB userDataDB = UserDataDB.getInstance(this);
        userDataDB.userDataDAO().update(newPassword);
    }
}