import java.rmi.Naming;   
import java.rmi.RemoteException;   
import java.rmi.NotBoundException;   
import java.net.MalformedURLException;   
  
public class MensageiroClient {   
  
    public static void main( String args[] ) {   
        try {   
            Mensageiro m = (Mensageiro) Naming.lookup( "rmi://localhost:8686/MensageiroService" );   

            System.out.println( m.obterMensagem() );   
            
            while (true) {
                m.enviarMensagem( "tempo = " + System.currentTimeMillis() );   
                System.out.println( m.obterMensagem() );   
                
                Thread.sleep(1000);
            }
            
        }   
        catch( MalformedURLException e ) {   
            System.out.println();   
            System.out.println( "MalformedURLException: " + e.toString() );   
        }   
        catch( RemoteException e ) {   
            System.out.println();   
            System.out.println( "RemoteException: " + e.toString() );   
        }   
        catch( NotBoundException e ) {   
            System.out.println();   
            System.out.println( "NotBoundException: " + e.toString() );   
        }   
        catch( Exception e ) {   
            System.out.println();   
            System.out.println( "Exception: " + e.toString() );   
        }   
    }   
}  
