package com.running.download;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.math.BigInteger;  
import java.nio.MappedByteBuffer;  
import java.nio.channels.FileChannel;  
import java.security.MessageDigest;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.*;   
import org.apache.commons.io.IOUtils;  
  
public class d{
	private static String fa = "";//Source File
     public static String getMd5ByFile(File file) throws FileNotFoundException {
            String value = null;  
            FileInputStream in = new FileInputStream(fa);  
        try {  
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());  
            MessageDigest md5 = MessageDigest.getInstance("SHA-256");  
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());  
            value = bi.toString(16);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
                if(null != in) {  
                    try {  
                    in.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return value;  
        }  
    public static void main(String[] args) throws IOException {
    	String path =fa;
        String v = getMd5ByFile(new File(path));  
        System.out.println(v.toUpperCase());  
        FileInputStream fis= new FileInputStream(path);
        String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(fis));    
        IOUtils.closeQuietly(fis);    
        String md = "";//Source File MD5
        if(v.toUpperCase() == md){
        	JOptionPane.showMessageDialog(null, "下载成功，解压游戏，开始你的游戏之旅吧");//Download Success
        	System.exit(0);
        }
        else{
        	File f = new File("");//Source File
        	f.delete();
        JOptionPane.showMessageDialog(null, "下载失败，请重试");//Download Fail
        System.exit(0);
        }
    }  
}
