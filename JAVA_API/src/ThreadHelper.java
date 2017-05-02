import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

class ThreadHelper{

	private ArrayList<Runnable> threadList;
	
	public ThreadHelper(){
		threadList = new ArrayList<Runnable>();
	}
	
	public void addClass(Runnable o){
		threadList.add(o);
	}
	
	public void startThread(){
		Thread t;
		for(Runnable o : threadList){
			t = new Thread(o);
			t.start();
		}
	}
	
	static public void explain(){
		System.out.println(
				"- ThreadHelper 사용법 -\n"
				+"Runnable을 구현한 자신의 클래스를 addClass() 메소드로 넣습니다.\n"
				+ "그 후 startThread() 메소드로 넣었던 모든 쓰레드들을 실행시킵니다.\n"
				+ "p.s. interrupt, join 등의 메소드는 미구현\n");
		
	}
}

//getMethod는 해당 클래스의 사용자 관점(client’s view)에서 public 메소드만 가져오지만, getDeclaredMethod는 클래스에 선언한 (private을 포함한)모든 메소드를 반환