
package view.admin;

import controller.AdminListener;
import dao.NhanKhauDAO;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import model.NhanKhau;

public class UserInputFile extends JFrame{
    private JButton btn_file;
    public UserInputFile(){
        //this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setTitle("Demo");
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        
       ActionListener ac = new AdminListener(this);
        btn_file = new JButton("Tai file txt");
        btn_file.setFocusable(false);
        btn_file.addActionListener(ac);
        this.add(btn_file);
        
        
        this.setVisible(true);
    }


    public void taifile() throws FileNotFoundException{
        JFileChooser file_upload = new JFileChooser(); 
                //file_upload. showOpenDialog(null);
                //int res = file_upload.showOpenDialog(null); 
        int res_2 = file_upload.showSaveDialog(null);
        if(res_2 == JFileChooser.APPROVE_OPTION) {
        File file_path = new File(file_upload.getSelectedFile().getAbsolutePath()); 
        System.out.println(file_path);
        if (file_path.length() == 3) {

        } else if (file_path.length() > 3) {
            String str = file_path.getName().toString().substring(file_path.getName().toString().length() - 3); 
            System.out.println(str);
            if (!str.equals("txt")){
                System.out.println("not a txt file");
            } else {

            }
        } else {
            throw new IllegalArgumentException("word has fewer than 3 characters!");
          }
        Scanner input = new Scanner(file_path);
        input.useDelimiter(",|\n");
        NhanKhau nk = new NhanKhau();
         while(input.hasNext()){
            nk.setTen(input.next());
            
            String ngaySinhText = input.next();     
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = null;
            try {
            utilDate = dateFormat.parse(ngaySinhText);
            } catch (ParseException ex) {
            Logger.getLogger(InputNhanKhau.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            nk.setNgaySinh(sqlDate); 
             
            nk.setNote(input.next());
            nk.setQuanHe(input.next());
            nk.setMa_hk(input.next());
            nk.setBiDanh(input.next());
            nk.setGioiTinh(input.nextInt());
            nk.setDanToc(input.next());
            nk.setQueQuan(input.next());
            nk.setTonGiao(input.next());
            nk.setNgheNghiep(input.next());
            nk.setNoiLam(input.next());
            nk.setCccd(input.next());
            
            ngaySinhText = input.next();     
            utilDate = null;
            try {
            utilDate = dateFormat.parse(ngaySinhText);
            } catch (ParseException ex) {
            Logger.getLogger(InputNhanKhau.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlDate = new java.sql.Date(utilDate.getTime());
            nk.setNgayCap(sqlDate);
            
            nk.setNoiCap(input.next());
            nk.setNoiTTTruoc(input.next());
            
//            if(input.hasNext()){
//            ngaySinhText = input.next();
//            }
//            else{
//                ngaySinhText ="1111-11-11";
//            }
//                utilDate = null;
//                try {
//                utilDate = dateFormat.parse(ngaySinhText);
//                } catch (ParseException ex) {
//                Logger.getLogger(InputNhanKhau.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                sqlDate = new java.sql.Date(utilDate.getTime());
//                nk.setNgaychuyen(sqlDate);
            
            NhanKhauDAO.getInstance().insert(nk);
         }
        
        }
    }


}