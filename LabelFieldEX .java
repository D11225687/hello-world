import javax.swing.*;  //�ޥήM��
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.text.MaskFormatter;

public class LabelFieldEX extends JFrame{
	int flag=0;
	JLabel lbAccount = new JLabel("�b��(N) : ", JLabel.RIGHT);	
	JLabel lbPassWord = new JLabel("�K�X(P) : ", JLabel.RIGHT);	
	JFormattedTextField tfAccount = new JFormattedTextField();
	JPasswordField pfPassWord = new JPasswordField(20);
	JLabel lbEnter = new JLabel("�п�J�q�l�l��a�}�I");
	
	//�H�ΦW�������O���覡�w�q�ëŧi��ť������
	ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Verifier ssd = new Verifier(new String(pfPassWord.getPassword()));
			lbEnter.setText("�K�X"+ssd.passwordok()+"�A���K�X�O�G"+ new String(pfPassWord.getPassword()));//�o�̭n�P�_�K�X
		}
	};
	
	class BtnFocusListener implements FocusListener {
		private String btnName;
		public BtnFocusListener(String name){ //�غc�l
			btnName = name;
		}
		public void focusGained(FocusEvent e){} //�B�z���o�J�I����k	
		public void focusLost(FocusEvent e){ //�B�z���h�J�I����k
			if(flag==0){
				RegexFormatter kk = new RegexFormatter(tfAccount.getText());
				lbEnter.setText(btnName+kk.accountok());//�o�̭n�P�_���S��@�M.
				flag=1;
			}
			else if (flag==1){
				flag=0;
			}
		}
	};
	
	class RegexFormatter  { //�b������
		int tposition,pposition;//t @��m .��m
		String text;
		public  RegexFormatter(String outtext){
			text=outtext;
			tposition=text.indexOf('@', 0);
			pposition=text.indexOf('.', 0);
		}
		public String accountok(){
			
			if (text.length()==0) {
				return "�п�J�q�l�l��a�}�I";
			} 
			else if (tposition==-1 || pposition==-1 ) {
				return "���~�G�����]�t�u@�M.�v�C";
			} 
			else if (tposition==0 || pposition==0) {
				return "���~�G�u@��.�v���e���i���Ŧr��C";
			} 
			else if (tposition==text.length()-1 || pposition==text.length()-1) {
				return "���~�G�u@��.�v���ᤣ�i���Ŧr��C";
			} 
			else if (tposition>pposition) {
				return "��J���~";
			}
			else
				return "���ߵo�]";
		}
	};
	
	class Verifier  { //�b������
		char pw[];
		String text;
		int flag0=0,flag1=0,flag2=0,flag3=0; //�O�_���F������
		public  Verifier(String outtext){
			text=outtext;
			pw=text.toCharArray();
		}
		public String passwordok(){
			for (int i=0;i<pw.length;i++){
				if (pw[i]>=65 && pw[i]<=90 ) {
					flag0=1;
				}
				else if (pw[i]>=97 && pw[i]<=122) {
					flag1=1;
				} 
				else if (pw[i]>=48 && pw[i]<=57 ) {
					flag2=1;
				}
				else if (pw[i]==64 || pw[i]==35 || pw[i]==36 || pw[i]==37 || pw[i]==38 || pw[i]==94 || pw[i]==42 || pw[i]==40 || pw[i]==41 || pw[i]==95 ) {
					flag3=1;
				}
			}
			if (text.length()==0) {
				return "�п�J�K�X�I";
			} 
			else if(pw.length<6 || pw.length>8){
				return "���~�G�����b6�X~8�X�����C";
			}
			else if (flag0==0){
				return "���~�G�����]�t�j�g�^��r���C";
			}
			else if(flag1==0){
				return "���~�G�����]�t�p�g�^��r���C";
			}
			else if(flag2==0){
				return "���~�G�����]�t�Ʀr�C";
			}
			else if(flag3==0){
				return "���~�G�����]�t�S��Ÿ� ex:@#$%^&*()_�C";
			}
			else 
				return "���ߵo�]";
		}
	};
	
	LabelFieldEX(){
		tfAccount.addFocusListener(new BtnFocusListener("�b��"));
		pfPassWord.addFocusListener(new BtnFocusListener("�K�X"));
		lbAccount.setDisplayedMnemonic('N');
		//�]�w�ϥ�N�f�tAlt�䰵���U����
		lbAccount.setLabelFor(tfAccount);
		//�]�wlbName���Ҭ�tfName��r��쪺�W��
		lbPassWord.setDisplayedMnemonic('P');
		//�]�w�ϥ�P�f�tAlt�䰵���O����
		lbPassWord.setLabelFor(pfPassWord); //�]�wlbPW���Ҭ�tfPW��r��쪺�W��
		pfPassWord.setEchoChar('@'); //�]�w�K�X��ϥΪ��B�n�r��
		pfPassWord.addActionListener(al);
		//���U�^��ActionEvent�ƥ󪺺�ť��
		JPanel jpCenter = new JPanel(new GridLayout(2, 2,  5, 5));
		jpCenter.add(lbAccount); //�N����[�JJPanel�l�e��
		jpCenter.add(tfAccount);
		jpCenter.add(lbPassWord);
		jpCenter.add(pfPassWord);
		JPanel jpLabel = new JPanel(new GridLayout(2, 1, 5, 5));
		jpLabel.add(lbEnter);
		Container cp = getContentPane(); //���o���e����
		BorderLayout bl = (BorderLayout)cp.getLayout();
		//���o�G���޲z��
		bl.setVgap(10); //�]�w�������Z��10
		cp.add(jpCenter); //�N����[�J����
		cp.add(jpLabel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�]�w���������N�w�]�����{��
		setSize(500, 150); //�]�w�����ج[�j�p
		setVisible(true); //��ܵ����ج[
	}
	public static void main(String args[]) {
		new LabelFieldEX(); //�ŧi�����ج[����
	}
}