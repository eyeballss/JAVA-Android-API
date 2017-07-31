JAVA-Android-API
===========
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
`pDialog .setCancelable(false);`에서 false를 true로 고치면 취소 버튼으로 사라질 수 있다.
나타난 progress bar를 사라지게 하고 싶다면 아래 메소드를 부른다.
`stopPd();`
에러 메세지를 보여주고 싶다면 아래 메소드를 부른다.
`showErrorDialog(String1, String2);`
String1 은 에러 창의 제목이지만 생략 가능하고 생략시 ERROR가 설정된다.
String2 는 에러 창의 메세지이다.

* 다양한 SweetAlert를 넣고싶다면 [이곳](https://github.com/pedant/sweet-alert-dialog)을 클릭 *
