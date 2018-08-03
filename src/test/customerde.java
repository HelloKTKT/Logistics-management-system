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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class customerde extends customerxx implements ActionListener {

	private Connection ct = null;  
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  
	
    protected static JLabel t1=new JLabel();
    protected static JLabel t2=new JLabel();
    protected static JLabel t3=new JLabel();
    protected static JLabel t4=new JLabel();
    protected static JLabel t5=new JLabel();

 
  

	@Override
	public void actionPerformed(ActionEvent e) {
		int rn = jt.getSelectedRow();
		
	
	    if(rn == -1) {  
            JOptionPane.showMessageDialog(null, "请选择一行");  
            return ;  
        }  
	    String id = (String) jt.getValueAt(rn, 0);
        rn = jt.getSelectedRow();
		
		//JComboBox t10=new JComboBox(str1);
		JLabel jl1=new JLabel("客户编号");
		JLabel jl2=new JLabel("客户姓名");
		JLabel jl3=new JLabel("性别");
		JLabel jl4=new JLabel("联系电话");
		JLabel jl5=new JLabel("公司地址");

		JButton deok=new JButton("确认删除");

		 final JFrame jr=new JFrame("请进行删除");
		 jr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 //jr.setDefaultCloseOperation(jr.EXIT_ON_CLOSE);
		 //jr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       JPanel jl=new JPanel();
	       jr.setSize(500,300);
	       jr.setVisible(true);
	    
      
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("jdbc ok");
             
        }catch(Exception d){
            System.out.println("jdbc gg");
            d.printStackTrace();
        }
        
        try{
            //conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");
            //stat=conn.createStatement();
           // res=stat.executeQuery(sql);

            ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
            ps = ct.prepareStatement("SELECT * FROM customer where cid='"+id+"'");//3.访问数据库
            rs = ps.executeQuery();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
           
           while (rs.next())
            { 
        	  

                	t1.setText(rs.getString(1));
                    //t1.setText(rs.getString(2));
                    t2.setText(rs.getString(2));
                    t3.setText(rs.getString(3));
                    t4.setText(rs.getString(4));
                    t5.setText(rs.getString(6));
                   
                    
          
                    //System.out.println("5050");
                    
                    break;
                }
            }
          
            
        
           
        catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.println("gg");
         
         
    }
        finally{
            try{
                ct.close();
                System.out.println("op");
            }catch(SQLException ar){
                ar.printStackTrace();
            }
     
        }
     
       //JFrame jr=new JFrame("请进行修改");
      // JPanel jl=new JPanel();
      // jr.setSize(500,400);
      // jr.setVisible(true);
       jl.setLayout(new GridLayout(6,2));
       
       jr.add(jl);
       //jl.add(t1);
       jl.add(jl1);
       jl.add(t1);
       jl.add(jl2);
       jl.add(t2);
       jl.add(jl3);
       jl.add(t3);
       jl.add(jl4);
       jl.add(t4);
       jl.add(jl5);
       jl.add(t5);


       jl.add(deok);
       
       deok.addActionListener(new ActionListener() {
    	
          public void actionPerformed(ActionEvent e) {
        	   String st=t1.getText();
        	 
        	   
       		
        		
       		try {
       		    Class.forName("com.mysql.jdbc.Driver");//1.加载驱动程序
       	        ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库      
              ps = ct.prepareStatement("delete from customer where cid='"+st+"'");//3.访问数据库
       	     ps.executeUpdate();
       	        System.out.println("jdbc ok");
       	     JOptionPane.showMessageDialog(null, "删除成功");
       	  jr.dispose();
       	  b4.doClick();
       		// TODO Auto-generated method stub
       		}
       		catch (Exception q)
       		{
       			q.printStackTrace();
                   System.out.println("jdbc gg");
       		}
       		

                  
               finally{
                   try{
                       ct.close();
                   }catch(SQLException ar){
                       ar.printStackTrace();
                   }
            
               }
                

           }
       });
       
	   
		// TODO Auto-generated method stub

	}

}
