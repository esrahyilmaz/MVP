package Utility;

import seleniumhelper.BaseClass;

import java.io.File;

public class DeleteFile extends BaseClass{
	
	public static void delete()
    {
        File file = new File(ReportpathLocal);
       
        if(file.delete())
        {
            System.out.println("File deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file");
        }
    }
	
	public static void delete(String path)
    {
        File file = new File(path);
       
        if(file.delete())
        {
            System.out.println("File deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file");
        }
    }

}
