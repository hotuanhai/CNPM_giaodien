
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
//
import view.user.UserView;

public class UserListener implements ActionListener{
    private UserView uv;
   // private UserInputFile uif;
    //public UserListener(UserInputFile uif){
    //    this.uif = uif;
   // }
    public UserListener( UserView uv){
        this.uv=uv;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        
          if (src.equals("Exit")) {
			//this.menuExampleView.setTextJLabel("Ban da click JmenuItem EXIT");
			System.exit(0);
		} else if (src.equals("Hộ khẩu")) {
			this.uv.setTextJLabel("Ban da click JmenuItem WELCOME");
		} else if (src.equals("Nhân khẩu")) {
			this.uv.innhankhau();
		} else if (src.equals("Tạm trú")) {
			this.uv.setTextJLabel("Ban da click JmenuItem WINDOW");
		}else if (src.equals("Tạm vắng")) {
			this.uv.setTextJLabel("Ban da click JmenuItem WINDOW1");
		}
        
    }
    
}
