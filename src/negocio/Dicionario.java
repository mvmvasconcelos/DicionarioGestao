/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;

/**
 *
 * @author marcus.vasconcelos
 */
public class Dicionario {
    private ArrayList<Palavra> listaPalavras = new ArrayList<>();
    
    public void setPalavra(Palavra lista){
        listaPalavras.add(lista);
    }
    
    public ArrayList<Palavra> getPalavra(){
        return listaPalavras;
    }
}
