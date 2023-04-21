package uk.ac.tees.b1448179.gibbse_library;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import uk.ac.tees.b1448179.gibbse_library.AllFragmentsContainer.CatalogueFragment;
import uk.ac.tees.b1448179.gibbse_library.AllFragmentsContainer.HomeFragment;
import uk.ac.tees.b1448179.gibbse_library.AllFragmentsContainer.ProfileFragment;
import uk.ac.tees.b1448179.gibbse_library.databinding.ActivityMain2Binding;

public class MainActivity extends AppCompatActivity {

    ActivityMain2Binding binding;
   // private Button bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main2);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

      /* ToDo implement drawer on dashboard fragment

      final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        }); */

        //replaceFragment(new DashboardFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.homeFragment:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.catalogueFragment:
                    replaceFragment(new CatalogueFragment());
                    break;
                case R.id.profileFragment:
                    replaceFragment(new ProfileFragment());
                    break;


            }

            return true;
        });

    }
//create method replacefragment to switch between fragments
    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.constraint, fragment);
        fragmentTransaction.commit();
    }
}