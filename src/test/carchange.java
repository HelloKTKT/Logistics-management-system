package test;

import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import javax.swing.JTextField;



public class carchange extends carxx implements ActionListener {
	//public static JTextField jt;
	private Connection ct=null;
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  
    String str[]={"����","������"};
    
    public  JTextField jl22=new JTextField();
    public  JTextField jl33=new JTextField();
    public  JComboBox jl44=new JComboBox(str);
    public  JTextField jl55=new JTextField();

    public  JTextField jl99=new JTextField();
    JFrame jf=null;
    static String id;

	@Override
	public void actionPerformed(ActionEvent e) {

		

		// TODO Auto-generated method stub
		 int rn = jt.getSelectedRow();

		
	    if(rn == -1) {  
            JOptionPane.showMessageDialog(null, "��ѡ��һ��");  
            return ;  
        }  
	    id = (String) jt.getValueAt(rn, 0);
        rn = jt.getSelectedRow();
	
		

		
			JFrame jf=new JFrame("��ȷ����Ϣ");
		
			jf.setSize(270,500);
			jf.setVisible(true);
			JPanel jp=new JPanel();
			jp.setLayout(new GridLayout(9,2));
		     JLabel jl1 = new JLabel("��������");
		     JLabel jl2 = new JLabel("�����ͺ�");
		     JLabel jl3 = new JLabel("����״̬");
		     JLabel jl4 = new JLabel("��ǰλ��");
	
		     JLabel jl8 = new JLabel("˾�����");
			JTextField jl11=new JTextField();
			jl11.setEditable(false);
	
			JButton jb1=new JButton("�޸����");
			
			try
			{
				int t=0;
				Class.forName("com.mysql.jdbc.Driver");
				 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
			        ps = ct.prepareStatement("SELECT * FROM car");//3.�������ݿ�
			        rs = ps.executeQuery();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�
			        while(rs.next())
			        {
			        	if(rs.getString(1).equals(id))
			        	{
			        		
			        		jl22.setText(rs.getString(1));
			        		jl33.setText(rs.getString(2));
			        		jl44.setSelectedItem(rs.getString(3));
			        		jl55.setText(rs.getString(4));
			        
			        		jl99.setText(rs.getString(5));
			        		
			        		t=1;
			
			        	break;
			        	}
			        }
			        System.out.println("load  ok!");
			     
			    
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
		            rs.close();
		            ps.close();
		            ct.close();
		            System.out.println("close ok");
		        }catch (SQLException o)
		        {
		            o.printStackTrace();
		            System.out.println("close gg");
		        }
			}
			

			jf.add(jp);
			jp.add(jl1);jp.add(jl22);
			jp.add(jl2);jp.add(jl33);
			jp.add(jl3);jp.add(jl44);
			jp.add(jl4);jp.add(jl55);
		
			jp.add(jl8);jp.add(jl99);
			jp.add(jb1);
			
			carchok carchok=new carchok();
			jb1.addActionListener(carchok);
			
		
			
			
		}
			public class carchok implements ActionListener
			{
				Statement ps = null;  
		
				public void actionPerformed(ActionEvent e1)
				{
					//String st=jl22.getText();
					// System.out.println("jl22.getText()");
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
					        ps = ct.createStatement();//3.�������ݿ�
					         //ps.executeUpdate();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�
					         System.out.println("jdbc ok");

					}
					     
					catch(Exception q)
					{
						 q.printStackTrace();
					        System.out.println("load gg");
					        
					}

					//String sql1="UPDATE huowu SET hwid='"+jl11.getText()+"'  WHERE hwid='"+jt.getText()+"'";
					String sql2="UPDATE car SET carid='"+jl22.getText()+"'  WHERE carid='"+id+"'";
					String sql3="UPDATE car  SET carname='"+jl33.getText()+"'  WHERE carid='"+id+"'";
					String sql4="UPDATE car  SET carstate='"+jl44.getSelectedItem()+"'  WHERE carid='"+id+"'";
					String sql5="UPDATE car  SET carposition='"+jl55.getText()+"'  WHERE carid='"+id+"'";
		
					String sql9="UPDATE car SET drid='"+jl99.getText()+"'  WHERE carid='"+id+"'";
					
					String sql11 = "update form,car set form.carposition=car.carposition where form.carid=car.carid and form.lostate!='�����' "; 
					String sql12 = "update orders,car set orders.carposition=car.carposition where orders.carid=car.carid and orders.orstate!='�����'"; 
				
		
			        try {
			        	//ps.executeUpdate(sql1);
			            ps.executeUpdate(sql2);
			            ps.executeUpdate(sql3);
			            ps.executeUpdate(sql4);
			            ps.executeUpdate(sql5);
						ps.executeUpdate(sql9);
						
						ps.executeUpdate(sql11);
					    ps.executeUpdate(sql12);
						
			
			            JOptionPane.showMessageDialog(null, "�޸ĳɹ�"); 
			            jf.dispose();
			            b3.doClick();
			           
			            
			        } 
			        catch (SQLException g) {
			            // TODO Auto-generated catch block
			            g.printStackTrace();
			            JOptionPane.showMessageDialog(null, "�޸�ʧ��"); 
			            
			        }
			        
			        finally{
			            try{
			                ct.close();
			            }catch(SQLException ar){
			                ar.printStackTrace();
			            }
			     
			        }
				}
			}
			
			
		
		// TODO Auto-generated method stub

	}


