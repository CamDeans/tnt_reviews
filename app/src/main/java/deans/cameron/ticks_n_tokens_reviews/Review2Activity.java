package deans.cameron.ticks_n_tokens_reviews;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Review2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review2);

        startActivity(new Intent(Review2Activity.this, ShowReview2Activity.class));
    }
}