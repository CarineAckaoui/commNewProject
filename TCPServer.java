
import java.io.*; 
import java.net.*; 

class TCPServer { 

  public static void main(String argv[]) throws Exception 
    { 
      String clientSentence; 
      String user2; 

      ServerSocket welcomeSocket = new ServerSocket(6789); 

      while(true) { 
  
            Socket connectionSocket = welcomeSocket.accept(); 

           BufferedReader inFromClient = 
              new BufferedReader(new
              InputStreamReader(connectionSocket.getInputStream())); 
           DataOutputStream  outToClient = 
                   new DataOutputStream(connectionSocket.getOutputStream()); 

                 clientSentence = inFromClient.readLine(); 
                 if(clientSentence!= null){
                 System.out.println("Client 1: "+ clientSentence );
                 System.out.println("please type repley:");
                 BufferedReader client2 = new BufferedReader(
 						new InputStreamReader(System.in));
                 user2= client2.readLine();
                 outToClient.writeBytes(user2+'\n');
                 outToClient.flush();
                 }       
              } 
      
          } 
      } 
       
