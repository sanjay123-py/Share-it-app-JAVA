import java.io.*;
import java.net.*;
class socket
{
public static void main(String[] sanjay) throws Exception
{
  Socket sr=new Socket("localhost",9123);
  InputStream s1=sr.getInputStream();
  FileWriter f1=new FileWriter("pink.png");
for(int i=s1.read();i!=-1;i=s1.read())
{
f1.write(i);
}
f1.close();
s1.close();
}
}