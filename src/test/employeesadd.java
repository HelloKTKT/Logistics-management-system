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



public class employeesadd extends employees implements ActionListener {

	
	private Connection ct = null;  
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  

    private JLabel a = new JLabel("����Ա�����");
    private JLabel b1 = new JLabel("Ա������");
    private JLabel c = new JLabel("Ա������");
    private JLabel d = new JLabel("����һ������");
    private JLabel e1 = new JLabel("�Ա�");
    private JLabel f = new JLabel("��������");
    private JLabel g = new JLabel("��ϵ��ַ");
    private JLabel h = new JLabel("��ϵ�绰");

    private JTextField d1=new JTextField();
    private JTextField d2=new JTextField();
    private JTextField d3=new JTextField();
    private JTextField d4=new JTextField();
    private JTextField d5=new JTextField();

    private JComboBox jcb=new JComboBox();
    //private JTextField d7=new JTextField();
    private JTextField d7=new JTextField(); 
    private JTextField d8=new JTextField();
 

    private JButton bt = new JButton("���");
    private JButton bt1 = new JButton("����");


	@Override
	public void actionPerformed(ActionEvent e) {
		
   
       
        
     //�������
        JFrame window=new JFrame();
        JPanel w=new JPanel();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String str1[] = {"��", "Ů"};  
        jcb = new JComboBox(str1);  
        try{
     			//int i=null;
                 Class.forName("com.mysql.jdbc.Driver");
                 System.out.println("JBDC ���سɹ�!");
                 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
                 ps = ct.prepareStatement("SELECT * FROM manager");//3.�������ݿ�
                 rs = ps.executeQuery();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�
      
             }catch(Exception a){
                 System.out.println("JBDC gg!");
                 a.printStackTrace();
             }
           
           
        
        w.setLayout(new GridLayout(12,2));
        window.setTitle("���Ա����Ϣ");
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
        w.add(e1); 
        w.add(jcb);  
        w.add(f);
        w.add(d5);
        w.add(g);
        w.add(d7);
        w.add(h);
        w.add(d8); 
        
     
       
  
     
        
        dingdanaddok ok1=new dingdanaddok();
	       bt.addActionListener(ok1);
	       dingdanaddre re1=new dingdanaddre();
	       bt1.addActionListener(re1);

        w.add(bt);
        w.add(bt1);
             
             
}
	  //���ð�ť�¼�
		public class dingdanaddre implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				d1.setText("");
				d2.setText("");
				d3.setText("");
				d4.setText("");
				d5.setText("");
			
				d7.setText("");
				d8.setText("");
			
			
				
			}
			}
	
	
	
	
      //��Ӱ�ť�¼�����������ݲ��������
	public class dingdanaddok implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			  String sql = "INSERT INTO manager(mid,mname,mcode,msex,mbirthday,maddress,mnumber) "
		                + "values(?,?,?,?,?,?,?)";   //���ݿ����
			  

			if(!d3.getText().equals(d4.getText()))
			{
				JOptionPane.showMessageDialog(null, "�������벻һ��", "���ʧ��", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			  
			  
			  
			  
			try{
				//int i=null;
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
	           // ps.setLong(1,i);
	            ps.setString(2,d2.getText());
	            ps.setString(3,d3.getText());
	            //ps.setString(,d4.getText());
	            ps.setString(5,d5.getText());
	            
	            ps.setString(6,d7.getText()); 
	            ps.setString(7,d8.getText());
	            
	            ps.setString(4,(String) jcb.getSelectedItem());
	      
	            
	            //1 2 3 4 5 6 7 8����������������������

	            ps.executeUpdate();
	             
	            //System.out.println("MySQL ���ӳɹ�!");
	            //stat = conn.createStatement();
	            //stat.executeUpdate(sql);
	            //System.out.println("�������ݳɹ�!");
	            JOptionPane.showMessageDialog(null, "��ӳɹ�");
	            
	            
	            b8.doClick();
	            
	                 
	             
	        }catch (SQLException b){
	            b.printStackTrace();     
	            JOptionPane.showMessageDialog(null, "���������ظ�������", "���ʧ��", JOptionPane.ERROR_MESSAGE);
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
        
        

	





