package Utility;

import java.io.File;
import java.io.FileInputStream;

public class ReadFile 
{	
	public String read(String path)
	{
		File file=new File(path);
		FileInputStream fis=null;
		String str="";
		try {
			fis=new FileInputStream(file);
			int content;
			while((content=fis.read())!=-1)
			{
				str +=(char)content;
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null)
					fis.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return str;
	}
public static void main(String[] args)
{
	ReadFile r=new ReadFile();
	String a=r.read("c:\\temp\\Email_3583872_body.txt");
	System.out.println(a);
}
}
