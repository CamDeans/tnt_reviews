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

public class SundayActivity extends AppCompatActivity {
    // initialize parameters
    int tickCount, tokenCount;
    EditText edReviewMessage;
    ImageView iv;

    Button isSundayTickIncreaseBtn, isSundayTickDecreaseBtn, isSundayTokenIncreaseBtn, isSundayTokenDecreaseBtn, isSundayAddReviewBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunday);

        iv = findViewById(R.id.homeBtn);

        // set event to handle user input
        iv.setOnClickListener(view -> startActivity(new Intent(SundayActivity.this, HomeActivity.class)));

        isSundayTickDecreaseBtn = findViewById(R.id.isSundayTickDecreaseBtn);
        isSundayTickIncreaseBtn = findViewById(R.id.isSundayTickIncreaseBtn);
        isSundayTokenIncreaseBtn = findViewById(R.id.isSundayTokenIncreaseBtn);
        isSundayTokenDecreaseBtn = findViewById(R.id.isSundayTokenDecreaseBtn);

        isSundayTickDecreaseBtn.setOnClickListener(view -> {
            tickCount--;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tickCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTickCount(tickCount);
        });

        isSundayTickIncreaseBtn.setOnClickListener(view -> {
            tickCount++;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tickCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTickCount(tickCount);
        });

        isSundayTokenDecreaseBtn.setOnClickListener(view -> {
            tokenCount--;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tokenCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTokenCount(tokenCount);
        });

        isSundayTokenIncreaseBtn.setOnClickListener(view -> {
            tokenCount++;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tokenCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTokenCount(tokenCount);
        });

        edReviewMessage = findViewById(R.id.isEditTextSundayReview);
        isSundayAddReviewBtn = findViewById(R.id.isSundayAddReviewBtn);

        isSundayAddReviewBtn.setOnClickListener(view -> {
            // get tickCount, tokenCount reviewMessage
            // cast to string method () required
            String reviewMessage = edReviewMessage.getText().toString();
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setReviewMessage(reviewMessage);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateReviewMessage(reviewMessage);

            startActivity(new Intent(SundayActivity.this, HomeActivity.class));
        });
    }
}