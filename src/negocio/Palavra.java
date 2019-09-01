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
    private String significado;
    private String fonte;
    
    public Palavra(String t, String s, String f){
        this.termo = t;
        this.significado = s;
        this.fonte = f;
    }
    
    public void setTermo(String t){
        this.termo = t;
    }
    
    public String getTermo(){
        return termo;
    }
    public void setSignificado(String s){
        this.significado = s;
    }
    
    public String getSignificado(){
        return significado;
    }
    public void setFonte(String f){
        this.fonte = f;
    }
    
    public String getFonte(){
        return fonte;
    }
    
}
