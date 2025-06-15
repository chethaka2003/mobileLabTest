package codeSolution.com.s23010597.chethaka;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

public class Lab_3 extends AppCompatActivity implements OnMapReadyCallback {

    List<Address> listGeoCoder;
    double longitude = 79.88672221571899;
    double latitude = 6.883334835242636;
    EditText address;

    private GoogleMap myMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab_3);

        address = findViewById(R.id.address);  // Correct: assign EditText here

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null)
            mapFragment.getMapAsync(this);
    }

    //Onready state using
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        myMap = googleMap;
        LatLng test = new LatLng(latitude, longitude);
        myMap.addMarker(new MarkerOptions().position(test).title("Default Marker"));
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(test, 18.0f));
        myMap.getUiSettings().setZoomControlsEnabled(true);
    }

    //Get the user inputs
    public void findLoc(View view) {
        String inputText = address.getText().toString();
        if (inputText.isEmpty()) {
            Log.e("findLoc", "Address input is empty");
            return;
        }

        try {
            listGeoCoder = new Geocoder(this, Locale.getDefault())
                    .getFromLocationName(inputText, 1);

            if (listGeoCoder != null && !listGeoCoder.isEmpty()) {
                latitude = listGeoCoder.get(0).getLatitude();
                longitude = listGeoCoder.get(0).getLongitude();
                String countryName = listGeoCoder.get(0).getCountryName();

                Log.i("GOOGLE_MAP_TAG", "Longitude: " + longitude +
                        " Latitude: " + latitude +
                        " Country: " + countryName);

                LatLng location = new LatLng(latitude, longitude);
                myMap.clear(); // clear previous markers
                myMap.addMarker(new MarkerOptions().position(location).title("Searched Location"));
                myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 18.0f));
            } else {
                Log.e("GOOGLE_MAP_TAG", "No location found for input.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
