import javax.swing.*; //引用Swing套件

import java.awt.*;
import java.awt.event.*; //引用處理事件的event套件
import java.net.*;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;



public class server extends JFrame{
	public static int port = 5572; // 連接埠
	JTextField  tf = new JTextField ("輸入你要的文字......");
	int flag=0;
	JButton jbred = new JButton("紅");
	JButton jbgreen = new JButton("綠");
	JButton jbblue = new JButton("藍");
	Container cp = getContentPane(); //取得內容面版
	JPanel jp1=new JPanel();
	JPanel jp2=new JPanel();
	FieldCaretListener fcl =  new FieldCaretListener();
	class FieldCaretListener implements CaretListener {
		public void caretUpdate(CaretEvent e){ //回應事件的方法
			if( e.getDot() >= 0 &&flag==0){
				tf.setText(null);
				flag=1;
			}
		}
	}
	
	ActionListener alred = new ActionListener() {
		public void actionPerformed(ActionEvent e){
			tf.setForeground(Color.RED);
		}	
	}; //請注意結尾的分號
	ActionListener algreen = new ActionListener() {
		public void actionPerformed(ActionEvent e){
			tf.setForeground(Color.GREEN);
		}	
	}; //請注意結尾的分號
	ActionListener alblue = new ActionListener() {
		public void actionPerformed(ActionEvent e){
			tf.setForeground(Color.BLUE);
		}	
	}; //請注意結尾的分號
	server(){
		jbred.setForeground(Color.RED);
		jbgreen.setForeground(Color.GREEN);
		jbblue.setForeground(Color.BLUE);
		tf.setForeground(new Color(255, 0,255));
		jp2.setLayout(new GridLayout(1, 1, 10, 10)); //取得佈局管理員
		jp1.add(jbred);
		jp1.add(jbgreen);
		jp1.add(jbblue);
		cp.add(jp1, BorderLayout.NORTH); 
		jp2.add(tf);
		cp.add(jp2);
		jbred.addActionListener(alred);
		jbgreen.addActionListener(algreen);
		jbblue.addActionListener(alblue);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//設定關閉視窗將預設結束程式
		pack(); //設定以適當大小顯示
		setVisible(true); //顯示視窗框架
		tf.addCaretListener(fcl);
	}

	
		
	public static void main(String args[]) throws Exception {
		new server(); //宣告視窗框架物件
	/*	ServerSocket ss = new ServerSocket(port); // 建立 TCP 伺服器。
		String str1;
		JTextField tfName = new JTextField("請輸入英文數字： ");
		
		while (true) { // 不斷的接收處理輸入訊息。
			Socket sc = ss.accept(); // 接收輸入訊息。
			OutputStream os = sc.getOutputStream(); // 取得輸出串流。
			os.write("gG".getBytes("UTF-8"));// 送訊息到 Client
														// 端。
			os.close(); // 關閉輸出串流。
			sc.close(); // 關閉 TCP 伺服器。
		}*/
		
	}
}