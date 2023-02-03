package com.example.season9;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.os.Handler;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class E01GoogleMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e01_google_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        LatLng milad    = new LatLng(35.74514061870242, 51.37522190391984);
        LatLng daryache = new LatLng(35.74407157529471, 51.21278806230759);
        mMap.addMarker(new MarkerOptions().position(milad).title("Borje milad")).isDraggable();
        mMap.addMarker(new MarkerOptions().position(daryache).title("daryache"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(milad , 15));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(daryache , 15));
            }
        },5000);

    }
}