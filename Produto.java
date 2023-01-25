
package devestoquefruteira.DevEstoqueFruteira;
/**
=======
 * Classe do Produto com o construtor, atributos e métodos básicos
 * @author Sabrina Rodrigues Fernandes 
 */    
public class Produto {
    private static int codigoGeral = 0;
    private final int codigo;
    private String nome;
    private String descricao;
    private double quantidade;
    private double preco;
    
    
    //aqui tambem

    /**
     * Construtor da Classe Produto, código gerado altomaticamente.
     * @param nome Nome do produto
     * @param descricao Descrição do produto
     * @param quantidade Quantidade do produto
     * @param preco Preço do produto
     */
    public Produto(String nome, String descricao, int quantidade, double preco){
    this.codigo=codigoGeral++;
    this.nome= nome;
    this.descricao=descricao;
    this.quantidade=quantidade;
    this.preco=preco;
    }
    /**
     * Construtor da Classe Produto, sem parametros.
     */
    public Produto (){
    this.codigo=codigoGeral++;
    }
    
    /**
     * Captura o código do produto.
     * @return codigo capturado.
     */
    public int getCodigo(){return codigo;}
    /**
     * Captura o nome do produto.
     * @return nome capturado.
     */
    public String getNome(){return nome;}
    /**
     * Captura o descição do produto.
     * @return descricao capturado.
     */
    public String getDescricao(){return descricao;}
    /**
     * Captura o quantidade do produto.
     * @return quantidade capturado.
     */
    public double getQuantidade(){return quantidade;}
    /**
     * Captura o preço do produto.
     * @return preco capturado.
     */
    public double getPreco(){return preco;}

    /**
     * Altera o nome do produto.
     * @param nome Nome do produto a ser alterado.
     * @throws java.lang.Exception Lança exceção quando o nome for null.
     */
    public void setNome(String nome) throws Exception{//aquui parei
        if(nome == " "){
            this.nome=nome;
        }else{
            throw new Exception ("Nome obrigatório, preencha o campo!");
        }
    }
     /**
     * Altera o descrição do produto.
     * @param descricao Descrição do produto a ser alterado.
     * @throws java.lang.Exception Lança exceção quando a descrição é null.
     */
    public void setDescricao(String descricao)throws Exception{
        if(descricao != null){
            this.descricao=descricao; 
        }else{
            throw new Exception ("Descição obrigatória, preencha o campo!");
        }
        
    }
    /**
     * Altera a quantidade do produto.
     * @param quantidade Quantidade do produto a ser alterado.
     * @throws java.lang.Exception Lança exceção quando a quantidade for menor ou igual a zero.
     */
    public void setQuantidade(double quantidade)throws Exception {
        if(quantidade > 0){
            this.quantidade=quantidade;
        }else{
            throw new Exception("Quantidade inválida, insira um valor maior que 0!");
        }
    }
     /**
     * Altera o preço do produto.
     * @param preco Preço do produto a ser alterado.
     */
    public void setPreco(Double preco)throws Exception{
        if(preco>0.0){
            this.preco=preco;
        }else{
            throw new Exception ("Preço inválido, insira um preço acima de 0.0!");
        }
    }

    /**
     * Captura o código, nome, descrição, quantidade e preço do produto.
     * @return codigo, nome, descricao, quantidade, preco capturado.
     */
    @Override
    public String toString (){
        return " Código: "+codigo+"| Nome: "+nome+"| Descrição: "+ descricao +"| Quantidade:" +quantidade+"| Preço: "+preco+" ";
    }

}
