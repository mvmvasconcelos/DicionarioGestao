/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import negocio.Dicionario;
import negocio.Palavra;

/**
 *
 * @author vinicius
 */
public class ControlePalavra {
    private Dicionario dicionario = new Dicionario();
    Arquivo arq = new Arquivo("dicionario.txt");
    
    public ControlePalavra(){
        montaDicionario();
    }
    
    private void montaDicionario(){ 
        if (arq.abrirLeitura()) {
            //Salva a linha atual em uma string
            String linha = arq.lerLinhas();
            //Cria array para salvar os termos separadamente
            String[] separado;
            //Enquanto houver linhas no arquivo
            while (linha != null){
                //Separa a linha por ; e armazena nas posições do array
                separado = linha.split(";");
                //Adiciona a nova palavra no dicionário
                dicionario.setPalavra(new Palavra(separado[1], separado[2], separado[3]));
                //Lê a próxima linha
                linha = arq.lerLinhas();
            }            
            arq.fecharArquivo();
        }
    }
    
    
    public boolean salvar(Palavra palavra) {
        
        // abre para escrita, adicionando ao final = parametro TRUE
        if (arq.abrirEscrita(true)) {
            dicionario.setPalavra(palavra);
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
            System.out.println("fechou" + dicionario.getPalavra().size());
            return true;
        } else {
            return false;
        }
    }
    
    /**Consulta todos os termos de dicionario
     * 
     * @return - dicionario - Array com todas as palavras
     */
    public Dicionario consultarDicionario(){
        return dicionario;
    }
    
    /**Faz consulta por letra
     * 
     * @param letra - letra recebida no botão
     * @return apenasId - dicionário apenas com os termos da letra especificada
     */
    public Dicionario consultarPorLetra(String letra){
        Dicionario apenasId = new Dicionario();
        for (int i = 0; i < dicionario.getPalavra().size(); i++) {
            if (dicionario.getPalavra().get(i).getTermo().toLowerCase().charAt(0) == letra.toLowerCase().charAt(0)) {
                apenasId.setPalavra(dicionario.getPalavra().get(i));
            }
        }
        return apenasId;
    }
    
    /**Faz a consulta pelo termo pesquisado
     * 
     * @param termo - palavra digitada na pesquisa
     * @return - dicionario com as palavras
     */
    public Dicionario consultarPorTermo(String termo){
        Dicionario resultadoBusca = new Dicionario();
        
        for (int i = 0; i < dicionario.getPalavra().size(); i++) {
            if (dicionario.getPalavra().get(i).getTermo().toLowerCase().contains(termo.toLowerCase()) || dicionario.getPalavra().get(i).getDefinicao().toLowerCase().contains(termo.toLowerCase())) {
                resultadoBusca.setPalavra(dicionario.getPalavra().get(i));
            }
        }
        return resultadoBusca;
    }
    
    public Dicionario consultarPorId(int id){
        Dicionario apenasId = new Dicionario();
        for (int i = 0; i < dicionario.getPalavra().size(); i++) {
            if (dicionario.getPalavra().get(i).getCodigo() == id) {
                apenasId.setPalavra(dicionario.getPalavra().get(i));
            }
        }
        return apenasId;
    }

    public String consultar(String palavra) {
        Arquivo arq = new Arquivo("dicionario.txt");

        String retorno = "";
        
        // verifica se e possivel abrir arquivo para leitura
        if (arq.abrirLeitura()) { 
            String linha = arq.lerLinhas();
            while (linha != null) {
                retorno = retorno + linha + "\n";

                linha = arq.lerLinhas();
            }   
            return retorno;
        } else {
            return null;
        }
    }
}
