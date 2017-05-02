import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FileHelper {
	   
    static public List read(String fileName, String path){
       if(path==null) {
    	   path = "";
       }

         //읽은 값들을 ArrayList에 저장할 꺼임.
        //StringBuffer 에 append해서 넣어도 되고 Strng에 +로 넣어도 되고 마음대로 조작하자.
        ArrayList<String> result = new ArrayList<String>();
        String contents;
       
        try{
            BufferedReader in = new BufferedReader(new FileReader(path+"//"+fileName));
           
            while((contents=in.readLine())!=null){
                //ArrayList에 넣음.
                result.add(contents);
            }
           
            in.close();
        }catch(IOException e){
            printException(e);
        } catch(Exception e){
            printException(e);
        }
       
        return result;
    }
 
    //overwrite가 true이면 덮어씁니다.
    static public void write(String fileName, String contents, String path, boolean overwrite){
    	if(path==null) {
    		path = "c://";
    	}
        try{
            //경로는 원하는대로.
            BufferedWriter out = new BufferedWriter(new FileWriter(path+"//"+fileName, !overwrite));
 
            //원하는 만큼.
            out.write(contents);
            out.newLine();
           
            //버퍼에 있는 내용을 쏟아냄
            out.flush();
            out.close();
        }catch(IOException e){
            printException(e);
        }catch(Exception e){
            printException(e);
        }
    }
   
    private static void printException(Exception e) {
        e.printStackTrace();
        System.exit(1);
    }
    
    static public void explain(){
    	System.out.println(
				"- fileHelper 사용법 -\n"
				+ "< 읽을 때 >\n"
				+ "ArrayList<String> list = (ArrayList<String>)FileHelper.read(파일 이름, 경로);\n"
				+ "이런 식으로 파일의 이름과 경로를 적으면 읽은 값들이 String 리스트로 담겨 나옵니다\n."
				+ "< 쓸 때 >\n"
				+ "FileHelper.write(파일 이름, 쓸 내용(String), 경로, 덮어씀 여부);\n"
				+ "이런 식으로 파일의 이름과 파일에 쓸 내용, 쓸 파일의 경로, 덮어씀 여부를 결정하여 실행합니다.\n"
				+ "경로가 null일 경우 디폴트인 c:\\가 적용되며, 덮어씀 여부가 true일 때 전체 파일을 덮어쓰고 false일 때 마지막 줄에 추가하여 씁니다.\n");
    }
}