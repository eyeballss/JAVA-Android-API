package me.blog.eyeballss.android_api.Utils;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by david on 18. 3. 15.
 */

public class MyFileManager {
    private static MyFileManager myFileManager = new MyFileManager();

    public static MyFileManager getInstance(){
        return myFileManager;
    }

    private MyFileManager(){}

    public String save(Context context, String fileName, String data) {
        String path = context.getFilesDir()+"/"+fileName;
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path)));
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();

            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String read(Context context, String fileName) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(context.getFilesDir()+"/"+fileName)));
            Log.d("!!!!", context.getFilesDir()+"/"+fileName);
            String read ;
            StringBuilder builder = new StringBuilder();

            while((read = bufferedReader.readLine()) != null){
                builder.append(read);
            }

            bufferedReader.close();
            return builder.toString();

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //파일 지우는 것도 넣자.
}
