import javax.swing.*; //�ޥ�Swing�M��

import java.awt.*;
import java.awt.event.*; //�ޥγB�z�ƥ�event�M��
import java.net.*;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;



public class server extends JFrame{
	public static int port = 5572; // �s����
	JTextField  tf = new JTextField ("��J�A�n����r......");
	int flag=0;
	JButton jbred = new JButton("��");
	JButton jbgreen = new JButton("��");
	JButton jbblue = new JButton("��");
	Container cp = getContentPane(); //���o���e����
	JPanel jp1=new JPanel();
	JPanel jp2=new JPanel();
	FieldCaretListener fcl =  new FieldCaretListener();
	class FieldCaretListener implements CaretListener {
		public void caretUpdate(CaretEvent e){ //�^���ƥ󪺤�k
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
	}; //�Ъ`�N����������
	ActionListener algreen = new ActionListener() {
		public void actionPerformed(ActionEvent e){
			tf.setForeground(Color.GREEN);
		}	
	}; //�Ъ`�N����������
	ActionListener alblue = new ActionListener() {
		public void actionPerformed(ActionEvent e){
			tf.setForeground(Color.BLUE);
		}	
	}; //�Ъ`�N����������
	server(){
		jbred.setForeground(Color.RED);
		jbgreen.setForeground(Color.GREEN);
		jbblue.setForeground(Color.BLUE);
		tf.setForeground(new Color(255, 0,255));
		jp2.setLayout(new GridLayout(1, 1, 10, 10)); //���o�G���޲z��
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
		//�]�w���������N�w�]�����{��
		pack(); //�]�w�H�A��j�p���
		setVisible(true); //��ܵ����ج[
		tf.addCaretListener(fcl);
	}

	
		
	public static void main(String args[]) throws Exception {
		new server(); //�ŧi�����ج[����
	/*	ServerSocket ss = new ServerSocket(port); // �إ� TCP ���A���C
		String str1;
		JTextField tfName = new JTextField("�п�J�^��Ʀr�G ");
		
		while (true) { // ���_�������B�z��J�T���C
			Socket sc = ss.accept(); // ������J�T���C
			OutputStream os = sc.getOutputStream(); // ���o��X��y�C
			os.write("gG".getBytes("UTF-8"));// �e�T���� Client
														// �ݡC
			os.close(); // ������X��y�C
			sc.close(); // ���� TCP ���A���C
		}*/
		
	}
}