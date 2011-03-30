
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leonardo
 */
public class MensageiroImpl extends UnicastRemoteObject implements Mensageiro {

    private String mensagem = "mensagem original";

    public MensageiroImpl() throws RemoteException {
    }
    
    @Override
    public void enviarMensagem(String mensagem) throws RemoteException {
        this.mensagem = mensagem;
    }

    @Override
    public String obterMensagem() throws RemoteException {
        return mensagem;
    }

}
