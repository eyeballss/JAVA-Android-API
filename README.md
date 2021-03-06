JAVA-Android-API
===========


### 기존 Android API가 너무 더럽게 쓰여져있어서, 새롭게 API를 만듭니다.
*새로운 API는 [이곳](https://github.com/eyeballss/JAVA-Android-API/tree/master/new_Android_APIs)에 올리려고 합니다.*

안드로이드 API 2018.3.5

---

여기 아래부터는 2017년에 만든 더러운(...) API들입니다.

자바와 안드로이드 API
2017.5.2


### JAVA API

---

### - fileHelper 사용법 -
< 읽을 때 >

`ArrayList<String> list = (ArrayList<String>)FileHelper.read(파일 이름, 경로);`  
이런 식으로 파일의 이름과 경로를 적으면 읽은 값들이 String 리스트로 담겨 나옵니다.  

< 쓸 때 >

`FileHelper.write(파일 이름, 쓸 내용(String), 경로, 덮어씀 여부);`  
이런 식으로 파일의 이름과 파일에 쓸 내용, 쓸 파일의 경로, 덮어씀 여부를 결정하여 실행합니다.  
경로가 null일 경우 디폴트인 c:\가 적용되며, 덮어씀 여부가 true일 때 전체 파일을 덮어쓰고 false일 때 마지막 줄에 추가하여 씁니다.  

---

### - ThreadHelper 사용법 -


```
threadHelper.addClass(new AAA());
threadHelper.addClass(new BBB());
threadHelper.addClass(new CCC());

threadHelper.startThread();
```
Runnable을 구현한 자신의 클래스를 addClass() 메소드로 넣습니다.  
그 후 startThread() 메소드로 넣었던 모든 쓰레드들을 실행시킵니다.  
p.s. interrupt, join 등의 메소드는 미구현.  

---
---


### Android API

---

### - Log 사용법 -

`Utility.Log(String1,String2);`

String1 은 로그의 키가 들어가고
String2 는 로그의 값이 들어간다.

Log는 기본적으로 debug 로 뜬다.


### - SweetAlert 사용법 -

RootActivity를 Activity class에 상속시킨다.
gradle의 dependencies 에 

`compile 'cn.pedant.sweetalert:library:+'` 

를 추가하고 manifests의 manifest에 

`xmlns:tools="http://schemas.android.com/tools"`

를 추가하고 manifests의 application에

`tools:replace="android:icon"`를 추가한다.

progress bar를 띄울 때는 아래 메소드를 부른다.

`showPD(String);`

progress bar는 기본적으로 취소 버튼으로 사라지지 않게 설정되어 있지만
RootActivity의 

`pDialog .setCancelable(false);`

에서 false를 true로 고치면 취소 버튼으로 사라질 수 있다.
나타난 progress bar를 사라지게 하고 싶다면 아래 메소드를 부른다.

`stopPd();`

에러 메세지를 보여주고 싶다면 아래 메소드를 부른다.

`showErrorDialog(String1, String2);`

String1 은 에러 창의 제목이지만 생략 가능하고 생략시 ERROR가 설정된다.
String2 는 에러 창의 메세지이다.

*다양한 SweetAlert를 넣고싶다면 [이곳](https://github.com/pedant/sweet-alert-dialog)을 클릭*


### - isNetworkConnected 사용법 -

현재 네트워크가 연결되어 있는지 아닌지를 판별하는 메소드이다.
사용을 위해 RootActivity를 Activity class에 상속시킨다.

`isNetworkConnected()`

을 호출하여 나온 결과가 0이라면 현재 네트워크 연결이 되어 있지 않다,
결과가 1이라면  모바일 데이터를 이용하여 네트워크가 연결되어 있다,
결과가 2라면 와이파이를 이용하여 네트워크가 연결되어 있다,
라는 의미이다.


### - Preference 사용법 -

간단한 데이터를 저장하여 앱이 꺼진 후에도 날아가지 않도록 하는 메소드이다.
사용을 위해 RootActivity를 Activity class에 상속시킨다.
저장 가능한 데이터 타입은 아래와 같다.

`String, boolean, int, float, long, Set<String>`

저장을 하고 싶다면 아래와 같은 메소드를 부른다.

`savePreferences(String1, String2, data)`

String1 은 Preference가 저장할 파일의 이름이다. (어떤 이름을 써도 무관)
String2 는 Preference가 저장할 때 필요한 키 값이다.
data 는 저장하고자 하는 데이터이다.

저장된 데이터를 불러오고 싶다면 아래와 같은 메소드를 부른다.

```
String type을 부를 때 : readStringPreferences(String1, String2)
int type을 부를 때 : readIntPreferences(String1, String2)
boolean type을 부를 때 : readBooleanPreferences(String1, String2)
float type을 부를 때 : readFloatPreferences(String1, String2)
long type을 부를 때 : readLongPreferences(String1, String2)
Set<String> type을 부를 때 : readStingSetPreferences(String1, String2)
```

String1 은 Preference가 저장할 때 사용했던 파일의 이름이다. (반드시 같은 이름이어야 함)
String2 는 Preference가 저장할 때 사용했던 데이터의 키 값이다.
반환값으로 저장되었던 데이터가 나오는데, 저장이 되어있지 않다면 데이터별로 default 값이 반환된다.

```
String type의 default 반환값 : null
int type의 default 반환값 : 0
boolean type의 default 반환값 : false(저장된 false값과 차이가 없으므로 주의)
float type의 default 반환값 : 0.0f
long type의 default 반환값 : 0
Set<String> type의 default 반환값 : null

```

저장된 데이터 중 특정 데이터를 지우고 싶다면 아래 메소드를 부른다.

`removePreferences(String1, String2)`

String1 은 Preference가 저장할 때 사용했던 파일의 이름이다. (반드시 같은 이름이어야 함)
String2 는 Preference가 저장할 때 사용했던 데이터의 키 값이다.

저장된 모든 데이터를 지우고 싶다면 아래 메소드를 부른다.

`removeAllPreferences(String)`

String은 Preference가 저장할 때 사용했던 파일의 이름이다. (반드시 같은 이름이어야 함)


### - GPS 사용법 -

*[공식 문서](https://developers.google.com/maps/documentation/android-api/start?hl=ko)를 적극 참고한다.*

참고로 이곳의 API는 4.4 KitKat 상에서만 테스트 되었다.
6.0 Marshmallow 이상에서는 권한 이슈가 발생하므로 GitHub에 있는 코드를 그대로 쓸 수 없다.

MapsActivity는 직접 만들도록 하고 안의 메소드만 Github에서 가져다 쓴다. 

MapsActivity를 만들기 위해 액티비티 갤러리에서 Google Maps Activity를 선택한다.
google_maps_api.xml 내부의 주석 설명을 따라서 key를 만들고  만든 키를 google_maps_api.xml 내의 YOUR_KEY_HERE 에 넣는다.
MapsActivity에 LocationListener를 implements 한다.
구현되지 않은 4가지 메소드 ( onLocationChanged, onStatusChanged, onProviderEnabled, onProviderDisabled )는 Github에서 가져다가 쓴다.

현재 GPS가 켜져있는지 꺼져있는지 알고 싶다면 아래 메소드를 부른다.

`checkGPS()`

ture 값이 반환되면 켜져있다는 의미이고 false가 반환되면 꺼져있다는 의미이다.

`onLocationChanged` 메소드에서 위치가 업데이트 되었을 때 실행 될 코드를 넣는다.

나의 위치를 맵 상에 보이고 싶을 땐 아래 메소드를 부른다.

`setMyLocation(Boolean)`

호출 시 true를 넣으면 나의 위치가 맵 상에 보이고 false를 넣으면 안 보인다.

해당 위치로 맵을 이동시키고 싶다면 아래 메소드를 부른다.

`moveCamera(LatLng, Int)`
`moveCamera(Location, Int)`

호출 시 LatLng 위치로 맵이 이동한다. 두번째 파라미터인 Int는 확대하는 정도이며 생략이 가능하다. 이 때 default로 15가 들어간다.

맵을 클릭하거나 길게 클릭했을 때 이벤트를 달고 싶다면 onMapReady 메소드 내부에서
mMap에 

`setOnMapClickListener` 

혹은

 `setOnMapLongClickListener` 

리스너를 달면 된다.

해당 위치의 주소 값을 알고 싶다면 아래 메소드를 부른다.

`getAddress(LatLng)`
`getAddress(Location)`

한국을 기준으로 해당 위치의 주소값, 위도, 경도, 국가 번호, postal Code 등이 String으로 반환 된다.

Location A와 Location B의 사이 거리를 구하고 싶다면 아래 메소드를 부른다.

`getDistanceBetween(Location1, Location2)`

Location1 과 Location2 사이의 직선 거리가 float 타입 meter 단위로 반환된다.


### - Vibrator 사용법 -

AndroidManifest.xml 의 manifrst에 

`<uses-permission android:name="android.permission.VIBRATE"/>`

을 추가한다.

n초간 진동을 주기 위해 아래 메소드를 부른다.

`startVibration(int)`

int에 진동 시간(초)을 넣는다.

패턴이 있는 진동을 주기 위해 아래 메소드를 부른다.

`startPatternVibration(int1, int2, int3)`

int1은 대기 시간(초)을, int2는 진동 시간(초)을 나타낸다.
int3은 무한하게 반복할지를 결정한다. 0을 넣으면 무한하게 반복하고 음의 정수를 넣으면 한 번만 반복한다. 
양의 정수를 넣으면 패턴의 해당 인덱스부터 무한히 반복한다.
기본적으로 3번 반복하지만, 더 반복하고 싶다면 메소드 내에 patten 배열 뒤에 값을 더 추가하면 된다.

모든 진동을 멈추고 싶다면 아래 메소드를 부른다.

`stopVibration()`
