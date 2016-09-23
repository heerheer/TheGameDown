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
	static String fa = "http://192.168.31.219/minecraft/Minecraft1.10.2.7z";
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
    //����
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
    //���������ļ�
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
    //���������ȡ���ļ���InputStream��д�뵽����
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
        	JOptionPane.showMessageDialog(null, "���سɹ�����ѹ��Ϸ����ʼ�����Ϸ֮�ð�");
        	JOptionPane.showMessageDialog(null, "ѹ���ļ�������ĵ�ǰĿ¼���ļ����ֽ�\"Minecraft1.10.2.7z\"");
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