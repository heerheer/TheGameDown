package com.running.download;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

public class ShawDown {
	private static String fa = "";
	String fileName = null;
	URL url = null;
	InputStream inputStream = null;
	static File file = null;
	DataOutputStream dos = null;
	URLConnection con = null;
	public static void dl(String[] args) throws IOException{
		ShawDown shawDown = new ShawDown();
		shawDown.setFileName(fa);
		shawDown.connection();
		shawDown.creatFile();
		shawDown.writeResult();
	}
    //连接
    public void connection() {
        try {
            url = new URL(fa);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            con = url.openConnection();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //创建本地文件
    public void creatFile() {
        file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    //将从网络获取的文件的InputStream并写入到本地
    private void writeResult() throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file, true);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BufferedOutputStream bos = new BufferedOutputStream(fos);
//      BufferedOutputStream bos = new BufferedOutputStream(fos, 300 * 1024);
        dos = new DataOutputStream(bos);
        try {
            // is = con.getOutputStream();
            inputStream = con.getInputStream();
            // System.out.println(inputStream.hashCode());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BufferedInputStream bis = new BufferedInputStream(inputStream);
//      BufferedInputStream bis = new BufferedInputStream(inputStream,300 * 1024);
        DataInputStream dis = new DataInputStream(bis);
        try {
            while (true) {
                dos.write(dis.readByte());
            }
        } catch (EOFException e) {
        	JOptionPane.showMessageDialog(null, "文件下载成功，请查看"+fa);
        	System.exit(0);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            dos.close();
            bis.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void setFileName(String sourceUrl) {
        fileName = sourceUrl.substring(sourceUrl.lastIndexOf("/") + 1,sourceUrl.length()).trim();
    }
//  public String getFileName() {
//      return fileName;
//  }
}
