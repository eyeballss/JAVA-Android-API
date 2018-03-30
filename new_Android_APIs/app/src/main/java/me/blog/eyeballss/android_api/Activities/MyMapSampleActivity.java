package me.blog.eyeballss.android_api.Activities;

import android.location.Location;
import android.location.LocationListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import me.blog.eyeballss.android_api.R;
import me.blog.eyeballss.android_api.Utils.MyMap;

public class MyMapSampleActivity extends AppCompatActivity {

    private MyMap myMap;
    private TextView myLocation;
    private EditText search, latitude, longitude, numberFrom, numberTo;
    private Button searchBtn, navigatieBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_map_sample);

        myMap = new MyMap(this);

        myLocation = findViewById(R.id.my_location);
        search = findViewById(R.id.search_google_map);
        searchBtn = findViewById(R.id.search_google_map_btn);
        latitude = findViewById(R.id.navigate_google_map_lat);
        longitude = findViewById(R.id.navigate_google_map_lng);
        navigatieBtn = findViewById(R.id.navigate_google_map_btn);
        numberFrom = findViewById(R.id.number_from);
        numberTo = findViewById(R.id.number_to);


        //핸드폰의 gps를 켰는지 체크.
        myMap.checkGPS();

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //내 위치가 바뀔때마다 위도 경도가 바뀐다.
                myLocation.setText(location.getLatitude() + " , " + location.getLongitude());
                search.setText("검색어를 넣으세요.");
                searchBtn.setEnabled(true);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        myMap.getMyLocation(locationListener);

        //구글맵을 이용하여 검색한다.
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = search.getText().toString();
                myMap.searchWithThirdParyMapNearMe(MyMapSampleActivity.this, query);
            }
        });

        //구글맵을 이용하여 길찾기를 한다.
        navigatieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double lat = Double.parseDouble(latitude.getText().toString());
                    double lng = Double.parseDouble(longitude.getText().toString());

                    myMap.navigateWithThirdParyMap(MyMapSampleActivity.this, lat, lng);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });

        //double 값(distance)을 meter 혹은 kilometer String 으로 변환한다.
        numberFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    double number = Double.parseDouble(numberFrom.getText().toString());
                    String meter = myMap.parseDistanceToMeter(number, true);
                    numberTo.setText(meter);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
