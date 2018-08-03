package test;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class guest {
	
	static JFrame jf=new JFrame("客户界面");
	JPanel j1=new JPanel();
	JPanel j2=new JPanel();
	JButton jb1=new JButton("我的订单");
	JButton jb2=new JButton("自助下单");
	JButton jb3=new JButton("个人信息");
	
	public guest(String na)
	{
		JLabel jl=new JLabel("欢迎您,"+na);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setVisible(true);
		jf.setBounds(200, 100,420, 400);
		jf.setLayout(null);
		j1.setBounds(0,0,420,100);
		j2.setBounds(0,100,420,300);
		j1.setBackground(Color.BLUE);
		j2.setBackground(Color.white);
		j1.setLayout(null);
		jl.setBounds(0,0,120,25);
		jb1.setBounds(10,30,120,25);
		jb2.setBounds(140,30,120,25);
		jb3.setBounds(270,30,120,25);
		
		
		jf.add(j1);
		jf.add(j2);
		j1.add(jb1);
		j1.add(jb2);
		j1.add(jb3);
		j1.add(jl);
	}

}
