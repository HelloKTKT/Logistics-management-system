package test;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login {
	
	protected static JTextField jtf1=new JTextField();
	protected static JPasswordField jtf2=new JPasswordField();
	protected static JTextField jtf3=new JTextField();
	protected static JPasswordField jtf4=new JPasswordField();
	

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new login();
		
	}
	
		
		public login()
		{
		
		JFrame jf=new JFrame("��������ϵͳ��½����");
		 jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		jf.setBounds(270, 100,700,400);
		JPanel j1=new JPanel();
		JPanel j2=new JPanel();
		JLabel jla1=new JLabel("������Ա��¼");
		JLabel jla2=new JLabel("�ʺ�");
		JLabel jla3=new JLabel("����");
		JLabel jlb1=new JLabel("�ͻ���¼");
		JLabel jlb2=new JLabel("�ʺ�");
		JLabel jlb3=new JLabel("����");
		JButton jb1=new JButton("��¼");
		JButton jb2=new JButton("��¼");

		
		
		jf.setLayout(null);
		j1.setLayout(null);
		j2.setLayout(null);
		jf.setBackground(Color.white); 
		j1.setBackground(Color.LIGHT_GRAY); 
		j2.setBackground(Color.LIGHT_GRAY); 
		j1.setBounds(2, 2,348,348);
		j2.setBounds(352, 2,348,348);
		jla1.setBounds(120,20,150,20);
		jla2.setBounds(30,80,150,20);
		jla3.setBounds(30,120,150,20);
		jtf1.setBounds(150,80,150,20);
		jtf2.setBounds(150,120,150,20);
		jb1.setBounds(100,180,150,40);
		
		jlb1.setBounds(120,20,150,20);
		jlb2.setBounds(30,80,150,20);
		jlb3.setBounds(30,120,150,20);
		jtf3.setBounds(150,80,150,20);
		jtf4.setBounds(150,120,150,20);
		jb2.setBounds(100,180,150,40);
		

		jf.add(j1);
		jf.add(j2);
		j1.add(jla1);
		j1.add(jla2);
		j1.add(jla3);
		j1.add(jtf1);
		j1.add(jtf2);
		j1.add(jb1);
		
		j2.add(jlb1);
		j2.add(jlb2);
		j2.add(jlb3);
		j2.add(jtf3);
		j2.add(jtf4);
		j2.add(jb2);
		
	  
		jb1.addActionListener(new ActionListener()
        {
	private Connection ct=null;
   private PreparedStatement ps = null;  
   private ResultSet rs = null; 
           public void actionPerformed(ActionEvent e)
            {
        	   int testa = 0;
        	   int testb = 0;
           	try
       		{
       			Class.forName("com.mysql.jdbc.Driver");
       			 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
       			ps = ct.prepareStatement("SELECT * FROM manager");
       			
       			rs = ps.executeQuery();
       		 while(rs.next())
		        {
		     if(rs.getString(1).equals(jtf1.getText()))
		     {
		    	 testa=1;
		
		    	 break;
		     }
		        }
	
		  
       		        ps = ct.prepareStatement("SELECT * FROM manager WHERE mid= '"+jtf1.getText()+"'");//3.�������ݿ�
       		        rs = ps.executeQuery();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�

       		        while(rs.next())
       		        {
       		        	System.out.println("b");
       		     if(rs.getString(3).equals(new String(jtf2.getPassword())))
       		     {
       		    	 testb=1;       		      	
       		    	 break;
       		     }
       		     }
       		        
       		     if((testa==1)&&(testb==1))
       		     {
       		    	
       		    	new home().home11(rs.getString(2),rs.getString(1)); 
       		     }
       		     else{JOptionPane.showMessageDialog(null, "��������ȷ���˺ź�����");}
       		     
       		        System.out.println("load  ok!");
       		    
  		        		
       		}
       		catch(Exception q)
       		{
       			//JOptionPane.showMessageDialog(null, "��������ȷ���˺ź�����");
       			 q.printStackTrace();
       		        System.out.println("load gg");
       		}
            }
       });
		
		jb2.addActionListener(new ActionListener()
        {
	private Connection ct=null;
   private PreparedStatement ps = null;  
   private ResultSet rs = null; 
           public void actionPerformed(ActionEvent e)
            {
        	   int testa = 0;
        	   int testb = 0;
           	try
       		{
       			Class.forName("com.mysql.jdbc.Driver");
       			 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
       			ps = ct.prepareStatement("SELECT * FROM customer");
       			
       			rs = ps.executeQuery();
       		 while(rs.next())
		        {
		     if(rs.getString(1).equals(jtf3.getText()))
		     {
		    	 testa=1;
		
		    	 break;
		     }
		        }
	
		  
       		        ps = ct.prepareStatement("SELECT * FROM customer WHERE cid= '"+jtf3.getText()+"'");//3.�������ݿ�
       		        rs = ps.executeQuery();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�

       		        while(rs.next())
       		        {
       		        	
       		     if(rs.getString(5).equals(new String(jtf4.getPassword())))
       		     {
       		    	 testb=1;       		      	
       		    	 break;
       		     }
       		     }
       		        
       		     if((testa==1)&&(testb==1))
       		     {
       		    	
       		    	new homec().homecc(rs.getString(2),rs.getString(1)); 
       		    	return ;
       		     }
       		     else{JOptionPane.showMessageDialog(null, "��������ȷ���˺ź�����");}
       		     
       		        System.out.println("load  ok!");
       		    
  		        		
       		}
       		catch(Exception q)
       		{
       			//JOptionPane.showMessageDialog(null, "��������ȷ���˺ź�����");
       			 q.printStackTrace();
       		        System.out.println("load gg");
       		}
            }
       });
		
		
		jf.addWindowListener
	       (new WindowAdapter ()
	       {
	    	   public void windowClosing ( WindowEvent e )
	    	   {
	    		   int res=JOptionPane.showConfirmDialog(null, "�Ƿ��˳�����", "�뿪", JOptionPane.YES_NO_OPTION);
	    		  if(res==JOptionPane.YES_OPTION)
	    		  {   
	    			  System.exit(0);
	    		  }
	    	   }   	    	   
	       });    	
		
		

		jf.setVisible(true);
		// TODO Auto-generated method stub
		}
	

}
