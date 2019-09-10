/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tela.TelaPrincipal;

/**
 *
 * @author vinicius
 */
public class ControleLogin {
    private String usuario = "usuario";
    private String senha = "1234";
    
    public void logar(String user, char[] pass, JFrame j){
        if (usuario.equals(user) && senha.equals(new String(pass))) {
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            telaPrincipal.setVisible(true);
            j.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
        }        
    }
}
