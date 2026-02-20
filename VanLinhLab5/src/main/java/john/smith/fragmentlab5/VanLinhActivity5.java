package john.smith.fragmentlab5;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;


public class VanLinhActivity5 extends AppCompatActivity implements ListFragmentSmith.OnItemSelectedListener {

    private ActivityResultLauncher<String> requestCallPermissionLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup fragments
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

        // Modern back handling
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                showExitDialog();
            }
        });

        // Setup runtime permission request for CALL_PHONE
        requestCallPermissionLauncher = registerForActivityResult(
                new ActivityResultContracts.RequestPermission(),
                isGranted -> {
                    if (isGranted) {
                        makePhoneCall();
                    } else {
                        Toast.makeText(this, R.string.denied, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    // Inflate menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Handle menu clicks
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_date) {
            startActivity(new Intent(this, PhamActivity2.class));
            return true;
        } else if (id == R.id.action_dial) {
            handleCallPermission();
            return true;
        } else if (id == R.id.action_camera) {
            startActivity(new Intent(getString(R.string.imagecap)));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    // Fragment callback
    @Override
    public void onItemSelected(String definitionText) {
        DefinitionFragmentJohn definitionFragment = DefinitionFragmentJohn.newInstance(definitionText, "");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.VanLinhfragmentContainerView2, definitionFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    // Exit dialog
    private void showExitDialog() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.b)
                .setTitle(R.string.farlab5)
                .setMessage(R.string.exit)
                .setPositiveButton(R.string.Y, (dialog, which) -> finish())
                .setNegativeButton(R.string.N, (dialog, which) -> dialog.dismiss())
                .setCancelable(false)
                .show();
    }

    // Check permission and request if needed
    private void handleCallPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED) {
            makePhoneCall();
        } else {
            requestCallPermissionLauncher.launch(Manifest.permission.CALL_PHONE);
        }
    }

    // Make the actual phone call
    private void makePhoneCall() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse(getString(R.string.thenumber))); // your chosen number
        startActivity(callIntent);
    }
}