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



public class hwadd extends hwxx implements ActionListener {
	private Connection ct = null;  
    private PreparedStatement ps = null;  
    
    
    String[] str1 = {"����","ϴ�»�","����", "�յ�","����","΢��¯","���̻�","����"}; 
    JComboBox jcb1=new JComboBox(str1);
 
    private JLabel a = new JLabel("�����");
    private JLabel b1 = new JLabel("������");
    private JLabel c = new JLabel("��������");
    private JLabel d = new JLabel("����");
    private JLabel e1 = new JLabel("�������������");
    private JLabel f = new JLabel("λ��");
    
    //private JLabel d = new JLabel("����״̬");

  
    private JTextField d1=new JTextField();
    private JTextField d2=new JTextField();
   // private JComboBox jcb=new JComboBox();
    private JTextField d3=new JTextField();
    //private JTextField d8=new JTextField();
    private JTextField d5=new JTextField();
    private JTextField d6=new JTextField();
    private JButton bt = new JButton("���");
    private JButton bt1 = new JButton("����");
	 JFrame window=null;
   //d3.setEnabled(false);
	@Override
	public void actionPerformed(ActionEvent e) {
		 JFrame window=new JFrame();
		//d3.setEditable(false);
		 //JFrame window=new JFrame();
	        JPanel w=new JPanel();
	        
	        //String str1[] = {"����", "����","�ϲ�","����"};  
	        //jcb = new JComboBox(str1);  
	        
	        w.setLayout(new GridLayout(7,2));
	        window.setTitle("�����Ϣ");
	       // window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        window.setSize(350,300);
	        window.setVisible(true); 
	        window.add(w);
	        w.add(a);
	        w.add(d1);
	        w.add(b1);
	        w.add(d2);
	        //w.add(d);
	        w.add(c);
	        w.add(d3);
	        
	        //w.add(d3);
	        w.add(d);
	        w.add(jcb1);
	        w.add(e1);
	        w.add(d5);
	        w.add(f);
	        w.add(d6);
	        //w.add(g);
	        //w.add(jcb);
	       // w.add(h);
	        //w.add(d8);
	        
	   	  ResultSet rs = null;  
		 int i;
		String ii = null;
	        
	        try{
     			//int i=null;
                 Class.forName("com.mysql.jdbc.Driver");
                 System.out.println("JBDC ���سɹ�!");
                 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
                 ps = ct.prepareStatement("SELECT * FROM goods");//3.�������ݿ�
                 rs = ps.executeQuery();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�
                 while (rs.next())
                 {
                 	//i=rs.getString(1);	
                 	 i = Integer.parseInt(rs.getString(1));
                 	i++;
             ii=Integer.toString(i);
                 }
                 
             }catch(Exception a){
                 System.out.println("JBDC gg!");
                 a.printStackTrace();
             }
             d1.setText(ii);
             d1.setEditable(false);
	        
	        
	        huowuaddok ok1=new huowuaddok();
		       bt.addActionListener(ok1);
		       huowuaddre re1=new huowuaddre();
		       bt1.addActionListener(re1);

	        w.add(bt);
	        w.add(bt1);
	             
	             
	}
		  //���ð�ť�¼�
			 class huowuaddre implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					
					d1.setText("");
					d2.setText("");
				
					d3.setText("");
					d5.setText("");
					d6.setText("");
					
				}
				}
		
			 class huowuaddok implements ActionListener {
			
					public void actionPerformed(ActionEvent e) {
						
				
	
							  String sql = "INSERT INTO goods(goodsid,goid,goname,gotype,gonumber,goposition) "
						                + "values(?,?,?,?,?,?)";   //���ݿ����
							
							try{
					            Class.forName("com.mysql.jdbc.Driver");
					            System.out.println("JBDC ���سɹ�!");
					        }catch(Exception a){
					            System.out.println("JBDC gg!");
					            a.printStackTrace();
					        }
					        try{
					            ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root",""); //�������ݿ�
					            ps=ct.prepareStatement(sql);  //�������ݿ�
					             
					            ps.setString(1,d1.getText());
					            ps.setString(2,d2.getText());
					            ps.setString(3,d3.getText()); 
					            ps.setString(4,(String) jcb1.getSelectedItem());
					            ps.setString(5,d5.getText());
					            ps.setString(6,d6.getText()); 
					  

					            ps.executeUpdate();
					             
					            //System.out.println("MySQL ���ӳɹ�!");
					            //stat = conn.createStatement();
					            //stat.executeUpdate(sql);
					            //System.out.println("�������ݳɹ�!");
					            JOptionPane.showMessageDialog(null, "��������Ϣ�ɹ�");
					            b2.doClick();
					            window.dispose();
					                 
					             
					        }catch (SQLException b){
					            b.printStackTrace();     
					         
					        }finally{
					            try{
					                ct.close();
					                System.out.println("MySQL �رճɹ�");
					            }catch (SQLException c){
					                System.out.println("MySQL �ر�ʧ�� ");
					                c.printStackTrace();
					            }
					             
					        }

					}
						
					}
					}
			 
			 
		// TODO Auto-generated method stub

	


