package test;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import test.carchange.carchok;

public class driverop extends driverxx implements ActionListener {
	private Connection ct=null;
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  
    
    public  JTextField jl11=new JTextField();
    public  JTextField jl22=new JTextField();
    public  JTextField jl33=new JTextField();
    public  JTextField jl44=new JTextField();

    public  JTextField jl55=new JTextField();
    static String id;


	@Override
	public void actionPerformed(ActionEvent e) {
		
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
			     JLabel jl1 = new JLabel("˾�����");
			     JLabel jl2 = new JLabel("˾������");
			     JLabel jl3 = new JLabel("��ϵ�绰");
			     JLabel jl4 = new JLabel("���ձ��");
		
			     JLabel jl5 = new JLabel("��ַ");
				JTextField jl11=new JTextField();
				jl11.setEditable(false);
		
				JButton jb1=new JButton("�޸����");
				
				try
				{
					int t=0;
					Class.forName("com.mysql.jdbc.Driver");
					 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
				        ps = ct.prepareStatement("SELECT * FROM driver");//3.�������ݿ�
				        rs = ps.executeQuery();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�
				        while(rs.next())
				        {
				        	if(rs.getString(1).equals(id))
				        	{
				        		
				        		jl11.setText(rs.getString(1));
				        		jl22.setText(rs.getString(2));
				        		jl33.setText(rs.getString(3));
				        		jl44.setText(rs.getString(4));
				        
				        		jl55.setText(rs.getString(5));
				        		
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
				jp.add(jl1);jp.add(jl11);
				jp.add(jl2);jp.add(jl22);
				jp.add(jl3);jp.add(jl33);
				jp.add(jl4);jp.add(jl44);
			
				jp.add(jl5);jp.add(jl55);
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
					
						String sql1="UPDATE driver  SET drname='"+jl22.getText()+"'  WHERE drid='"+id+"'";
						String sql2="UPDATE driver  SET drnumber='"+jl33.getText()+"'  WHERE drid='"+id+"'";
						String sql3="UPDATE driver  SET drlicense='"+jl44.getText()+"'  WHERE drid='"+id+"'";
			
						String sql4="UPDATE driver SET draddress='"+jl55.getText()+"'  WHERE drid='"+id+"'";
						
				
					
			
				        try {
				        	ps.executeUpdate(sql1);
				            ps.executeUpdate(sql2);
				            ps.executeUpdate(sql3);
				            ps.executeUpdate(sql4);
				       
							
				
				            JOptionPane.showMessageDialog(null, "�޸ĳɹ�"); 
				            b5.doClick();
				           
				            
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


