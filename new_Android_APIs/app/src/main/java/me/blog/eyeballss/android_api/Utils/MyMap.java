package me.blog.eyeballss.android_api.Utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by david on 18. 3. 6.
 */

public class MyMap {
    public final static int PERMISSION_ACCESS_FINE_LOCATION = 2;

    public void navigateWithThirdParyMap(Context context, double lat, double lng, String mode) {

        //다른 지도 앱을 이용하여 길찾기를 할 때의 모드
        //d 자동차 , w 도보 , b 자전거
        if (mode.equals("d") || mode.equals("w") || mode.equals("b")) {
            mode = "&mode=" + mode;
        } else mode = "";

        Uri gmmIntentUri = Uri.parse("google.navigation:q=" + lat + "," + lng + mode);

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        if (mapIntent.resolveActivity(context.getPackageManager()) == null) {
            Toast.makeText(context, "현재 길찾기를 할 지도 어플리케이션이 핸드폰에 없습니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        context.startActivity(mapIntent);
    }

    public void navigateWithThirdParyMap(Context context, double lat, double lng) {
        navigateWithThirdParyMap(context, lat, lng, "w");
    }

    public void searchWithThirdParyMap(Context context, double lat, double lng, String query) {
        Uri gmmIntentUri = Uri.parse("geo:"+lat+","+lng+"?q="+query);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(context.getPackageManager()) == null) {
            Toast.makeText(context, "현재 길찾기를 할 지도 어플리케이션이 핸드폰에 없습니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        context.startActivity(mapIntent);
    }

    public void searchWithThirdParyMapNearMe(Context context, String query) {
        Location myLocation = getMyLocation();
        if(myLocation==null) return;
        searchWithThirdParyMap(context, myLocation.getLatitude(), myLocation.getLongitude(), query);
    }

        private Context context;
    private LocationManager locationManager;
    private LocationListener locationListener;

    final long MIN_UPDATE_TIME = 1000; //1000ms = 1초, 즉 2초 단위로 갱신한다는 의미.
    final float MIN_UPDATE_DISTANCE = 1.0f;//1.0f; // 1m 단위로 갱신한다는 의미.

    public MyMap(Context context) {
        if(context==null) return;
        //위치 매니저를 획득
        locationManager = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
        this.context = context;
    }

    public float getDistanceBetween(Location a, Location b) {
        //a와 b 사이의 직선 거리가 meter 단위로 반환되어 나옵니다.
        return a.distanceTo(b);
    }

    public Location getMyLocation(LocationListener locationListener) {
        //위치 권한이 없으면 null을 리턴
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }

        //리스너를 저장
        this.locationListener = locationListener;

        //듣기 시작.
        listenMyLocation(locationListener);

        Location location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        return location;
    }

    public Location getMyLocation() {
        //위치 권한이 없으면 null을 리턴
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        return location;
    }

    public String getProvider(){

        //위치 정보를 제공하는 공급자(3개 : gps, wifi, 통신망)의 가용 여부를 획득!
        boolean isGPSOn = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);         //센서
        boolean isPassOn = locationManager.isProviderEnabled(LocationManager.PASSIVE_PROVIDER);    //기지국
        boolean isNetOn = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);    //wifi

        //각 공급자별로 처리를 함.
        if (!isGPSOn && !isNetOn && !isPassOn) {
            return null;
        }

        String provider = null;

        if (isPassOn) provider = LocationManager.PASSIVE_PROVIDER;
        if (isGPSOn) provider = LocationManager.GPS_PROVIDER;
        if (isNetOn) provider = LocationManager.NETWORK_PROVIDER;

        return provider;
    }

    public Location convertDoubleToLocation(double lat, double lng){
        Location location = new Location(LocationManager.GPS_PROVIDER);
        location.setLatitude(lat);
        location.setLongitude(lng);
        return location;
    }

    public Location convertStringToLocation(String lat, String lng){
        double latDouble = Double.parseDouble(lat);
        double lngDouble = Double.parseDouble(lng);
        return convertDoubleToLocation(latDouble, lngDouble);
    }

    public boolean isGPSAvailable(){
        if(context==null) return false;

        LocationManager lm = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
        boolean isGPS = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isGPS) return true;
        else return false;

    }


    public boolean checkGPS() {
        LocationManager lm = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
        boolean isGPS = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isGPS) {
            return true;
        } else {

            Toast.makeText(context, "GPS를 켜주세요.", Toast.LENGTH_LONG).show();

            //사용자가 GPS를 켤 수 있게 옵션 창을 띄우고 싶다면 finish();를 지우고 아래 주석을 풀면 됨
            Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            context.startActivity(intent);

            return false;
        }
    }

    public void stopListening(){
        locationManager.removeUpdates(locationListener);
    }

    public void listenMyLocation(LocationListener locationListener){
        //위치 권한이 없으면 null을 리턴
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        //리스너를 저장
        this.locationListener = locationListener;

        String provider = getProvider();
        if(provider==null) return;

        locationManager.requestLocationUpdates(provider,
                MIN_UPDATE_TIME,
                MIN_UPDATE_DISTANCE,
                locationListener);
    }

    public String parseDistanceToMeter(double value) {
        return parseDistanceToMeter(value, true);
    }

    public String parseDistanceToMeter(double value, boolean prime){
        String meter = "m";

        double distanceBetween = value;
        if(distanceBetween >1000) {
            distanceBetween /= 1000.0;
            meter="km";
        }

        String distance = String.valueOf(distanceBetween);

        int index = distance.indexOf(".");
        if(prime){

            if(index>0 && index+1<distance.length()){
                distance= distance.substring(0,index+2);
            }
        }else{
            if(index>=0) {
                distance = distance.substring(0, index);
            }
        }
        return distance+meter;
    }


    public boolean checkPermission(Activity activity){

        if(Build.VERSION.SDK_INT < 23) return true;

        String permission = Manifest.permission.ACCESS_FINE_LOCATION;
        int permissionCode = PERMISSION_ACCESS_FINE_LOCATION;

        if(ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED) return true;
//        if(ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {}//거절 한 이후부터.
        ActivityCompat.requestPermissions(activity, new String[]{permission}, permissionCode);
        return false;


    }

}
