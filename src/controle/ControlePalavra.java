/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import negocio.Palavra;

/**
 *
 * @author vinicius
 */
public class ControlePalavra {
    public boolean salvar(Palavra palavra) {

        // cria arquivo ou acessa arquivo existente
        Arquivo arq = new Arquivo("dicionario.txt");

        // abre para escrita, adicionando ao final = parametro TRUE
        if (arq.abrirEscrita(true)) {

            // String registro que concatena cada atributo da classe com ;       
            String registro = palavra.getCodigo()
                    + ";"
                    + palavra.getTermo()
                    + ";"
                    + palavra.getDefinicao()
                    + ";"
                    + palavra.getFonte();

            arq.escreverLinha(registro);

            // necessario fechar o arquivo para finalizar o processo
            arq.fecharArquivo();

            return true;
        } else {
            return false;
        }
    }

    public String consultar(String palavra) {
        Arquivo arq = new Arquivo("dicionario.txt");

        String retorno = "";
        
        // verifica se e possivel abrir arquivo para leitura
        if (arq.abrirLeitura()) {
            
            if (palavra.isBlank()) {
                String linha = arq.lerLinhas();
                while (linha != null) {
                    retorno = retorno + linha + "\n";

                    linha = arq.lerLinhas();
                }                
            } else {
               String linha = arq.lerLinhas(palavra);
                while (linha != null) {
                    retorno = retorno + linha + "\n";

                    linha = arq.lerLinhas(palavra);
                }  
            }           
            return retorno;
        } else {
            return null;
        }
    }
}
