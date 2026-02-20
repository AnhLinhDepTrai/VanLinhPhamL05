package john.smith.fragmentlab5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.activity.OnBackPressedCallback;

public class VanLinhActivity5 extends AppCompatActivity implements ListFragmentSmith.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Only add fragments if first creation
        if (savedInstanceState == null) {

            ListFragmentSmith listFragment = ListFragmentSmith.newInstance("", "");
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.VanLinhfragmentContainerView, listFragment);
            ft.commit();

            DefinitionFragmentJohn definitionFragment = DefinitionFragmentJohn.newInstance("", "");
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
            ft2.replace(R.id.VanLinhfragmentContainerView2, definitionFragment);
            ft2.commit();
        }

        // Modern back handling (for gestures and back button)
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                showExitDialog(); // Show exit confirmation
            }
        });
    }

    @Override
    public void onItemSelected(String definitionText) {
        DefinitionFragmentJohn definitionFragment = DefinitionFragmentJohn.newInstance(definitionText, "");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.VanLinhfragmentContainerView2, definitionFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    // Modern exit dialog
    private void showExitDialog() {
        androidx.appcompat.app.AlertDialog.Builder builder =
                new androidx.appcompat.app.AlertDialog.Builder(this);

        builder.setIcon(R.drawable.b); // Your custom icon
        builder.setTitle("Fragment Lab 5");
        builder.setMessage("Do you want to exit the app?");
        builder.setPositiveButton("Yes", (dialog, which) -> finish());
        builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
        builder.setCancelable(false); // User must choose Yes or No
        builder.show();
    }
}