package deans.cameron.ticks_n_tokens_reviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // create calendar msg
        SharedPreferences sharedPreferences = getSharedPreferences("shared_pref's", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", null).toString();
        Toast.makeText(getApplicationContext(), "Welcome, " + username + " to the add reviews page. Add ticks or tokens and review message for your child!", Toast.LENGTH_SHORT).show();

        // create functionality of Monday
        // new MondayActivity created
        CardView monday = findViewById(R.id.cardMonday);
        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalendarActivity.this, MondayActivity.class));
            }
        });

        // create functionality of Tuesday
        // new TuesdayActivity created
        CardView tuesday = findViewById(R.id.cardTuesday);
        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalendarActivity.this, TuesdayActivity.class));
            }
        });

        // create functionality of Wednesday
        // new WednesdayActivity created
        CardView wednesday = findViewById(R.id.cardWednesday);
        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalendarActivity.this, WednesdayActivity.class));
            }
        });

        // create functionality of Thursday
        // new ThursdayActivity created
        CardView thursday = findViewById(R.id.cardThursday);
        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalendarActivity.this, ThursdayActivity.class));
            }
        });

        // create functionality of Friday
        // new FridayActivity created
        CardView friday = findViewById(R.id.cardFriday);
        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalendarActivity.this, FridayActivity.class));
            }
        });

        // create functionality of Saturday
        // new SaturdayActivity created
        CardView saturday = findViewById(R.id.cardSaturday);
        saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalendarActivity.this, SaturdayActivity.class));
            }
        });

        // create functionality of Sunday
        // new SundayActivity created
        CardView sunday = findViewById(R.id.cardSunday);
        sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalendarActivity.this, SundayActivity.class));
            }
        });

        // create functionality of Home
        // new HomeActivity created
        CardView home = findViewById(R.id.cardHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalendarActivity.this, HomeActivity.class));
            }
        });
    }
}