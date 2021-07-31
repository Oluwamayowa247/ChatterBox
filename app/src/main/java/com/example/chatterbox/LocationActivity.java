package com.example.chatterbox;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.chatterbox.databinding.ActivityLocationBinding;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class LocationActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    List<String> phoneNumbers = Arrays.asList("08055354400", "08158333720", "08074191212");
    private ActivityLocationBinding binding;
    private LocationListener locationListener;
    private LocationManager locationManager;
    private final long MIN_TIM = 1000; // 1seconds
    private final long MIN_DIST = 5; // meters
    private LatLng latLng;
    String context = Context.LOCATION_SERVICE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},
                PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET},
                PackageManager.PERMISSION_GRANTED);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {

               try{
                   latLng = new LatLng(location.getLatitude(), location.getLongitude() );
                   mMap.addMarker(new MarkerOptions().position(latLng).title("My Location"));
                   mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

                  String myLatitude = String.valueOf(location.getLatitude());
                  String myLongitude = String.valueOf(location.getLongitude());
                  String message = "At the moment this are the co-ordinates to my current location my latitude is "
                          + myLatitude + "also my longitude is " + myLongitude;

                   SmsManager smsManager = SmsManager.getDefault();
                   smsManager.sendTextMessage(String.valueOf(phoneNumbers), null, message, null,
                           null );

               }
               catch (SecurityException s){
                   s.printStackTrace();
               }

            }

            @Override
            public void onProviderDisabled(@NonNull String provider) {

            }

            @Override
            public void onProviderEnabled(@NonNull String provider) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }
        };
        locationManager = (LocationManager) getSystemService(context);
        try {

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIM, MIN_DIST, locationListener);
        }
        catch (SecurityException s){
            s.printStackTrace();
        }
    }
}