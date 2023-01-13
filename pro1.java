import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.net.*;
class send
{
    send()
    {
        JFrame f2=new JFrame();
        JButton b3=new JButton(new ImageIcon("folder.png"));
        JButton b4=new JButton(new ImageIcon("send_file.png"));//starts the Server for FTP
        JTextField tf1=new JTextField();
        JTextField tf2=new JTextField();
        JTextField tf3=new JTextField();
        JTextField tf4=new JTextField();
        JLabel l1=new JLabel();
        JLabel l2=new JLabel();
        JLabel l3=new JLabel();
        JLabel l4=new JLabel();
        JLabel l5=new JLabel();
        l5.setBounds(465,430,30,30);
        l4.setBounds(30,300,100,30);
        l3.setBounds(30,260,100,30);
        l2.setBounds(30,220,100,30);
        l1.setBounds(330,220,50,30);
        l1.setText("PORT:");
        l2.setText("LHOST_IP:");
        l3.setText("HostName:");
        l4.setText("FPATH:");
        l1.setFont(new Font("Bold",Font.ITALIC,16));
        l2.setFont(new Font("Bold",Font.ITALIC,16));
        l3.setFont(new Font("Bold",Font.ITALIC,16));
        l4.setFont(new Font("Bold",Font.ITALIC,16));
        tf1.setBounds(380,220,80,30);
        tf2.setBounds(130,220,150,30);
        tf3.setBounds(130,260,250,30);
        tf4.setBounds(130,300,300,40);
        tf1.setBackground(Color.LIGHT_GRAY);
        tf2.setBackground(Color.LIGHT_GRAY);
        tf3.setBackground(Color.LIGHT_GRAY);
        tf4.setBackground(Color.LIGHT_GRAY);
        tf1.setFont(new Font("Bold",Font.PLAIN,18));
        tf2.setFont(new Font("Bold",Font.PLAIN,15));
        tf3.setFont(new Font("Verdana",Font.PLAIN,15));
        tf4.setFont(new Font("Verdana",Font.PLAIN,15));
        tf3.setEditable(false);
        tf2.setEditable(false);
        tf4.setEditable(false);
      try{
            InetAddress ip= InetAddress.getLocalHost();
            tf2.setText(""+ip.getHostAddress());
            tf3.setText(""+ip.getHostName());
        }
        catch(Exception e){System.err.println(e);}
        b3.setBounds(200,70,80,80);
        b3.setBorderPainted(false);
        b4.setBounds(393,380,80,60);
        b4.setBorderPainted(false);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser c1=new JFileChooser();
              int choose=c1.showOpenDialog(null);
              if(choose==0)
              {
                  File file= c1.getSelectedFile();                             //new File(c1.getSelectedFile().getAbsolutePath());
                  tf4.setText(""+file.getAbsolutePath());
              }
            }
        });
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                if(tf1.getText().isEmpty())
                {
                    tf1.setBackground(Color.decode("#F95B07"));
                }
                else{
                try{
                int port=Integer.parseInt(tf1.getText());
                ServerSocket sr=new ServerSocket(port);
                Socket s1=sr.accept();
                   
               // FileReader f1=new FileReader(tf4.getText());
               byte b[]=new byte[10000000];
               FileInputStream f1=new FileInputStream(tf4.getText());
               BufferedInputStream b1=new BufferedInputStream(f1);
               b1.read(b,0,b.length);
               OutputStream oi=s1.getOutputStream();
               oi.write(b,0,b.length);
              //  int data=0;
              //  for(int i=f1.read();i!=-1;i=f1.read())
              //  {
                  //  data=(char)i;
                   // oi.write(data);
              //  }
                f1.close();
                oi.close();
                l5.setIcon(new ImageIcon("checkmark-16.png"));
            }catch(Exception e1){System.out.println(e1);}
        
        }       
            }
        });
        f2.add(b3);
        f2.add(b4);
        f2.add(tf1);
        f2.add(l1);
        f2.add(l2);
        f2.add(l3);
        f2.add(l4);
        f2.add(l5);
        f2.add(tf2);
        f2.add(tf3);
        f2.add(tf4);
        f2.setTitle("SENDER");
        f2.setSize(500,500);
        f2.setLayout(null);
        f2.setVisible(true);

    }
}
class receive
{
    receive()
    {
        JFrame f3 =new JFrame();
        JButton b5=new JButton(new ImageIcon("get.png"));
        JTextField tf5=new JTextField();
        JTextField tf6=new JTextField();
        JTextField tf7=new JTextField();
        JTextField tf8=new JTextField();
        JLabel l6=new JLabel();
        JLabel l7=new JLabel();
        JLabel l8=new JLabel();
        JLabel l9=new JLabel();
        JLabel l10=new JLabel();
        b5.setBounds(393,380,80,60);
        b5.setBorderPainted(false);
        l10.setBounds(210,385,80,50);
        l9.setBounds(20,300,100,30);
        l8.setBounds(20,200,100,30);
        l7.setBounds(20,100,120,30);
        l6.setBounds(307,100,100,30);
        l6.setText("S_PORT:");
        l7.setText("Enter HOST_IP:");
        l8.setText("Enter Path:");
        l9.setText("File Name:");
        l10.setIcon(new ImageIcon("w_tick.png"));
        l6.setFont(new Font("BOLD",Font.ITALIC,16));
        l7.setFont(new Font("BOLD",Font.ITALIC,16));
        l8.setFont(new Font("BOLD",Font.ITALIC,16));
        l9.setFont(new Font("BOLD",Font.ITALIC,16));
        tf5.setBounds(375,100,100,30);
        tf6.setBounds(140,100,150,30);
        tf7.setBounds(110,195,360,40);
        tf8.setBounds(110,295,200,40);
        tf8.setBackground(Color.lightGray);
        tf7.setBackground(Color.lightGray);
        tf6.setBackground(Color.lightGray);
        tf5.setBackground(Color.lightGray);
        tf5.setFont(new Font("BOLD",Font.ITALIC,18));
        tf6.setFont(new Font("BOLD",Font.ITALIC,15));
        tf7.setFont(new Font("Verdana",Font.ITALIC,15));
        tf8.setFont(new Font("Verdana",Font.ITALIC,16));
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(tf5.getText().isEmpty())
                {
                    tf5.setBackground(Color.decode("#F95B07"));
                }
                else
                { try{
                    int port=Integer.parseInt(tf5.getText());
                    Socket s1=new Socket(tf6.getText(),port);
                    InputStream i=s1.getInputStream();
                    String path=tf7.getText()+"/"+tf8.getText();
                  //  FileWriter f1=new FileWriter(path);
                  byte b1[]=new byte[100000000];
                  FileOutputStream f2=new FileOutputStream(path);
                  BufferedOutputStream b2=new BufferedOutputStream(f2);
                  i.read(b1,0,b1.length);
                  b2.write(b1,0,b1.length);
                   // for(int j=i.read();j!=-1;j=i.read())
                    //{
                      //  f1.write((char)j);
                    //}
                    b2.flush();
                    f2.close();
                    i.close();
                    l10.setIcon(new ImageIcon("double-tick.png"));                    
                    }catch(Exception e4){System.out.println(e4);}

                }

            }              
        });
        f3.add(b5);
        f3.add(l6);
        f3.add(l7);
        f3.add(l8);
        f3.add(l9);
        f3.add(l10);
        f3.add(tf5);
        f3.add(tf6);
        f3.add(tf7);
        f3.add(tf8);
        f3.setTitle("RECEIVER");
        f3.setSize(500,500);
        f3.setLayout(null);
        f3.setVisible(true);

    }
}
class pro1
{
    pro1(){
    JFrame tf1=new JFrame();
    tf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    tf1.setTitle("Share it");
    JButton b1=new JButton(new ImageIcon("send.png"));
    JButton b2=new JButton(new ImageIcon("receive.png"));
    JLabel l1=new JLabel();
    l1.setBounds(225,290,100,50);
    b1.setBounds(200,200,100,50);
    b1.setBorderPainted(false);
    tf1.add(b1);
    b2.setBorderPainted(false);
    b2.setBounds(199,250,100,50);
    tf1.add(b2);
    b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            new send();
            l1.setText("please wait...");
            l1.setFont(new Font("Verdana",Font.ITALIC,15));
           
        }
    }); 
    b2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            new receive();
            l1.setText("please wait...");
            l1.setFont(new Font("Verdana",Font.ITALIC,15));
    
        }
    });
    tf1.add(l1);
    tf1.setSize(500,500);
    Container c = tf1.getContentPane();
    c.setBackground(Color.lightGray);
    tf1.setLayout(null);
   tf1.setVisible(true);
  
    }
    public static void main(String[] sanjay)
    {
        new pro1();
    }
}