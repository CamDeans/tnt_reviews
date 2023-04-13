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

public class SaturdayActivity extends AppCompatActivity {
    // initialize parameters
    int tickCount, tokenCount;
    EditText edReviewMessage;
    ImageView iv;

    Button isSaturdayTickIncreaseBtn, isSaturdayTickDecreaseBtn, isSaturdayTokenIncreaseBtn, isSaturdayTokenDecreaseBtn, isSaturdayAddReviewBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saturday);

        iv = findViewById(R.id.homeBtn);

        // set event to handle user input
        iv.setOnClickListener(view -> startActivity(new Intent(SaturdayActivity.this, HomeActivity.class)));

        isSaturdayTickDecreaseBtn = findViewById(R.id.isSaturdayTickDecreaseBtn);
        isSaturdayTickIncreaseBtn = findViewById(R.id.isSaturdayTickIncreaseBtn);
        isSaturdayTokenIncreaseBtn = findViewById(R.id.isSaturdayTokenIncreaseBtn);
        isSaturdayTokenDecreaseBtn = findViewById(R.id.isSaturdayTokenDecreaseBtn);

        isSaturdayTickDecreaseBtn.setOnClickListener(view -> {
            tickCount--;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tickCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTickCount(tickCount);
        });

        isSaturdayTickIncreaseBtn.setOnClickListener(view -> {
            tickCount++;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tickCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTickCount(tickCount);
        });

        isSaturdayTokenDecreaseBtn.setOnClickListener(view -> {
            tokenCount--;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tokenCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTokenCount(tokenCount);
        });

        isSaturdayTokenIncreaseBtn.setOnClickListener(view -> {
            tokenCount++;
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setTickCount(tokenCount);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateTokenCount(tokenCount);
        });

        edReviewMessage = findViewById(R.id.isEditTextSaturdayReview);
        isSaturdayAddReviewBtn = findViewById(R.id.isSaturdayAddReviewBtn);

        isSaturdayAddReviewBtn.setOnClickListener(view -> {
            // get tickCount, tokenCount reviewMessage
            // cast to string method () required
            String reviewMessage = edReviewMessage.getText().toString();
            AddReviewDetailsDataDB addReviewDetailsDataDB = AddReviewDetailsDataDB.getInstance(this);
            AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData();
            addReviewDetailsData.setReviewMessage(reviewMessage);
            addReviewDetailsDataDB.addReviewDetailsDataDAO().updateReviewMessage(reviewMessage);

            startActivity(new Intent(SaturdayActivity.this, HomeActivity.class));
        });
    }
}