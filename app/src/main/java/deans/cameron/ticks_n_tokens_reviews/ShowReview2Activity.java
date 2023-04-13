package deans.cameron.ticks_n_tokens_reviews;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ShowReview2Activity extends AppCompatActivity {
    // initialize parameters
    ImageView iv;

    // Define a handler on the UI thread.
    Handler handler = new Handler();

    // Define a List object that will contain data retrieved from the database.
    List<AddReviewDetailsData> addReviewDetailsDataList = null;

    @SuppressLint("MissingInflatedId")
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_show_review2);

            ListView listView2 = (ListView) findViewById(R.id.listView2);

            iv = findViewById(R.id.homeBtn);

            // set event to handle user input
            iv.setOnClickListener(view -> startActivity(new Intent(ShowReview2Activity.this, HomeActivity.class)));

            // Define the runnable that will update the user interface
            Runnable showReviewDataList = () -> {
                for (AddReviewDetailsData item : addReviewDetailsDataList) {
                    // Add the Person object to an ArrayList
                    ArrayList<AddReviewDetailsData> reviewList = new ArrayList<>();
                    AddReviewDetailsData isReview = new AddReviewDetailsData(item.getTickCount(), item.getTokenCount(), item.getReviewMessage());
                    reviewList.add(isReview);
                    ReviewListAdapter reviewListAdapter = new ReviewListAdapter(this, R.layout.activity_review2, reviewList);
                    listView2.setAdapter(reviewListAdapter);
                }
            };

            // post the showReviewDataList Runnable to the UI thread.
            Runnable updateReviewUI = () -> {
                AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
                addReviewDetailsDataList = (List<AddReviewDetailsData>) addReviewDetailsDataDB.addReviewDetailsDataDAO().findAllData();
                handler.post(showReviewDataList);
            };

            Thread thread = new Thread(updateReviewUI);
            thread.start();
    }
}