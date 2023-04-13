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

public class WednesdayActivity extends AppCompatActivity {
    // initialize parameters
    int tickCount, tokenCount;
    EditText edReviewMessage;
    ImageView iv;

    Button isWednesdayTickIncreaseBtn, isWednesdayTickDecreaseBtn, isWednesdayTokenIncreaseBtn, isWednesdayTokenDecreaseBtn, isWednesdayAddReviewBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wednesday);

        iv = findViewById(R.id.homeBtn);

        // set event to handle user input
        iv.setOnClickListener(view -> startActivity(new Intent(WednesdayActivity.this, HomeActivity.class)));

        isWednesdayTickDecreaseBtn = findViewById(R.id.isWednesdayTickDecreaseBtn);
        isWednesdayTickIncreaseBtn = findViewById(R.id.isWednesdayTickIncreaseBtn);
        isWednesdayTokenIncreaseBtn = findViewById(R.id.isWednesdayTokenIncreaseBtn);
        isWednesdayTokenDecreaseBtn = findViewById(R.id.isWednesdayTokenDecreaseBtn);

        isWednesdayTickDecreaseBtn.setOnClickListener(view -> {
            tickCount--;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tickCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTickCount(tickCount);
        });

        isWednesdayTickIncreaseBtn.setOnClickListener(view -> {
            tickCount++;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tickCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTickCount(tickCount);
        });

        isWednesdayTokenDecreaseBtn.setOnClickListener(view -> {
            tokenCount--;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tokenCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTokenCount(tokenCount);
        });

        isWednesdayTokenIncreaseBtn.setOnClickListener(view -> {
            tokenCount++;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tokenCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTokenCount(tokenCount);
        });

        edReviewMessage = findViewById(R.id.isEditTextWednesdayReview);
        isWednesdayAddReviewBtn = findViewById(R.id.isWednesdayAddReviewBtn);

        isWednesdayAddReviewBtn.setOnClickListener(view -> {
            // get tickCount, tokenCount reviewMessage
            // cast to string method () required
            String reviewMessage = edReviewMessage.getText().toString();
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setReviewMessage(reviewMessage);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateReviewMessage(reviewMessage);

            startActivity(new Intent(WednesdayActivity.this, HomeActivity.class));
        });
    }
}