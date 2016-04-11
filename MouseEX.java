import javax.swing.*; //引用Swing套件

import java.awt.*;
import java.awt.event.*; //引用處理事件的event套件

public class MouseEX extends JFrame {
	Container cp = getContentPane(); //取得內容面版
	JPanel jpan = new JPanel();
	JButton clickME = new JButton("連點兩下"); //建立元件
	private int  temp=0;
	//以匿名類別的方式實作MouseListener介面, 
	//宣告回應滑鼠事件的監聽器
	MouseListener mlBtn = new MouseListener() {
		private int clickCount = 0; //記錄按鈕被按下次數的屬性
		//處理按一下滑鼠按鍵動作的方法
		@SuppressWarnings("deprecation")
		public void mouseClicked(MouseEvent e) {
			clickCount=clickCount+1;
			System.out.print(clickCount);
			if(e.getClickCount() == 2 && temp==0){
				((JButton) e.getSource()).setText("點三下");
				clickCount=0;
				temp=1;
			}
			if(clickCount == 3 && temp==1){
				((JButton) e.getSource()).setText("點D鍵");
				temp=2;
			}
			if(e.getClickCount() == 1 && temp==4){
				((JButton) e.getSource()).setText("右鍵");
				temp=5;
			}
			if(e.getClickCount() == 2 && temp==6){
				setExtendedState(1);
				((JButton) e.getSource()).setText("移動近來");
				temp=7;
			}
			
		}

		//處理滑鼠游標進入元件的方法
		public void mouseEntered(MouseEvent e) {}

		//處理滑鼠游標離開元件的方法
		public void mouseExited(MouseEvent e) {}

		//處理按下滑鼠按鍵動作的方法
		public void mousePressed(MouseEvent e){
			if(e.getButton()==3 && temp==5){
				((JButton) e.getSource()).setText("點兩下隱藏視窗");
				temp=6;
			}
		}

		//處理放開滑鼠按鍵動作的方法
		//即使不處理事件但仍須定義空的回應方法
		public void mouseReleased(MouseEvent e){ }
	};
	
	KeyListener klButton = new KeyListener() {

		//處理鍵盤按鍵被按下的方法
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==17 && temp==3){ 
				temp=4;
			}
		}

		//處理鍵盤按鍵被放開的方法
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()==17 && temp==4){  
				temp=3;
			}
		}

		//處理由鍵盤輸入字元的方法
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar()=='D' && temp==2){
				((JButton) e.getSource()).setText("ctrl+點");
				temp=3;
			}
		}
	};
	
	//以匿名類別的方式實作MouseMotionListener介面, 
	//宣告回應滑鼠事件的監聽器
	WindowListener wlFrame = new WindowListener(){

		//回應視窗進入有效狀態(取得焦點)的方法
		public void windowActivated(WindowEvent e){	}
		//回應視窗關閉行為的方法
		public void windowClosed(WindowEvent e){}
		//回應視窗正在關閉中的方法
		public void windowClosing(WindowEvent e){}
		//回應視窗失去焦點的方法
		public void windowDeactivated(WindowEvent e){}
		//回應視窗從圖示化還原的方法
		public void windowDeiconified(	WindowEvent e){}
		//回應視窗圖示化的方法
		public void windowIconified(WindowEvent e){
			if(temp==7){
				
				//clickME.setText("移動近來"); //未做按鍵縮小
				temp=8;
				System.out.print("GG");
			}
			
		}
		//回應開啟視窗的方法
		public void windowOpened(WindowEvent e){}
	};
	MouseMotionListener mmlFrame = new MouseMotionListener(){
		public void mouseDragged(MouseEvent e){}//滑鼠拖曳

		public void mouseMoved(MouseEvent e){ //滑鼠移動
			if(temp==8){
				((JButton) e.getSource()).setText("請移到5,5 , 游標位置在 ( "
						+ e.getX()  + ", " + e.getY() + " )");
				if(e.getX()==5&&e.getY()==5){
					((JButton) e.getSource()).setText("你終於獲勝了zz");
					temp=9;
				}
			}
			
		}
	};

	MouseEX(){
		Box bxBtn = new Box(BoxLayout.X_AXIS);
		bxBtn.add(Box.createHorizontalGlue());
		bxBtn.add(clickME); //加入按鈕元件
		bxBtn.add(Box.createHorizontalGlue());
		cp.add(bxBtn); //將包含按鈕元件的Box容器加入內容面版

		clickME.addMouseListener(mlBtn);//註冊由mlBtn監聽clickME元件的滑鼠事件
		clickME.addKeyListener(klButton);
		addWindowListener(wlFrame);
		clickME.addMouseMotionListener(mmlFrame);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 250);
		setVisible(true);
	}

	public static void main(String args[]) {
		new MouseEX(); //產生視窗框架物件
	}
}