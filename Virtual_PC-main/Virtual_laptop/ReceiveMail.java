/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Virtual_laptop;

/**
 *
 * @author sangramjithazarika
 */
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.internet.*;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPMessage;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class ReceiveMail {
    
    public ReceiveMail() throws NoSuchProviderException, MessagingException {
        Folder folder = null;
        Store store = null;
        JTextArea display = new JTextArea ( 16, 58 );
        display.setEditable ( false ); // set textArea non-editable
        JScrollPane scroll = new JScrollPane ( display );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

        JFrame frame = new JFrame ();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add (scroll);
        frame.pack ();
        frame.setVisible ( true );
        try 
        {
            Properties properties = new Properties();
            properties.setProperty("mail.store.protocol", "imaps");

            Session session = Session.getDefaultInstance(properties);

            store = session.getStore("imaps");
            store.connect("imap.gmail.com","quickserve751@gmail.com", "Donde07/05");

            folder = store.getFolder("INBOX"); 
            folder.open(Folder.READ_ONLY);
            Message[] messages = folder.getMessages();
            display.append("No of Messages : " + folder.getMessageCount() + "\n");
            display.append("No of Unread Messages : " + folder.getUnreadMessageCount() + "\n");
            display.append(""+messages.length+"\n");
            for (int i=0; i < messages.length;i++) 
            {

                display.append("*****************************************************************************" + "\n");
                display.append("MESSAGE " + (i + 1) + ":" + "\n");
                Message msg =  messages[i];
                display.append("Subject: " + msg.getSubject() + "\n");
                display.append("From: " + msg.getFrom()[0] + "\n");
                display.append("To: "+msg.getAllRecipients()[0] + "\n");
                display.append("Date: "+msg.getReceivedDate() + "\n" + "\n");
//                String contentType = msg.getContentType();
//                String messageContent="";
//
//               
//                if (contentType.contains("text/plain")) {
//                    Object content = msg.getContent();
//                    if (content != null) {
//                        messageContent = content.toString();
//                    }
//                }else if(contentType.contains("text/html")) {
//                    Multipart multiPart = (Multipart) msg.getContent();
//                    int numberOfParts = multiPart.getCount();
//                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
//                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
//                            messageContent = part.getContent().toString();
//                    
//                    }
//                } else if (contentType.contains("multipart")) {
//                    Multipart multiPart = (Multipart) msg.getContent();
//                    int numberOfParts = multiPart.getCount();
//                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
//                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
//                            messageContent = part.getContent().toString();
//                    
//                    }
//                }
//                display.append("Body: " + messageContent.toString() + "\n" + "\n");
            }

        }
        finally 
        {
          if (folder != null && folder.isOpen()) { folder.close(true); }
          if (store != null) { store.close(); }
        }
        //new Email().setVisible(true);
    }

    public static void main(String[] args) throws MessagingException, IOException {
        
        

    }
}