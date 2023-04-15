package uk.ac.tees.b1448179.gibbse_library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class FindMe extends AppCompatActivity implements View.OnClickListener {

    private Button logout,user_profile;
    FusedLocationProviderClient fusedLocationProviderClient;
    TextView lattitude,longitude,address,city,country;
    Button getLocation;
    private final static int REQUEST_CODE = 100; //to request location

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_me);

        // Inflate the layout for this fragment
        lattitude = findViewById(R.id.lattitude);
        longitude = findViewById(R.id.longitude);
        address = findViewById(R.id.address);
        city = findViewById(R.id.city);
        country = findViewById(R.id.country);
        getLocation = findViewById(R.id.getLocation);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getLastLocation();

            }
        });

//        logout = (Button) findViewById(R.id.home_page_button);
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                Toast.makeText(FindMe.this, "Logged out successfully!!", Toast.LENGTH_LONG).show();
//                startActivity(new Intent(FindMe.this,MainActivity.class));
//            }
//        });
//        user_profile = (Button) findViewById(R.id.user_profile);
//        user_profile.setOnClickListener(this);
        }

//set on click for each scenario in homepage
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.search_view:
                startActivity(new Intent(this, MyLocalDatabase.class));
        }
    }


    //create method for location permission
    private void getLastLocation() {

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {

                            if (location != null) {
                                try {
                                    Geocoder geocoder = new Geocoder(FindMe.this, Locale.getDefault());
                                    List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                                    lattitude.setText("Lattitude: " + addresses.get(0).getLatitude());
                                    longitude.setText("Longitude: " + addresses.get(0).getLongitude());
                                    address.setText("Address: " + addresses.get(0).getAddressLine(0));
                                    city.setText("City: " + addresses.get(0).getLocality());
                                    country.setText("Country: " + addresses.get(0).getCountryName());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
        } else {
            askPermission();
        }

    }

    //method for ask permission
    private void askPermission() {

        ActivityCompat.requestPermissions(FindMe.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @org.jetbrains.annotations.NotNull String[] permissions, @NonNull @org.jetbrains.annotations.NotNull int[] grantResults) {

        if (requestCode == REQUEST_CODE){

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){


                getLastLocation();

            }else {


                Toast.makeText(FindMe.this,"Please provide the required permission",Toast.LENGTH_SHORT).show();

            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}