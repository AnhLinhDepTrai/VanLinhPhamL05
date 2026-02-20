package john.smith.fragmentlab5;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class PhamActivity2 extends AppCompatActivity {

    private TextView tvFullName;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityy_pham);

        // Show back arrow on ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Select Date");
        }

        tvFullName = findViewById(R.id.tvFullNameSecond);
        datePicker = findViewById(R.id.datePicker);

        // Set initial text
        tvFullName.setText("Van Linh Pham");

        // Listener to update TextView when date changes
        datePicker.init(
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                (view, year, monthOfYear, dayOfMonth) -> {
                    String date = (monthOfYear + 1) + "/" + dayOfMonth + "/" + year;
                    tvFullName.setText("Van Linh Pham\nSelected Date: " + date);
                }
        );
    }

    // Handle back arrow click
    @Override
    public boolean onSupportNavigateUp() {
        finish(); // close this activity and go back
        return true;
    }
}