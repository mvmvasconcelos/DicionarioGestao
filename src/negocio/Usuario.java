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
public class Usuario {
    
    private String nomeUser;
    private String loginUser;
    private String senhaUser;
    private String enderecoUser;
    private String telefoneUser;
    private String dataNascUser;
    
    public Usuario(String n, String l, String s, String e, String t, String d){
        this.nomeUser = n;
        this.loginUser = l;
        this.senhaUser = s;
        this.enderecoUser = e;
        this.telefoneUser = t;
        this.dataNascUser = d;        
    }
    
    public void setNomeUser(String n){
        this.nomeUser = n;
    }
    
    public void setLoginUser(String l){
        this.loginUser = l;
    }
    
    public void setSenhaUser(String s){
        this.senhaUser = s;
    }
    
    public void setEnderecoUser(String e){
        this.enderecoUser = e;
    }
    
    public void setTelefoneUser(String t){
        this.telefoneUser = t;
    }
    
    public void setDataNascUser(String d){
        this.dataNascUser = d;
    }
    
    public String getNomeUser(){
        return nomeUser;
    }
    
    public String getLoginUser(){
        return loginUser;
    }
    
    public String getSenhaUser(){
        return senhaUser;
    }
    
    public String getEnderecoUser(){
        return enderecoUser;
    }
    
    public String getTelefoneUser(){
        return telefoneUser;
    }
    
    public String getDataNascUser(){
        return dataNascUser;
    }
    
}
