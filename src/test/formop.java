package test;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class formop extends formxx implements ActionListener {
	
    protected static JLabel t1=new JLabel (); 
   protected static String str1[] = {"已出货","已完成","出货中"};  
    protected static JComboBox t2=new JComboBox(str1);
  
    protected JFrame jr=null;
    protected JPanel jl=null;
    static String id;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int rn=-1;
		rn = jt.getSelectedRow();

	    if(rn == -1) {  
            JOptionPane.showMessageDialog(null, "请选择一行");  
            return ;  
        }  		
	   id = (String) jt.getValueAt(rn, 0);
	   final String id4 = (String) jt.getValueAt(rn, 1);
	    String id2 = (String) jt.getValueAt(rn, 8);
	    final String id3 = (String) jt.getValueAt(rn, 7);

	     final JFrame jr=new JFrame("更新物流状态");
	     JPanel jl=new JPanel();
	    t1.setText(id);
	    t2.setSelectedItem(id2);

	    JLabel jl1=new JLabel("物流编号：");
        JLabel jl2=new JLabel("更新状态为：");
       
        
        JButton jb=new JButton("确认");
        
        jr.setSize(270,200);
	       jr.setVisible(true);
	       jl.setLayout(new GridLayout(3,2));
	       jr.add(jl);
	       jl.add(jl1);jl.add(t1);
	       jl.add(jl2);jl.add(t2);
	 
	       jl.add(jb);
	       
	       jb.addActionListener(new ActionListener()
	       {
	    		private Connection ct=null;
	    	    private Statement ps = null;  
	    	    private ResultSet rs = null;  
	    	   public void actionPerformed(ActionEvent e) 
	    	   {
	    		   try
	   			{
	    			   Class.forName("com.mysql.jdbc.Driver");
						 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
					        ps = ct.createStatement();//3.访问数据库
					         //ps.executeUpdate();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
					         System.out.println("jdbc ok");
					     	String sql2="UPDATE form SET lostate='"+t2.getSelectedItem()+"'  WHERE loid='"+id+"'";
					     	String sql3="UPDATE goods SET goposition='"+id3+"'  WHERE goodsid='"+id4+"'";
					     	String sql4="UPDATE form SET carposition='已到达'  WHERE loid='"+id+"'";
					     	
					     	 ps.executeUpdate(sql2);
					     	 
					     	 
					     	 
					     	 
					     	if(	t2.getSelectedItem().equals("已完成"))
					     	{
					     		ps.executeUpdate(sql3);
					     		ps.executeUpdate(sql4);
					     	}
					     	 
					     	 
					     	 
					     	 
	   			        System.out.println("load  ok!");
	   			        
	   			        
	   			        
	   			        
	   			        
	   			        
	   			     JOptionPane.showMessageDialog(null, "更新成功");
			            b6.doClick();
			            jr.dispose();
	   			     
	   			    
	   			}
	   			catch(Exception q)
	   			{
	   				 q.printStackTrace();
	   			        System.out.println("load gg");
	   			}
	   			finally
	   			{
	   		        try
	   		        {

	   		            ps.close();
	   		            ct.close();
	   		            System.out.println("close ok");
	   		        }catch (SQLException o)
	   		        {
	   		            o.printStackTrace();
	   		            System.out.println("close gg");
	   		        }
	   			}
	    	   }  
	       });
 
		// TODO Auto-generated method stub

	}

}
