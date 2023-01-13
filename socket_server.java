import java.io.*;
import java.net.*;
class socket_server
{
    public static void main(String[] sanjay) throws Exception
    {
        ServerSocket sr=new ServerSocket(9123);
        Socket s=sr.accept();
        FileReader f1=new FileReader("fog.png");
        OutputStream o1=s.getOutputStream();
        int data=0;
        for(int i=f1.read();i!=-1;i=f1.read())
        {
            data=(char)i;
            o1.write(data);
        }
        f1.close();
        o1.close();

    }
}