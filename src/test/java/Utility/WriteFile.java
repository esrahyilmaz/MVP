package Utility;

import java.io.*;
 
public class WriteFile {
 
    
         public void write(String strContent,String path) {
        BufferedWriter bufferedWriter = null;
        try {
        
            //String strContent = "This example shows how to write string content to a file";
            File myFile = new File(path);
            // check if file exist, otherwise create the file before writing
            if (!myFile.exists()) {
                myFile.createNewFile();
            }
            Writer writer = new FileWriter(myFile);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(strContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(bufferedWriter != null) bufferedWriter.close();
            } catch(Exception ex){
                 
            }
        }
         }
        public static void main(String[] args) {    
}
}
