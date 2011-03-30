/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author leonardo
 */
public interface Mensageiro extends Remote {

    public abstract void enviarMensagem(String mensagem) throws RemoteException;
    public abstract String obterMensagem() throws RemoteException;
    
}
