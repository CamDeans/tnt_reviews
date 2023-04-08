package deans.cameron.ticks_n_tokens_reviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class TntHomeActivity extends AppCompatActivity {
    // initialize parameters
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tnt_home);

        iv = findViewById(R.id.homeBtn);

        // set event to handle user input
        iv.setOnClickListener(view -> {
            startActivity(new Intent(TntHomeActivity.this, HomeActivity.class));
        });
    }
}