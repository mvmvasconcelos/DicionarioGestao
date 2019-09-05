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
    private int codigo;
    private static int id = 0;
    
    public Palavra(String termo, String definicao, String fonte){
        this.termo = termo;
        this.definicao = definicao;
        this.fonte = fonte;
        this.codigo = id;
        id++;
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
