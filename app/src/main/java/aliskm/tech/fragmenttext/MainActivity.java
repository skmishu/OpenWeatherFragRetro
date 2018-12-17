package aliskm.tech.fragmenttext;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentContainer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    final String[] fragmentInterval = {"FragOne", "FragTwo"};
    String fragmentTracker = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragTransation(new FragmentOne(), fragmentInterval[0]);
    }

    public void onChangeFragment(View view) {
        if (fragmentTracker.contains(fragmentInterval[0])) {
            fragTransation(new FragmentOne(), fragmentInterval[0]);
            fragmentTracker = fragmentInterval[1];
        } else {
            fragTransation(new FragmentTwo(), fragmentInterval[1]);
            fragmentTracker = fragmentInterval[0];
        }
    }

    private void fragTransation(Fragment fragment, String fragID) {
        try {
            fragmentManager.beginTransaction().replace(R.id.container, fragment, fragID).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
