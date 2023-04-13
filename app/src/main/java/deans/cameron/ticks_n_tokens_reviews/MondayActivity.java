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

public class MondayActivity extends AppCompatActivity {
    // initialize parameters
    int tickCount, tokenCount;
    EditText edReviewMessage;
    ImageView iv;

    Button isMondayTickIncreaseBtn, isMondayTickDecreaseBtn, isMondayTokenIncreaseBtn, isMondayTokenDecreaseBtn, isMondayAddReviewBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);

        iv = findViewById(R.id.homeBtn);

        // set event to handle user input
        iv.setOnClickListener(view -> startActivity(new Intent(MondayActivity.this, HomeActivity.class)));

        isMondayTickDecreaseBtn = findViewById(R.id.isMondayTickDecreaseBtn);
        isMondayTickIncreaseBtn = findViewById(R.id.isMondayTickIncreaseBtn);
        isMondayTokenIncreaseBtn = findViewById(R.id.isMondayTokenIncreaseBtn);
        isMondayTokenDecreaseBtn = findViewById(R.id.isMondayTokenDecreaseBtn);

        isMondayTickDecreaseBtn.setOnClickListener(view -> {
            tickCount--;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tickCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTickCount(tickCount);
        });

        isMondayTickIncreaseBtn.setOnClickListener(view -> {
            tickCount++;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tickCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTickCount(tickCount);
        });

        isMondayTokenDecreaseBtn.setOnClickListener(view -> {
            tokenCount--;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tokenCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTokenCount(tokenCount);
        });

        isMondayTokenIncreaseBtn.setOnClickListener(view -> {
            tokenCount++;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tokenCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTokenCount(tokenCount);
        });

        edReviewMessage = findViewById(R.id.isEditTextMondayReview);
        isMondayAddReviewBtn = findViewById(R.id.isMondayAddReviewBtn);

        isMondayAddReviewBtn.setOnClickListener(view -> {
            // get tickCount, tokenCount reviewMessage
            // cast to string method () required
            String reviewMessage = edReviewMessage.getText().toString();
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setReviewMessage(reviewMessage);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateReviewMessage(reviewMessage);

            startActivity(new Intent(MondayActivity.this, HomeActivity.class));
        });
    }
}