/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author marcus.vasconcelos
 */
public class Palavra {
    
    private String termo;
    private String definicao;
    private String fonte;
    private static int codigo = 0;
    
    public Palavra(String t, String s, String f){
        this.termo = t;
        this.definicao = s;
        this.fonte = f;
    }
    
    public void setTermo(String t){
        this.termo = t;
    }
    
    public String getTermo(){
        return termo;
    }
    public void setDefinicao(String s){
        this.definicao = s;
    }
    
    public String getDefinicao(){
        return definicao;
    }
    public void setFonte(String f){
        this.fonte = f;
    }
    
    public String getFonte(){
        return fonte;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
}
