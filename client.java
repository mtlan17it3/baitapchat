package chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class client {
	public static void main(String args[]){
		try {
			Socket s = new Socket("localhost", 8014);
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = "", str2 = "";
			while (!str.equals("stop")) {
				str = br.readLine();
				dout.writeUTF(str);
				dout.flush();
				str2 = din.readUTF();
				System.out.println("Server says: " + str2);
				dout.close();
				s.close();}
			} catch (Exception e) {
			// TODO: handle exception
				System.out.println(e.getMessage());
		}
	}
}

