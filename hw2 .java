import javax.swing.*;  //�ޥήM��

import java.awt.*;
import java.awt.event.*; //�ޥγB�z�ƥ�event�M��

public class hw2 extends JFrame {
static int count =0;   
	hw2() {
		Container cp = getContentPane(); //���o���e����
		cp.setLayout(new BorderLayout(5, 5));//�إߦU�ϰ�����B�������Z��10��BorderLayout����
		JPanel jpan = new JPanel();
		JButton []clickA = new JButton[4];
		clickA[0] = new JButton("3");clickA[1] = new JButton("6");clickA[2] = new JButton("9"); clickA[3] = new JButton("12"); //�إߤ���
		JButton clickright = new JButton("���ɰw�I�I");JButton clickleft = new JButton("�f�ɰw�I�I"); //�إߤ���
		
		//�N�U���s����A�[�J���������w��m
		clickA[0].setPreferredSize(new Dimension(0,50)); //�s�N������j�p
		clickA[1].setPreferredSize(new Dimension(50,0));
		clickA[2].setPreferredSize(new Dimension(0,50));
		clickA[3].setPreferredSize(new Dimension(50,0));
		clickright.setPreferredSize(new Dimension(100,100)); //�]�w���s�j�p
		clickleft.setPreferredSize(new Dimension(100,100)); //�]�w���s�j�p
		cp.add(clickA[0], BorderLayout.NORTH);		
		cp.add(clickA[1], BorderLayout.EAST);
		cp.add(clickA[2], BorderLayout.SOUTH);
		cp.add(clickA[3], BorderLayout.WEST);
		jpan.add(clickright); //����[�J�e��
		jpan.add(clickleft);
		cp.add(jpan);     //�e���[�J���O
		
		class cright implements ActionListener {
			public void actionPerformed(ActionEvent e){
				String []tmp=new String[4];
				for(int i=0;i<4;i++)
					tmp[i]=clickA[i].getText();
				for(int i=0;i<4;i++)
					clickA[i].setText(tmp[(i+3)%4]);//�մ���m
			}	
			
		}
		
		class cleft implements ActionListener {
			public void actionPerformed(ActionEvent e){
				String []tmp=new String[4];
				for(int i=0;i<4;i++)
					tmp[i]=clickA[i].getText();
				for(int i=0;i<4;i++)
					clickA[i].setText(tmp[(i+1)%4]);//�մ���m
			}	
			
		}
		cright cr = new cright(); //�ŧi��ť�����O����
		clickright.addActionListener(cr);
		cleft cl = new cleft(); //�ŧi��ť�����O����
		clickleft.addActionListener(cl);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public static void main(String args[]) {
		new hw2();
	}
}