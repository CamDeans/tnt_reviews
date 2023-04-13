package deans.cameron.ticks_n_tokens_reviews;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ThursdayActivity extends AppCompatActivity {
    // initialize parameters
    int tickCount, tokenCount;
    EditText edReviewMessage;
    ImageView iv;

    Button isThursdayTickIncreaseBtn, isThursdayTickDecreaseBtn, isThursdayTokenIncreaseBtn, isThursdayTokenDecreaseBtn, isThursdayAddReviewBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thursday);

        iv = findViewById(R.id.homeBtn);

        // set event to handle user input
        iv.setOnClickListener(view -> startActivity(new Intent(ThursdayActivity.this, HomeActivity.class)));

        isThursdayTickDecreaseBtn = findViewById(R.id.isThursdayTickDecreaseBtn);
        isThursdayTickIncreaseBtn = findViewById(R.id.isThursdayTickIncreaseBtn);
        isThursdayTokenIncreaseBtn = findViewById(R.id.isThursdayTokenIncreaseBtn);
        isThursdayTokenDecreaseBtn = findViewById(R.id.isThursdayTokenDecreaseBtn);

        isThursdayTickDecreaseBtn.setOnClickListener(view -> {
            tickCount--;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tickCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTickCount(tickCount);
        });

        isThursdayTickIncreaseBtn.setOnClickListener(view -> {
            tickCount++;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tickCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTickCount(tickCount);
        });

        isThursdayTokenDecreaseBtn.setOnClickListener(view -> {
            tokenCount--;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tokenCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTokenCount(tokenCount);
        });

        isThursdayTokenIncreaseBtn.setOnClickListener(view -> {
            tokenCount++;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tokenCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTokenCount(tokenCount);
        });

        edReviewMessage = findViewById(R.id.isEditTextThursdayReview);
        isThursdayAddReviewBtn = findViewById(R.id.isThursdayAddReviewBtn);

        isThursdayAddReviewBtn.setOnClickListener(view -> {
            // get tickCount, tokenCount reviewMessage
            // cast to string method () required
            String reviewMessage = edReviewMessage.getText().toString();
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setReviewMessage(reviewMessage);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateReviewMessage(reviewMessage);

            startActivity(new Intent(ThursdayActivity.this, HomeActivity.class));
        });
    }
}