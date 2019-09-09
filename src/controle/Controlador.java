/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.swing.JOptionPane;
import negocio.Dicionario;
import negocio.Palavra;
/**
 *
 * @author marcus.vasconcelos
 */
public class Controlador {
    Dicionario dicionarioTemp = new Dicionario();
    static ControlePalavra ctlPalavra = new ControlePalavra();
    
    private final char[] alfabeto = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    
    public char[] getAlfabeto(){
        return alfabeto;
    }
    
    /** Método para cadastrar novo usuário
     * 
     * @param n - nomeUser
     * @param l - loginUser
     * @param s - senhaUser
     * @param e - enderecoUser
     * @param t - telefoneUser
     * @param d - dataNascUser
     */
    public void cadastraUsuario(String n, String l, String s, String e, String t, String d){
        
    }
    
    /** Método para cadastrar nova palavra
     * 
     * @param termo
     * @param definicao
     * @param fonte
     */
    public void cadastraNovaPalavra(String termo, String definicao, String fonte){
        ctlPalavra.salvar(new Palavra(termo, definicao, fonte));
    }
    
    public Dicionario consultarTermo(){        
        dicionarioTemp = ctlPalavra.consultarDicionario();
        if (dicionarioTemp != null) {
            return dicionarioTemp;
        } else {
            JOptionPane.showMessageDialog(null, "Ops, problemas ao LER arquivo!");
            return null;
        }
    }
    
    public Dicionario consultarTermo(int id){        
        dicionarioTemp = ctlPalavra.consultarPorId(id);
        if (dicionarioTemp != null) {
            return dicionarioTemp;
        } else {
            JOptionPane.showMessageDialog(null, "Ops, problemas ao LER arquivo!");
            return null;
        }
    }
    
    public Dicionario consultarTermo(String palavra){
        if (palavra.isBlank()) {
            JOptionPane.showMessageDialog(null, "Nenhum termo digitado");
            return null;

        } else if (palavra.length() == 1) {
            dicionarioTemp = ctlPalavra.consultarPorLetra(palavra);
            System.out.println("Consulta letra");
            if (dicionarioTemp != null) {
                return dicionarioTemp;
            } else {
                JOptionPane.showMessageDialog(null, "Ops, problemas ao LER arquivo!");
                return null;
            }
        } else {
            dicionarioTemp = ctlPalavra.consultarPorTermo(palavra);
            System.out.println("Consulta palavra");
            if (dicionarioTemp != null) {
                return dicionarioTemp;
            } else {
                JOptionPane.showMessageDialog(null, "Ops, problemas ao LER arquivo!");
                return null;
            }
        }
    }   
    
    
    /** Método para validar campos vazios
     * 
     * @param t - conteúdo do campo
     * @return true or false
     */
    public boolean validaVazio(String t){
        try {
            if (t.isBlank() || t.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {            
            return true;
        }
    }
    
    /** Método para validar o acesso. Precisará ser feito algo para buscar o
     * usuário e a senha usando os getters
     * @param l - loginUser
     * @param s - senhaUser
     * @return - true ou false
     */
    public boolean validaAcesso(String l, String s){
        return false;
    }
    
    /** Método para validar termos repetidos
     * 
     * @return 
     */
    public boolean validaRepetido(String termo){
        Dicionario dic = ctlPalavra.consultarPorTermo(termo);
        if (dic.getPalavra().size() >= 0) {
            for (int i = 0; i < dic.getPalavra().size(); i++) {
                if (dic.getPalavra().get(i).getTermo().toLowerCase().equals(termo.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public String mudaPontoEVirgula(String string){        
        return string.replaceAll(";", ",");
    }
}