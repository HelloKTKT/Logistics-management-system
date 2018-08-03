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
import javax.swing.JTextField;

public class orderadd extends lookgoods implements ActionListener {
	
	private Connection ct = null;  
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  
	
	    private JLabel a = new JLabel("订单编号");
	    private JLabel b = new JLabel("货物编号");
	    private JLabel c = new JLabel("货物名称");
	    private JLabel d = new JLabel("种类");
	    private JLabel e1 = new JLabel("库存数量（件）");
	    private JLabel f = new JLabel("输入数量");
	    private JLabel g = new JLabel("填写收货人姓名");
	    private JLabel h = new JLabel("填写收货地址");
	    private JLabel i = new JLabel("填写收货人电话");
	    
	    private JLabel a1 = new JLabel();
	    private JLabel b1 = new JLabel();
	    private JLabel c1 = new JLabel();
	    private JLabel d1 = new JLabel();
	    private JLabel e11 = new JLabel();
	    
	    private JTextField f1 = new JTextField();
	    private JTextField g1 = new JTextField();
	    private JTextField h1 = new JTextField();
	    private JTextField i1 = new JTextField();

        private JButton jb=new JButton("确认订单");
	    
	    static String id,ii;
	    static int ik;


	@Override
	public void actionPerformed(ActionEvent e) {
		
		 int rn = jt.getSelectedRow();

			
		    if(rn == -1) {  
	            JOptionPane.showMessageDialog(null, "请选择一行");  
	            return ;  
	        }  
		    id = (String) jt.getValueAt(rn, 0);
	        //rn = jt.getSelectedRow();
		
		
		final JFrame jf=new JFrame("自助下单");
		 JPanel jpa=new JPanel();
	        
	 f1.setText("");
	 g1.setText("");
	 h1.setText("");
	 i1.setText("");
	 
	 
	        
		 jpa.setLayout(new GridLayout(10,2));
	        
	 
	        jf.setSize(350,300);
	        jf.setVisible(true); 
	        jf.add(jpa);
	        
	        try{
         
       
	            ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库	  
	            ps = ct.prepareStatement("SELECT * FROM orders ");//3.访问数据库
	            rs = ps.executeQuery();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
	            
	            while (rs.next())
                {
                	//i=rs.getString(1);	
                	  ik = Integer.parseInt(rs.getString(1));
                	ik++;
            ii=Integer.toString(ik);
                }
                
                a1.setText(ii);
                b1.setText((String) jt.getValueAt(rn, 0));
                c1.setText((String) jt.getValueAt(rn, 1));
                //c1.setText((String) jt.getValueAt(rn, 3));
                d1.setText((String) jt.getValueAt(rn, 2));
                e11.setText((String) jt.getValueAt(rn, 3));
     

                
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
	        
	        
	        jpa.add(a);jpa.add(a1);
	        jpa.add(b);jpa.add(b1);
	        jpa.add(c);jpa.add(c1);
	        jpa.add(d);jpa.add(d1);
	        jpa.add(e1);jpa.add(e11);
	        jpa.add(f);jpa.add(f1);
	        jpa.add(g);jpa.add(g1);
	        jpa.add(h);jpa.add(h1);
	        jpa.add(i);jpa.add(i1);
	        jpa.add(jb);
		
		// TODO Auto-generated method stub

	        jb.addActionListener(new ActionListener()
	        {
	        	public void actionPerformed(ActionEvent e)
	        	{

					  String sql = "INSERT INTO orders(orid,goid,goname,gogetnumber,getname,getaddress,getnumber,orstate,cid) "
				                + "values(?,?,?,?,?,?,?,?,?)";   //数据库操作
					
					try{
			            Class.forName("com.mysql.jdbc.Driver");
			            System.out.println("JBDC 加载成功!");
			        }catch(Exception a){
			            System.out.println("JBDC gg!");
			            a.printStackTrace();
			        }
			        try{
			            ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root",""); //连接数据库
			            ps=ct.prepareStatement(sql);  //访问数据库
			             
			            ps.setString(1,a1.getText());
			            ps.setString(2,b1.getText());
			            ps.setString(3,c1.getText()); 
			            ps.setString(4,f1.getText());
			            ps.setString(5,g1.getText());
			            ps.setString(6,h1.getText()); 
			            ps.setString(7,i1.getText()); 
			            ps.setString(8,"待办理"); 
			            ps.setString(9,zh);
			  

			            ps.executeUpdate();
			             
			            //System.out.println("MySQL 连接成功!");
			            //stat = conn.createStatement();
			            //stat.executeUpdate(sql);
			            //System.out.println("插入数据成功!");
			            JOptionPane.showMessageDialog(null, "下单成功");
			            jf.dispose();
			            //.doClick();
			          
			                 
			             
			        }catch (SQLException b){
			            b.printStackTrace(); 
			            JOptionPane.showMessageDialog(null, "下单失败");
			         
			        }finally{
			            try{
			                ct.close();
			                System.out.println("MySQL 关闭成功");
			            }catch (SQLException c){
			                System.out.println("MySQL 关闭失败 ");
			                c.printStackTrace();
			            }
			             
			        }
	        	}
	        });
	        
	        
	}

}
