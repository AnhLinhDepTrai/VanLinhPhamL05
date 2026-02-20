//Van Linh Pham
//N01681546
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


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.select_date);
        }

        tvFullName = findViewById(R.id.tvFullNameSecond);
        datePicker = findViewById(R.id.datePicker);


        tvFullName.setText(R.string.van_linh_pam);


        datePicker.init(
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                (view, year, monthOfYear, dayOfMonth) -> {
                    String date = (monthOfYear + 1) + "/" + dayOfMonth + "/" + year;
                    tvFullName.setText(getString(R.string.van_linh_pham_selected_date) + date);
                }
        );
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish(); // close this activity and go back
        return true;
    }
}