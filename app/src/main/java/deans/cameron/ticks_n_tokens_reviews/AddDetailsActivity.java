package deans.cameron.ticks_n_tokens_reviews;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AddDetailsActivity extends AppCompatActivity {
    // initialize parameters
    ImageView iv;
    EditText edChildName, edChildAge, edChore1, edChore2, edChore3, edTntNumberSelection, edAward, edPunishment;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        iv = findViewById(R.id.homeBtn);

        // set event to handle user input
        iv.setOnClickListener(view -> startActivity(new Intent(AddDetailsActivity.this, HomeActivity.class)));

        // create object
        edChildName = findViewById(R.id.editTextChildName);
        edChildAge = findViewById(R.id.editTextChildAge);
        edChore1 = findViewById(R.id.editTextChore1);
        edChore2 = findViewById(R.id.editTextChore2);
        edChore3 = findViewById(R.id.editTextChore3);
        edTntNumberSelection = findViewById(R.id.editTextTntNumberSelection);
        edAward = findViewById(R.id.editTextAward);
        edPunishment = findViewById(R.id.editTextPunishment);
        btn = findViewById(R.id.buttonUpdateDetails);

        // set event to handle user input
        btn.setOnClickListener(view -> {
            // get ChildName, ChildAge, Chore(s) 1-3, TntNumberSelection, Awards, Punishments from the user
            // cast to string method () required
            String childName = edChildName.getText().toString();
            int childAge = Integer.parseInt(edChildAge.getText().toString());
            String chore1 = edChore1.getText().toString();
            String chore2 = edChore2.getText().toString();
            String chore3 = edChore3.getText().toString();
            int tntNumberSelection = Integer.parseInt(edTntNumberSelection.getText().toString());
            String award = edAward.getText().toString();
            String punishment = edPunishment.getText().toString();
            // validation step for getText method () and user input of type 0
            if (childName.length() == 0 || childAge == 0 || chore1.length() == 0 || chore2.length() == 0 ||
                    chore3.length() == 0 || tntNumberSelection == 0 || award.length() == 0 || punishment.length() == 0) {
                // temporary call to display btn press functionality
                // Toast takes (3) parameters values passed in
                // outcome: application will output a popup text bubble IE> alert
                Toast.makeText(getApplicationContext(), "Please fill all details!", Toast.LENGTH_SHORT).show();
            } else {
                // insert data into the DB
                addDetails(childName, childAge, chore1, chore2, chore3, tntNumberSelection, award, punishment);
                Toast.makeText(getApplicationContext(), "All Details Inserted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddDetailsActivity.this, HomeActivity.class));
            }
        });
    }

    // AddDetails method ()
    public void addDetails(String childName, int childAge, String chore1, String chore2, String chore3, int tntNumberSelection, String award, String punishment) {
        AddDetailsData addDetailsData = new AddDetailsData(childName, childAge, chore1, chore2, chore3, tntNumberSelection, award, punishment);
        AddDetailsDataDB addDetailsDataDB = AddDetailsDataDB.getInstance(this);
        addDetailsDataDB.addDetailsDataDAO().insert(addDetailsData);
    }
}