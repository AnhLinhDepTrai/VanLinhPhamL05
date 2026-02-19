/** Author's Name: Van Linh Pham
 * Student's ID: N01681546
 * */
package john.smith.fragmentlab5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class VanLinhActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.layout.activity_main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}