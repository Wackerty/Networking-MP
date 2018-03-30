/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetworkMP;

/**
 *
 * @author wacke
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GroupChat1 implements ActionListener{

    GroupChat1     mainGUI;
    JFrame      newFrame    = new JFrame("IMPORTANTES GROUPES");
    JButton     sendMessage,sendFile;
    JTextField  messageBox;
    JTextArea   chatBox;
    
    //File Chooser
    JFileChooser File;
    
    
    // the default port number
    private int defaultPort;
    private String defaultHost;
    private int port;
    private String host;
    
    // the Client object
    private GC1 client;
    
    // if it is for connection
    private boolean connected;
    
    
    

    public GroupChat1(String host,int port) {
        
        // Create File Choooser
        
        
        defaultPort = port;
	defaultHost = host;
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.BLUE);
        southPanel.setLayout(new GridBagLayout());
        

        messageBox = new JTextField(30);
        messageBox.requestFocusInWindow();

        sendMessage = new JButton("Send Message");
        sendMessage.addActionListener(this);
        
        sendFile = new JButton("Send File");
        sendFile.addActionListener(this);
        
        
        chatBox = new JTextArea();
        chatBox.setEditable(false);
        chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
        chatBox.setLineWrap(true);

        mainPanel.add(new JScrollPane(chatBox), BorderLayout.CENTER);

        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.LINE_START;
        left.fill = GridBagConstraints.HORIZONTAL;
        left.weightx = 512.0D;
        left.weighty = 1.0D;

        GridBagConstraints right = new GridBagConstraints();
        right.insets = new Insets(0, 10, 0, 0);
        right.anchor = GridBagConstraints.LINE_END;
        right.fill = GridBagConstraints.NONE;
        right.weightx = 1.0D;
        right.weighty = 1.0D;

        southPanel.add(messageBox, left);
        southPanel.add(sendMessage, right);
        southPanel.add(sendFile , right);

        mainPanel.add(BorderLayout.SOUTH, southPanel);

        newFrame.add(mainPanel);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(470, 300);
        newFrame.setLocation(600,300);
        newFrame.setVisible(true);
    }
    void append(String str) {
		chatBox.append(str);
		chatBox.setCaretPosition(chatBox.getText().length() - 1);
    }
    void connectionFailed() {
		      System.out.println("aw");
	}

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
        
        if (o == sendFile) {

        } else if (o == sendMessage){
            chatBox.append("<" + username + ">:  " + messageBox.getText()
                    + "\n");
            messageBox.setText("");
        }
        messageBox.requestFocusInWindow();
    }


    String  username;

}
