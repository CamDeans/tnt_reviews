package deans.cameron.ticks_n_tokens_reviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // create welcome msg
        SharedPreferences sharedPreferences = getSharedPreferences("shared_pref's", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", null).toString();
        Toast.makeText(getApplicationContext(), "Welcome " + username, Toast.LENGTH_SHORT).show();

        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // clear memory stored in SharedPreference
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
        });

        // create functionality of TNT_Home
        // new TntHomeActivity created
        CardView tntHome = findViewById(R.id.cardTntHome);
        tntHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, TntHomeActivity.class));
            }
        });

        // create functionality of AddDetails
        // new AddDetailsActivity created
        CardView addDetails = findViewById(R.id.cardAddDetails);
        addDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, AddDetailsActivity.class));
            }
        });

        // create functionality of CardReviews
        // new CardReviewsActivity created
        CardView reviews = findViewById(R.id.cardReviews);
        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ReviewActivity.class));
            }
        });

        // create functionality of CardReviews
        // new CardReviewsActivity created
        CardView calendar = findViewById(R.id.cardCalendar);
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CalendarActivity.class));
            }
        });
    }
}