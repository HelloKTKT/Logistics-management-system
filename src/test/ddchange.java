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


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


//��Ҫ�޸ĵĶ����Ƚ��в�ѯȷ�Ϻ��ٽ����޸�
public class ddchange extends ddxx implements ActionListener {
	
	
	private Connection ct = null;  
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  
	
    protected static TextField t1=new TextField();
    protected static TextField t2=new TextField();
    protected static TextField t3=new TextField();
    protected static TextField t4=new TextField();
    protected static TextField t5=new TextField();
    protected static TextField t6=new TextField();
    protected static TextField t7=new TextField();
    protected static TextField t8=new TextField();
    protected static TextField t9=new TextField();
    protected static TextField t10=new TextField();
    protected static TextField t11=new TextField();
    protected static TextField t12=new TextField(); 
    static String str1[] = {"�ѳ���", "δ����","������"};  
    protected static JComboBox t13=new JComboBox(str1);
    protected static TextField t14=new TextField();
    
    protected JFrame jr=null;
    
	//JComboBox t10=new JComboBox(str1);

	@Override
	public void actionPerformed(ActionEvent e) {
		rn=-1;
		rn = jt.getSelectedRow();

	    if(rn == -1) {  
            JOptionPane.showMessageDialog(null, "��ѡ��һ��");  
            return ;  
        }  		
	    String id = (String) jt.getValueAt(rn, 0);
        rn = jt.getSelectedRow();
        JFrame jr=new JFrame("������޸�");
      jr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel jl1=new JLabel("�������");
        JLabel jl2=new JLabel("��Ʒ����");
        JLabel jl3=new JLabel("������");
        JLabel jl4=new JLabel("��������");
        JLabel jl5=new JLabel("����������");
        JLabel jl6=new JLabel("�ͻ����");
        JLabel jl7=new JLabel("�ջ���");
        JLabel jl8=new JLabel("�ջ���ַ");
        JLabel jl9=new JLabel("�ջ��˵绰");
        JLabel jl10=new JLabel("��������");
        JLabel jl11=new JLabel("˾�����");
        JLabel jl12=new JLabel("������");
        JLabel jl13=new JLabel("����״̬");
        JLabel jl14=new JLabel("Ŀǰλ��");

		JButton changeok=new JButton("�޸����");
		JButton carop=new JButton("ѡ�����");
		JButton goodsop=new JButton("ѡ�����");

		 
		 //jr.setDefaultCloseOperation(jr.EXIT_ON_CLOSE);
		 //jr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       JPanel jl=new JPanel();
	       jr.setSize(500,400);
	       jr.setVisible(false);
	       jr.setVisible(true);
	       t1.setEditable(false);
	       
	       t1.setEditable(false);
	       t2.setEditable(false);
	       t3.setEditable(false);
	       t4.setEditable(false);
	       t5.setEditable(false);
	       t6.setEditable(false);
	       t7.setEditable(false);
	       t8.setEditable(false);
	       t9.setEditable(false);
	       t14.setEditable(false);
      
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

            ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
            ps = ct.prepareStatement("SELECT * FROM orders");//3.�������ݿ�
            rs = ps.executeQuery();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�
            int ak=0;
           while (rs.next())
            { 
        	  
        	  
                if (rs.getString(1).equals(id))
                {
                	
                	t1.setText(rs.getString(1));
                    //t1.setText(rs.getString(2));
                    t2.setText(rs.getString(2));
                    t3.setText(rs.getString(3));
                    t4.setText(rs.getString(4));
                    t5.setText(rs.getString(5));
                    t6.setText(rs.getString(6));
                    t7.setText(rs.getString(7));
                    t8.setText(rs.getString(8));
                    t9.setText(rs.getString(9));
                    t10.setText(rs.getString(10));
                    t11.setText(rs.getString(11));
                    t12.setText(rs.getString(12));
                    t13.setSelectedItem(rs.getString(13));
                    t14.setText(rs.getString(14));
                    //System.out.println("5050");
                    ak=1;
                    break;
                }
            }
                if(ak==0)
                {
                	 JOptionPane.showMessageDialog(null, "��������ȷ������", "���޴˶���", JOptionPane.ERROR_MESSAGE);	
                	 jr.setVisible(false); 	 
                }
                
            
        
           
        }catch (SQLException e1) {
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
     
       //JFrame jr=new JFrame("������޸�");
      // JPanel jl=new JPanel();
      // jr.setSize(500,400);
      // jr.setVisible(true);
       jl.setLayout(new GridLayout(16,2));
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
       jl.add(jl6);
       jl.add(t6);
       jl.add(jl7);
       jl.add(t7);
       jl.add(jl8);
       jl.add(t8);
       jl.add(jl9);
       jl.add(t9);
       jl.add(jl10);
       jl.add(t10);
       jl.add(jl11);
       jl.add(t11);
       jl.add(jl12);
       jl.add(t12);
       jl.add(jl13);
       jl.add(t13);
       jl.add(jl14);
       jl.add(t14);
       jl.add(carop);
       jl.add(goodsop);
       jl.add(changeok);
       
       ddchangeop ddchangeop=new ddchangeop();
       changeok.addActionListener(ddchangeop);
       ordercarop ordercarop =new ordercarop ();
       carop.addActionListener(ordercarop);
       ordergoodsop ordergoodsop =new ordergoodsop();
       goodsop.addActionListener(ordergoodsop);
       
	   
		// TODO Auto-generated method stub

	}

}
