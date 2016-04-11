import javax.swing.*;  //引用套件
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.text.MaskFormatter;

public class LabelFieldEX extends JFrame{
	int flag=0;
	JLabel lbAccount = new JLabel("帳號(N) : ", JLabel.RIGHT);	
	JLabel lbPassWord = new JLabel("密碼(P) : ", JLabel.RIGHT);	
	JFormattedTextField tfAccount = new JFormattedTextField();
	JPasswordField pfPassWord = new JPasswordField(20);
	JLabel lbEnter = new JLabel("請輸入電子郵件地址！");
	
	//以匿名內部類別的方式定義並宣告監聽器物件
	ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Verifier ssd = new Verifier(new String(pfPassWord.getPassword()));
			lbEnter.setText("密碼"+ssd.passwordok()+"你的密碼是："+ new String(pfPassWord.getPassword()));//這裡要判斷密碼
		}
	};
	
	class BtnFocusListener implements FocusListener {
		private String btnName;
		public BtnFocusListener(String name){ //建構子
			btnName = name;
		}
		public void focusGained(FocusEvent e){} //處理取得焦點的方法	
		public void focusLost(FocusEvent e){ //處理失去焦點的方法
			if(flag==0){
				RegexFormatter kk = new RegexFormatter(tfAccount.getText());
				lbEnter.setText(btnName+kk.accountok());//這裡要判斷有沒有@和.
				flag=1;
			}
			else if (flag==1){
				flag=0;
			}
		}
	};
	
	class RegexFormatter  { //帳號驗證
		int tposition,pposition;//t @位置 .位置
		String text;
		public  RegexFormatter(String outtext){
			text=outtext;
			tposition=text.indexOf('@', 0);
			pposition=text.indexOf('.', 0);
		}
		public String accountok(){
			
			if (text.length()==0) {
				return "請輸入電子郵件地址！";
			} 
			else if (tposition==-1 || pposition==-1 ) {
				return "錯誤：必須包含「@和.」。";
			} 
			else if (tposition==0 || pposition==0) {
				return "錯誤：「@或.」之前不可為空字串。";
			} 
			else if (tposition==text.length()-1 || pposition==text.length()-1) {
				return "錯誤：「@或.」之後不可為空字串。";
			} 
			else if (tposition>pposition) {
				return "輸入錯誤";
			}
			else
				return "恭喜發財";
		}
	};
	
	class Verifier  { //帳號驗證
		char pw[];
		String text;
		int flag0=0,flag1=0,flag2=0,flag3=0; //是否有達成條件
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
				return "請輸入密碼！";
			} 
			else if(pw.length<6 || pw.length>8){
				return "錯誤：必須在6碼~8碼之間。";
			}
			else if (flag0==0){
				return "錯誤：必須包含大寫英文字母。";
			}
			else if(flag1==0){
				return "錯誤：必須包含小寫英文字母。";
			}
			else if(flag2==0){
				return "錯誤：必須包含數字。";
			}
			else if(flag3==0){
				return "錯誤：必須包含特殊符號 ex:@#$%^&*()_。";
			}
			else 
				return "恭喜發財";
		}
	};
	
	LabelFieldEX(){
		tfAccount.addFocusListener(new BtnFocusListener("帳號"));
		pfPassWord.addFocusListener(new BtnFocusListener("密碼"));
		lbAccount.setDisplayedMnemonic('N');
		//設定使用N搭配Alt鍵做為助憶鍵
		lbAccount.setLabelFor(tfAccount);
		//設定lbName標籤為tfName文字欄位的名稱
		lbPassWord.setDisplayedMnemonic('P');
		//設定使用P搭配Alt鍵做為記憶鍵
		lbPassWord.setLabelFor(pfPassWord); //設定lbPW標籤為tfPW文字欄位的名稱
		pfPassWord.setEchoChar('@'); //設定密碼欄使用的遮罩字元
		pfPassWord.addActionListener(al);
		//註冊回應ActionEvent事件的監聽器
		JPanel jpCenter = new JPanel(new GridLayout(2, 2,  5, 5));
		jpCenter.add(lbAccount); //將元件加入JPanel子容器
		jpCenter.add(tfAccount);
		jpCenter.add(lbPassWord);
		jpCenter.add(pfPassWord);
		JPanel jpLabel = new JPanel(new GridLayout(2, 1, 5, 5));
		jpLabel.add(lbEnter);
		Container cp = getContentPane(); //取得內容面版
		BorderLayout bl = (BorderLayout)cp.getLayout();
		//取得佈局管理員
		bl.setVgap(10); //設定垂直間距為10
		cp.add(jpCenter); //將元件加入面版
		cp.add(jpLabel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//設定關閉視窗將預設結束程式
		setSize(500, 150); //設定視窗框架大小
		setVisible(true); //顯示視窗框架
	}
	public static void main(String args[]) {
		new LabelFieldEX(); //宣告視窗框架物件
	}
}