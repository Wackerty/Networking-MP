/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetworkMP;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author wacke
 */
public class PW1 extends JFrame {   
    public static String password   = "123";
    private int port;
    private String host;
    
    public PW1() {
        JFrame frame = new JFrame("Password");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400,100));
        frame.setLocation(600,300);
        
        JLabel label = new JLabel("Enter password:");
        JPanel panel = new JPanel();
        frame.add(panel);
        
        
        JPasswordField pass = new JPasswordField(10);
        pass.setEchoChar('*');
        pass.addActionListener(new AL());
        
        panel.add(label, BorderLayout.WEST);
        panel.add(pass, BorderLayout.EAST);
    }
    
    static class AL implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
        JPasswordField input = (JPasswordField) e.getSource();
        char[] passy = input.getPassword();
        String p = new String(passy);
        
        int port = 1500;
        String host = "localhost";
                
            if(p.equals(password)){
                JOptionPane.showMessageDialog(null, "WELCOME TO IMPORTANTES GROUPES");
                new GroupChat1(host,port);
                
            }else{
                JOptionPane.showMessageDialog(null,"Please Try Again");
            }
        }
    }

}
