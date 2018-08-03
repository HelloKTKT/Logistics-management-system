package test;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class dddelete extends ddxx implements ActionListener {
	//protected JFrame jf=new JFrame("删除订单");
	protected JLabel jl=new JLabel("请输入要删除的订单号：");
	protected JTextField jt=new JTextField("");
	protected JButton jb=new JButton("确定");
	
	protected JLabel jl1 = new JLabel("订单编号");
	protected JLabel jl2 = new JLabel("货物编号");
	protected JLabel jl3 = new JLabel("货物名称");
	protected JLabel jl4 = new JLabel("数量（件）");
	protected JLabel jl5 = new JLabel("客户编号");
	protected JLabel jl6 = new JLabel("客户姓名");
	protected JLabel jl7 = new JLabel("客户电话");
	protected JLabel jl8 = new JLabel("收货人");
	protected JLabel jl9 = new JLabel("客户地址");
	protected JLabel jl10 = new JLabel("订单状态");
	protected JLabel jl111 = new JLabel("货车牌照");
	
	protected JLabel jl11 = new JLabel("");
	protected JLabel jl22 = new JLabel("");
	protected JLabel jl33 = new JLabel("");
	protected JLabel jl44 = new JLabel("");
	protected JLabel jl55 = new JLabel("");
	protected JLabel jl66 = new JLabel("");
	protected JLabel jl77 = new JLabel("");
	protected JLabel jl88 = new JLabel("");
	protected JLabel jl99 = new JLabel("");
	protected JLabel jl00 = new JLabel("");
	protected JLabel jl000 = new JLabel("");
	protected JButton jb1=new JButton("确定删除");
	int k=0;
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame jf=new JFrame("删除订单");
		//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		
		jt.setText(null);
		jl11.setText(null);
		jl22.setText(null);
		jl33.setText(null);
		jl44.setText(null);
		jl55.setText(null);
		jl66.setText(null);
		jl77.setText(null);
		jl88.setText(null);
		jl99.setText(null);
		jl00.setText(null);
		jl000.setText(null);

		

		jf.setSize(500, 600);

		jf.setLayout(null);
		jp1.setLayout(null);
		jp2.setLayout(new GridLayout(13,2));
		jp1.setBounds(0, 0, 500, 200);
		jp2.setBounds(0, 200, 500, 400);
		jp1.setBackground(Color.white);
		jp2.setBackground(Color.lightGray);
		jf.add(jp1);
		jf.add(jp2);
		
		
		jl.setBounds(170, 20, 200, 20);
		jp1.add(jl);
		jt.setBounds(150, 70, 200, 20);
		jp1.add(jt);
		jb.setBounds(200, 130, 100, 30);
		jp1.add(jb);
	
		jp2.add(jl1);jp2.add(jl11);
		jp2.add(jl2);jp2.add(jl22);
		jp2.add(jl3);jp2.add(jl33);
		jp2.add(jl4);jp2.add(jl44);
		jp2.add(jl5);jp2.add(jl55);
		jp2.add(jl6);jp2.add(jl66);
		jp2.add(jl7);jp2.add(jl77);
		jp2.add(jl8);jp2.add(jl88);
		jp2.add(jl9);jp2.add(jl99);
		jp2.add(jl10);jp2.add(jl00);
		jp2.add(jl111);jp2.add(jl000);
		jp2.add(jb1);
		
		jf.setVisible(true);
		jp1.setVisible(false);
		jp1.setVisible(true);
		jp2.setVisible(false);
		jp2.setVisible(true);
		
		
		
		
		dddeleteask dddeask=new dddeleteask();
		jb.addActionListener(dddeask); 
		dddeleteok dddeok=new dddeleteok();
		jb1.addActionListener(dddeok); 


		
		// TODO Auto-generated method stub

	}
	
	public class dddeleteask implements ActionListener
	{
		private Connection ct = null;  
	    private PreparedStatement ps = null;  
	    private ResultSet rs = null;  
	    
	    
		public void actionPerformed(ActionEvent e)
		{
			k=0;
			try{
				Class.forName("com.mysql.jdbc.Driver");
			    ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
	            ps = ct.prepareStatement("SELECT * FROM dingdan");//3.访问数据库
	            rs = ps.executeQuery();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
	            System.out.println("jdbc ok");
				}
			catch(Exception d)
			{
				d.printStackTrace();
				System.out.println("jdbc gg");
			}
			try{
				
				while(rs.next())
				{
					if(rs.getString(1).equals(jt.getText()))
					{
						jl11.setText(rs.getString(1));
						jl22.setText(rs.getString(2));
						jl33.setText(rs.getString(3));
						jl44.setText(rs.getString(4));
						jl55.setText(rs.getString(5));
						jl66.setText(rs.getString(6));
						jl77.setText(rs.getString(7));
						jl88.setText(rs.getString(8));
						jl99.setText(rs.getString(9));
						jl00.setText(rs.getString(10));
						jl000.setText(rs.getString(11));
						k=1;
						break;
					}
					
				}
				if(k==0)
				{
					JOptionPane.showMessageDialog(null, "请输入正确订单号", "查无此订单", JOptionPane.ERROR_MESSAGE);	
					jl11.setText(null);
					jl22.setText(null);
					jl33.setText(null);
					jl44.setText(null);
					jl55.setText(null);
					jl66.setText(null);
					jl77.setText(null);
					jl88.setText(null);
					jl99.setText(null);
					jl00.setText(null);
					jl000.setText(null);
				}
				
			}
			catch(Exception d)
			{
				d.printStackTrace();
			}
			
			finally{
	            try{
	                ct.close();
	                System.out.println("ok");
	            }catch(SQLException ar){
	                ar.printStackTrace();
	            }
	     
	        }
			
		}
	}
	public class dddeleteok implements ActionListener
	{
		private Connection ct = null;  
	    private PreparedStatement ps = null;  
	    //private int rs = null;  
	    //String sql="delete from dingdan where hwid='"+jt.getText()+"'";
		public void actionPerformed(ActionEvent e)
		{
			try{
				Class.forName("com.mysql.jdbc.Driver");
			    ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
	            ps = ct.prepareStatement("delete from dingdan where ddid='"+jt.getText()+"'");//3.访问数据库
	             ps.executeUpdate();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
	            System.out.println("jdbc ok");
	            JOptionPane.showMessageDialog(null, "删除成功！");
				}
			catch(Exception d)
			{
				d.printStackTrace();
				System.out.println("jdbc gg");
			}
			//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		}
	}


}
