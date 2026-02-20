package john.smith.fragmentlab5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class VanLinhActivity5 extends AppCompatActivity implements ListFragmentSmith.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
    }


    @Override
    public void onItemSelected(String definitionText) {
        DefinitionFragmentJohn definitionFragment = DefinitionFragmentJohn.newInstance(definitionText, "");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.VanLinhfragmentContainerView2, definitionFragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
