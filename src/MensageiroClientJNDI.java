import java.rmi.RemoteException;   
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
  
public class MensageiroClientJNDI {   
  
    public static void main( String args[] ) {   
        try {
            //Mensageiro m = (Mensageiro) Naming.lookup( "rmi://localhost:10001/MensageiroService" );   
            
            
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
            env.put(Context.PROVIDER_URL, "rmi://localhost:8686"); // exemplo com glassfish
            InitialContext ic = new InitialContext(env);
            
            Mensageiro m = (Mensageiro) ic.lookup("MensageiroService");

            
            while (true) {
                
                System.out.println( m.obterMensagem() );   
                m.enviarMensagem( "tempo = " + System.currentTimeMillis() );   
                System.out.println( m.obterMensagem() );   
                
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MensageiroClientJNDI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(MensageiroClientJNDI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(MensageiroClientJNDI.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }   
}  
