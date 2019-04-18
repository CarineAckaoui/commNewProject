import java.io.*;
import java.net.*;

class TCPClient {

	public static void main(String argv[]) throws Exception {
		String sentence;
		String modifiedSentence;
		

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));
		sentence = inFromUser.readLine();

		if (sentence.equals("CONNECT")) {
			System.out.println("SYSTEM CONNECTED");
			while (true) {
				Socket clientSocket = new Socket("172.20.10.13", 6789);
				System.out.println("please type message:" + '\n');
				BufferedReader inFromUser2 = new BufferedReader(
						new InputStreamReader(System.in));
				BufferedReader inFromServer = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));
				DataOutputStream outToServer = new DataOutputStream(
						clientSocket.getOutputStream());

				sentence = inFromUser2.readLine();
				if (sentence.equals("CLOSE")) {
					System.out.println("Server is closed");
					clientSocket.close();
					return;
				}
				else {
						outToServer.writeBytes(sentence + '\n');
						outToServer.flush();
						modifiedSentence = inFromServer.readLine();
						System.out.println("Client 2: " + modifiedSentence);
					}
				}
			}
		}
	}

