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
