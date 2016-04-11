import javax.swing.*;  //引用套件

import java.awt.*;
import java.awt.event.*; //引用處理事件的event套件

public class hw2 extends JFrame {
static int count =0;   
	hw2() {
		Container cp = getContentPane(); //取得內容面版
		cp.setLayout(new BorderLayout(5, 5));//建立各區域水平、垂直間距為10的BorderLayout物件
		JPanel jpan = new JPanel();
		JButton []clickA = new JButton[4];
		clickA[0] = new JButton("3");clickA[1] = new JButton("6");clickA[2] = new JButton("9"); clickA[3] = new JButton("12"); //建立元件
		JButton clickright = new JButton("順時針！！");JButton clickleft = new JButton("逆時針！！"); //建立元件
		
		//將各按鈕控制項，加入版面的指定位置
		clickA[0].setPreferredSize(new Dimension(0,50)); //零代表不能更改大小
		clickA[1].setPreferredSize(new Dimension(50,0));
		clickA[2].setPreferredSize(new Dimension(0,50));
		clickA[3].setPreferredSize(new Dimension(50,0));
		clickright.setPreferredSize(new Dimension(100,100)); //設定按鈕大小
		clickleft.setPreferredSize(new Dimension(100,100)); //設定按鈕大小
		cp.add(clickA[0], BorderLayout.NORTH);		
		cp.add(clickA[1], BorderLayout.EAST);
		cp.add(clickA[2], BorderLayout.SOUTH);
		cp.add(clickA[3], BorderLayout.WEST);
		jpan.add(clickright); //元件加入容器
		jpan.add(clickleft);
		cp.add(jpan);     //容器加入面板
		
		class cright implements ActionListener {
			public void actionPerformed(ActionEvent e){
				String []tmp=new String[4];
				for(int i=0;i<4;i++)
					tmp[i]=clickA[i].getText();
				for(int i=0;i<4;i++)
					clickA[i].setText(tmp[(i+3)%4]);//調換位置
			}	
			
		}
		
		class cleft implements ActionListener {
			public void actionPerformed(ActionEvent e){
				String []tmp=new String[4];
				for(int i=0;i<4;i++)
					tmp[i]=clickA[i].getText();
				for(int i=0;i<4;i++)
					clickA[i].setText(tmp[(i+1)%4]);//調換位置
			}	
			
		}
		cright cr = new cright(); //宣告監聽器類別物件
		clickright.addActionListener(cr);
		cleft cl = new cleft(); //宣告監聽器類別物件
		clickleft.addActionListener(cl);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public static void main(String args[]) {
		new hw2();
	}
}