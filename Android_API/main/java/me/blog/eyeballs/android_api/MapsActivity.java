package me.blog.eyeballs.android_api;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {
    private LocationManager locationManager;
    private GoogleMap mMap;
    final long MIN_UPDATE_TIME = 1000*5*1; //1000ms = 1초, 즉 1분 단위로 갱신한다는 의미.
    final float MIN_UPDATE_DISTANCE = 1.0f;//1.0f; // 1m 단위로 갱신한다는 의미.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        initLocation();
        checkGPS();
    }

    public void setMyLocation(boolean b){
        mMap.setMyLocationEnabled(b);
    }

    public void moveCamera(Location location){
        moveCamera(location, 15);
    }

    public void moveCamera(Location location, int zoom){
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        moveCamera(latLng, zoom);
    }

    public void moveCamera(LatLng latLng){

        moveCamera(latLng, 15);
    }

    public void moveCamera(LatLng latLng, int zoom) {

        //현재 위치를 지도에 표시!
        if(mMap == null) return;

        LatLng myLoc = latLng;
        CameraPosition cp = new CameraPosition.Builder()
                .target(myLoc) //위치
                .zoom(zoom) //확대 정도
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
    }

    public void cleanMarkers(){
        if(mMap==null) return;
        mMap.clear();
    }

    public void addMarkers(Location location){
        addMarkers(new LatLng(location.getLatitude(), location.getLongitude()));
    }

    public void addMarkers(LatLng latLng){
        addMarkers(latLng, getAddress(latLng));
    }

    public void addMarkers(LatLng latLng, String title){
        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title(title));
    }

    public String getAddress(LatLng latLng){
        return getAddress(latLng.latitude, latLng.longitude);
    }

    public String getAddress(Location location){
        return getAddress(location.getLatitude(), location.getLongitude());
    }

    //lat, lng 을 address로 바꾸는 메소드
    public String getAddress(double lat, double lng){
        String result="somewhere";
        //lat과 lng을 받고 geocoder와 짬뽕시켜서 주소로 변환.
        Geocoder geocoder = new Geocoder(this, Locale.KOREA);
        //기본 준비는 끝. 이제 변환
        List<Address> addressList = null;
        try {
            addressList = geocoder.getFromLocation(lat, lng, 2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        if(addressList!= null && addressList.size()>0){
            for(Address ad : addressList){
                Utility.Log("LocationInformation",
                        "adressLines : "+ad.getAddressLine(0)+
                                "featureName: "+ad.getFeatureName()+
                                "latitude: "+ad.getLatitude()+
                                "longitude: "+ad.getLongitude()+
                                "adminArea: "+ad.getAdminArea()+
                                "countryCode: "+ad.getCountryCode()+
                                "countryName: "+ad.getCountryName()+
                                "locality: "+ad.getLocality()+
                                "phone: "+ad.getPhone()+
                                "postalCode: "+ad.getPostalCode()+
                                "premises: "+ad.getPremises()+
                                "subAdminArea: "+ad.getSubAdminArea()+
                                "subLocality: "+ad.getSubLocality()+
                                "subThoroughfare: "+ad.getSubThoroughfare()+
                                "thoroughfare: "+ad.getThoroughfare()+
                                "url: "+ad.getUrl()+
                                "maxAddressLineIndex: "+ad.getMaxAddressLineIndex()+
                                "locale: "+ad.getLocale()+
                                "extras: "+ad.getExtras()
                        );
                result= ad.getAddressLine(0);
            }
        }
        //주소 결과는 아래처럼 나옴.
        //Address[
        // addressLines=[0:"대한민국 서울특별시 관악구 낙성대동"],
        // feature=낙성대동,
        // admin=서울특별시,
        // sub-admin=null,
        // locality=관악구,
        // thoroughfare=낙성대동,
        // postalCode=null,
        // countryCode=KR,
        // countryName=대한민국,
        // hasLatitude=true,
        // latitude=37.4762397,
        // hasLongitude=true,
        // longitude=126.9583907,
        // phone=null,
        // url=null,
        // extras=null] 낙성대동

        return result;
    }

    private void initLocation() {
        //위치 매니저를 획득
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        //위치 정보를 제공하는 공급자(3개 : gps, wifi, 통신망)의 가용 여부를 획득!
        boolean isGPSOn = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);         //센서
        boolean isPassOn = locationManager.isProviderEnabled(LocationManager.PASSIVE_PROVIDER);    //기지국
        boolean isNetOn = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);    //wifi

        //각 공급자별로 처리를 함.
        if (!isGPSOn && !isNetOn && !isPassOn) {
            return;
        }

        Location location = null;

        if (isPassOn) {
            locationManager.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER,
                    MIN_UPDATE_TIME,
                    MIN_UPDATE_DISTANCE,
                    this);
            location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        }
        if (isGPSOn) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    MIN_UPDATE_TIME,
                    MIN_UPDATE_DISTANCE,
                    this);
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
        if (isNetOn) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                    MIN_UPDATE_TIME,
                    MIN_UPDATE_DISTANCE,
                    this);
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }

        moveCamera(location);

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
        setMyLocation(true); //true를 넣으면 현재 내 위치가 보이고 false 넣으면 현재 내 위치가 보이지 않는다.


        //클릭 리스너를 다는 방법.
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                moveCamera(latLng, 17);
                cleanMarkers();
                addMarkers(latLng, "Click Testing!");
            }
        });

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                moveCamera(latLng, 17);
                cleanMarkers();
                addMarkers(latLng, "Long Click Testing!");
            }
        });
    }


    //아래는 LocationListener의 GPS 콜백 메소드
    @Override
    public void onLocationChanged(Location location) {
        //위치가 업데이트 되었을 때의 코드가 여기 들어간다.
        //예를 들어 아래 처럼 위치로 이동해라! 같은.
        moveCamera(location);
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


    public boolean checkGPS() {
        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean isGPS = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isGPS) {
            return true;
        } else {

            Toast.makeText(this, "GPS를 켜주세요.",Toast.LENGTH_LONG).show();

            //사용자가 GPS를 켤 수 있게 옵션 창을 띄우고 싶다면 finish();를 지우고 아래 주석을 풀면 됨
//            Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//            startActivity(intent);

            finish();

        }
        return false;
    }


    //destroy가 된 후에도 GPS를 계속 쓰고 싶다면 이곳을 바꾸면 됨.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //각종 설정된 리스너들을 해제! 및 detecting 중단!
        locationManager.removeUpdates(this);
        locationManager=null;
        mMap=null;
    }
}
