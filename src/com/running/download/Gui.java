package com.running.download;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Gui{
	static Button b1 = new Button("��ʼ����");
	static Button b2 = new Button("�˳�");
	public static void ui(String[] args){
		JFrame w = new JFrame("��Ϸ������");
		w.setResizable(false);
		w.setLocation(200, 200);
		w.setSize(450,150);
		//ʵ��436*113
		w.setVisible(true);
		w.setLayout(null);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.setBounds((436-387)/2,85,70,30);
		b2.setBounds((436-94),85,70,30);
		w.add(b1);
		w.add(b2);
		b1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "�������أ�û�н����������Ժ򣬲�Ҫ�ر������ڣ������޷�����");
			try {
				ShawDown.dl(args);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}});
		b2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {System.exit(0);}});
	}
}