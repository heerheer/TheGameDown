package com.running.download;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.running.download.ShawDown;
public class main {
	private String dl0,dl1,dl2,dl3,dl4,dl5,dl6,dl7,dl8,dl9;
	public static void main(String[] args) throws IOException{
		String path = "./bin/dofile.ini";
		File file=new File(path);    
		if(!file.exists())    
		{    
		    try {    
		        file.createNewFile();    
		    } catch (IOException e) {    
		        e.printStackTrace();    
		    }    
		}
		Properties pp = new Properties();
	    FileInputStream fis = new FileInputStream(path);
		pp.load(fis);
		main Download = new main();
		Download.dl0 = pp.get("dl0").toString();
		Download.dl1 = pp.get("dl1").toString();
		Download.dl2 = pp.get("dl2").toString();
		Download.dl3 = pp.get("dl3").toString();
		Download.dl4 = pp.get("dl4").toString();
		Download.dl5 = pp.get("dl5").toString();
		Download.dl6 = pp.get("dl6").toString();
		Download.dl7 = pp.get("dl7").toString();
		Download.dl8 = pp.get("dl8").toString();
		Download.dl9 = pp.get("dl9").toString();
		Gui.ui(args);
	}
}
