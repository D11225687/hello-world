import javax.swing.*; //�ޥ�Swing�M��

import java.awt.*;
import java.awt.event.*; //�ޥγB�z�ƥ�event�M��

public class MouseEX extends JFrame {
	Container cp = getContentPane(); //���o���e����
	JPanel jpan = new JPanel();
	JButton clickME = new JButton("�s�I��U"); //�إߤ���
	private int  temp=0;
	//�H�ΦW���O���覡��@MouseListener����, 
	//�ŧi�^���ƹ��ƥ󪺺�ť��
	MouseListener mlBtn = new MouseListener() {
		private int clickCount = 0; //�O�����s�Q���U���ƪ��ݩ�
		//�B�z���@�U�ƹ�����ʧ@����k
		@SuppressWarnings("deprecation")
		public void mouseClicked(MouseEvent e) {
			clickCount=clickCount+1;
			System.out.print(clickCount);
			if(e.getClickCount() == 2 && temp==0){
				((JButton) e.getSource()).setText("�I�T�U");
				clickCount=0;
				temp=1;
			}
			if(clickCount == 3 && temp==1){
				((JButton) e.getSource()).setText("�ID��");
				temp=2;
			}
			if(e.getClickCount() == 1 && temp==4){
				((JButton) e.getSource()).setText("�k��");
				temp=5;
			}
			if(e.getClickCount() == 2 && temp==6){
				setExtendedState(1);
				((JButton) e.getSource()).setText("���ʪ��");
				temp=7;
			}
			
		}

		//�B�z�ƹ���жi�J���󪺤�k
		public void mouseEntered(MouseEvent e) {}

		//�B�z�ƹ�������}���󪺤�k
		public void mouseExited(MouseEvent e) {}

		//�B�z���U�ƹ�����ʧ@����k
		public void mousePressed(MouseEvent e){
			if(e.getButton()==3 && temp==5){
				((JButton) e.getSource()).setText("�I��U���õ���");
				temp=6;
			}
		}

		//�B�z��}�ƹ�����ʧ@����k
		//�Y�Ϥ��B�z�ƥ�������w�q�Ū��^����k
		public void mouseReleased(MouseEvent e){ }
	};
	
	KeyListener klButton = new KeyListener() {

		//�B�z��L����Q���U����k
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==17 && temp==3){ 
				temp=4;
			}
		}

		//�B�z��L����Q��}����k
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()==17 && temp==4){  
				temp=3;
			}
		}

		//�B�z����L��J�r������k
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar()=='D' && temp==2){
				((JButton) e.getSource()).setText("ctrl+�I");
				temp=3;
			}
		}
	};
	
	//�H�ΦW���O���覡��@MouseMotionListener����, 
	//�ŧi�^���ƹ��ƥ󪺺�ť��
	WindowListener wlFrame = new WindowListener(){

		//�^�������i�J���Ī��A(���o�J�I)����k
		public void windowActivated(WindowEvent e){	}
		//�^�����������欰����k
		public void windowClosed(WindowEvent e){}
		//�^���������b����������k
		public void windowClosing(WindowEvent e){}
		//�^���������h�J�I����k
		public void windowDeactivated(WindowEvent e){}
		//�^�������q�ϥܤ��٭쪺��k
		public void windowDeiconified(	WindowEvent e){}
		//�^�������ϥܤƪ���k
		public void windowIconified(WindowEvent e){
			if(temp==7){
				
				//clickME.setText("���ʪ��"); //���������Y�p
				temp=8;
				System.out.print("GG");
			}
			
		}
		//�^���}�ҵ�������k
		public void windowOpened(WindowEvent e){}
	};
	MouseMotionListener mmlFrame = new MouseMotionListener(){
		public void mouseDragged(MouseEvent e){}//�ƹ��즲

		public void mouseMoved(MouseEvent e){ //�ƹ�����
			if(temp==8){
				((JButton) e.getSource()).setText("�в���5,5 , ��Ц�m�b ( "
						+ e.getX()  + ", " + e.getY() + " )");
				if(e.getX()==5&&e.getY()==5){
					((JButton) e.getSource()).setText("�A�ש���ӤFzz");
					temp=9;
				}
			}
			
		}
	};

	MouseEX(){
		Box bxBtn = new Box(BoxLayout.X_AXIS);
		bxBtn.add(Box.createHorizontalGlue());
		bxBtn.add(clickME); //�[�J���s����
		bxBtn.add(Box.createHorizontalGlue());
		cp.add(bxBtn); //�N�]�t���s����Box�e���[�J���e����

		clickME.addMouseListener(mlBtn);//���U��mlBtn��ťclickME���󪺷ƹ��ƥ�
		clickME.addKeyListener(klButton);
		addWindowListener(wlFrame);
		clickME.addMouseMotionListener(mmlFrame);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 250);
		setVisible(true);
	}

	public static void main(String args[]) {
		new MouseEX(); //���͵����ج[����
	}
}