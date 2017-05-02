import java.util.ArrayList;
import java.util.List;

public class MainForTest {

	public static void main(String[] args) {

	}
	
	
	private static void fileHelperClassTest(){
		FileHelper.explain();
		
		ArrayList<String> list = (ArrayList<String>)FileHelper.read("README.md", "/home/eye/문서/androidgit/JAVA-Android-API");
		for(String s : list){
			System.out.println(s);
		}
		
		FileHelper.write("README.md", "test", "/home/eye/문서/androidgit/JAVA-Android-API", false);
	}
	
	
	

	
	private static void threadHelperClassTest(){
		//threadHelper 클래스를 텍스트 합니다.
		ThreadHelper.explain();
		
		ThreadHelper threadHelper = new ThreadHelper();
		
		class AAA implements Runnable{
			public void run(){
				System.out.println("A run");
			}
		}
		class BBB implements Runnable{
			public void run(){
				System.out.println("B run");
			}
			
		}
		class CCC implements Runnable{
			public void run(){
				System.out.println("C run");
			}
		}
		
		threadHelper.addClass(new AAA());
		threadHelper.addClass(new BBB());
		threadHelper.addClass(new CCC());

		threadHelper.startThread();
	}
}