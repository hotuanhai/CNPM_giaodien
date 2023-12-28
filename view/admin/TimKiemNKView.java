
package view.admin;
import java.lang.String;
import controller.AdminListener;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.NhanKhau;

public class TimKiemNKView extends JFrame{
    private JTextField nameField;
    private JTextField idField;
    private JTextField mahkField;
    private JTextField ageFromField;
    private JTextField ageToField;
    
    public TimKiemNKView(){
        this.setSize(700, 700);
	//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
        Font font = new Font("Arial", Font.BOLD, 20);
        
        JLabel nameLabel = new JLabel("Ten");
        nameLabel.setFont(font);
        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(font);
        JLabel mahkLabel = new JLabel("Ma ho khau");
        mahkLabel.setFont(font);
        JLabel agefromLabel = new JLabel("Tuoi tu:");
        agefromLabel.setFont(font);
        JLabel agetoLabel = new JLabel("Den:");
        agetoLabel.setFont(font);
        
        nameField = new JTextField(50);
        nameField.setFont(font);
        idField = new JTextField(50);
        idField.setFont(font);
        mahkField = new JTextField(50);
        mahkField.setFont(font);
        ageFromField = new JTextField(50);
        ageFromField.setFont(font);
        ageToField = new JTextField(50);
        ageToField.setFont(font);
        
        ActionListener ac = new AdminListener(this);
        JButton jb = new JButton("Tìm kiếm");
        jb.setFont(font);
        jb.addActionListener(ac);
        
        JPanel jPanelIO = new JPanel();
        jPanelIO.setLayout(new GridLayout(3, 4, 2, 10));
        jPanelIO.add(nameLabel); jPanelIO.add(nameField); 
        jPanelIO.add(idLabel); jPanelIO.add(idField); 
        
        jPanelIO.add(agefromLabel); jPanelIO.add(ageFromField); 
        jPanelIO.add(agetoLabel); jPanelIO.add(ageToField);
        
        jPanelIO.add(mahkLabel); jPanelIO.add(mahkField); 
        jPanelIO.add(jb);
        
        this.setLayout(new BorderLayout(10, 10));
        this.add(jPanelIO, BorderLayout.NORTH);
        
        this.setVisible(true);      
    }
    
    public void timkiem(){
        String idText = idField.getText();
        String mahk = mahkField.getText();
        String name = nameField.getText();
        String ageFromText = ageFromField.getText();
        String ageToText = ageToField.getText();
        
         int id = isEmpty(idText) ? -1 : Integer.parseInt(idText);
         int ageFrom = isEmpty(ageFromText) ? -1 : Integer.parseInt(ageFromText);
         int ageTo = isEmpty(ageToText) ? -1 : Integer.parseInt(ageToText);
         
         System.out.println(mahk +" "+ name +" "+id+" "+ageFrom + " "+ ageTo);

    }
    private boolean isEmpty(String value) {
    return value == null || value.trim().isEmpty();
}
}
