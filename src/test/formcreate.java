package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class formcreate extends hwadjust implements ActionListener {
	private Connection ct = null;  
    private PreparedStatement ps = null;  
	@Override
	public void actionPerformed(ActionEvent e) {
		String sql = "INSERT INTO form(loid,goodsid,goid,goname,gonumber,carid,goaddress,getaddress,lostate) "
                + "values(?,?,?,?,?,?,?,?,?)";   //���ݿ����
		//String sql2 = "update form, car  set car.carstate=form.lostate, form.carposition=car.carposition where form.carid=car.carid"; 
		String sql3="UPDATE goods SET goposition='"+"������"+"'  WHERE goodsid='"+d2.getText()+"'";
		
		
		
		//String sql5="UPDATE goods car oid='"+"�ڲ�����"+"'  WHERE carid='"+d5.getText()+"'";
	
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
        ps.setString(4,d4.getText());
        ps.setString(5,d5.getText());
        ps.setString(6,d6.getText()); 
        ps.setString(7,d7.getText());
        ps.setString(8,d8.getText());
       
        ps.setString(9,"������"); 


        ps.executeUpdate();
        //ps=ct.prepareStatement(sql2);
        //ps.executeUpdate();
        ps=ct.prepareStatement(sql3);
        ps.executeUpdate();
  
         
        //System.out.println("MySQL ���ӳɹ�!");
        //stat = conn.createStatement();
        //stat.executeUpdate(sql);
        //System.out.println("�������ݳɹ�!");
        JOptionPane.showMessageDialog(null, "��������Ϣ�ɹ�");
        b2.doClick();
     
             
         
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

		// TODO Auto-generated method stub

	}

}
