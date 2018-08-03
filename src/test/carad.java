package test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class carad extends carxx implements ActionListener {
	private Connection ct = null;  
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  

    private JLabel a = new JLabel("货车牌照");
    private JLabel b1 = new JLabel("货车型号");
    private JLabel c = new JLabel("货车状态");
    private JLabel d = new JLabel("当前位置");

    private JLabel h = new JLabel("司机编号");

  
    private JTextField d1=new JTextField();
    private JTextField d2=new JTextField();
    //private JTextField d3=new JTextField();
    String str1[] = {"空闲", "运输中"};  
    private JComboBox d3 = new JComboBox(str1); 
    private JTextField d4=new JTextField();
    private JTextField d5=new JTextField();
    private JTextField d6=new JTextField();
    private JTextField d7=new JTextField(); 
    private JTextField d8=new JTextField(); 
    private JButton bt = new JButton("添加");
    private JButton bt1 = new JButton("重置");


	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame window=new JFrame();
        JPanel w=new JPanel();
        //t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        


        try{
     			//int i=null;
                 Class.forName("com.mysql.jdbc.Driver");
                 System.out.println("JBDC 加载成功!");
                 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
                 ps = ct.prepareStatement("SELECT * FROM car");//3.访问数据库
                 rs = ps.executeQuery();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
     
                 
             }catch(Exception a){
                 System.out.println("JBDC gg!");
                 a.printStackTrace();
             }
          
   
        
        w.setLayout(new GridLayout(9,2));
        window.setTitle("录入货车信息");
        window.setSize(350,400);
        window.setVisible(true); 
        window.add(w);
        w.add(a);
        w.add(d1);
        w.add(b1);
        w.add(d2);
        w.add(c);
        w.add(d3);
        w.add(d);
        w.add(d4);
        w.add(h);
        w.add(d5);
   

     
        
        dingdanaddok ok1=new dingdanaddok();
	       bt.addActionListener(ok1);
	       dingdanaddre re1=new dingdanaddre();
	       bt1.addActionListener(re1);

        w.add(bt);
        w.add(bt1);
             
             
}
	  //重置按钮事件
		public class dingdanaddre implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				d1.setText("");
				d2.setText("");
				//d3.setText("");
				d4.setText("");
				d5.setText("");
				d6.setText("");
				d7.setText("");
				d8.setText("");
	
				
			}
			}
	
	
	
	
      //添加按钮事件（具体的数据插入操作）
	public class dingdanaddok implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			  String sql = "INSERT INTO car(carid,carname,carstate,carposition,drid) "
		                + "values(?,?,?,?,?)";   //数据库操作
			  
	
			try{
				//int i=null;
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("JBDC 加载成功!");
	
	            
	        }catch(Exception a){
	            System.out.println("JBDC gg!");
	            a.printStackTrace();
	        }
			
	        try{
	            ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root",""); //连接数据库
	            ps=ct.prepareStatement(sql);  //访问数据库
	            
	             
	            ps.setString(1,d1.getText());
	           // ps.setLong(1,i);
	            ps.setString(2,d2.getText());
	            ps.setString(3,(String) d3.getSelectedItem());
	            ps.setString(4,d4.getText());
	            ps.setString(5,d5.getText());
	    
	
	            //1 2 3 4 5 6 7 8代表（？？？？？？？？）

	            ps.executeUpdate();
	             
	            //System.out.println("MySQL 连接成功!");
	            //stat = conn.createStatement();
	            //stat.executeUpdate(sql);
	            //System.out.println("插入数据成功!");
	            JOptionPane.showMessageDialog(null, "添加成功");
	            b3.doClick();
	                 
	             
	        }catch (SQLException b){
	            b.printStackTrace();     
	            JOptionPane.showMessageDialog(null, "不能输入重复的车牌照", "添加失败", JOptionPane.ERROR_MESSAGE);
	        }finally{
	            try{
	                ct.close();
	                System.out.println("MySQL 关闭成功");
	            }catch (SQLException c){
	                System.out.println("MySQL 关闭失败 ");
	                c.printStackTrace();
	            }
	             
	        }

		// TODO Auto-generated method stub

	}

}
}
