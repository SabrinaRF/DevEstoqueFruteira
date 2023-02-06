package devestoquefruteira.DevEstoqueFruteira;
/**
 * Classe do Produto com o construtor, atributos e métodos básicos
 * @author Sabrina Rodrigues Fernandes 
 */    
public class Produto {
    private static int codigoGeral = 0;
    private final int codigo;
    private String nome;
    private String descricao;
   private double quantidade;
    double preco;
    private Object produto;
    //private String categoria;
   double precoPorkg;
   int precoUnidade;
    
    
    //aqui tambem

    /**
     * Construtor da Classe Produto, código gerado altomaticamente.
     * @param nome Nome do produto
     * @param descricao Descrição do produto
     * @param quantidade Quantidade do produto
     * @param preco Preço do produto
     * @throws java.lang.Exception
     */
    public Produto(String nome, String descricao,  double preco,double quantidade) throws Exception{
        if(nome.equals("")){
            throw new Exception ("Nome obrigatório, preencha o campo!");
        }else if(descricao.equals("")){
            throw new Exception ("Descição obrigatória, preencha o campo!");     
        }else if(preco<=0.0){
            throw new Exception ("Preço inválido, insira um preço acima de 0.0!");
        }else{
            this.codigo=codigoGeral++;
            this.nome= nome;
            this.descricao=descricao;
           this.quantidade=quantidade;
            this.preco=preco; 
            
        }     
    
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
    
    //abstrato
    public double getQuantidade(){
        return quantidade;
    }
    
    //abstrato
    public  void setQuantidade(double quantidade)throws Exception{
        this.quantidade=quantidade;
    }
    
    
    
    //return quantidade;
        
    
       // return   quantidade;}
    /**
     * Captura o preço do produto.
     * @return preco capturado.
     */
    public double getPreco(){return preco;}

    /**
     * Altera o nome do produto.
     * @param nome Nome do produto a ser alterado.
     */
    public void setNome(String nome) throws Exception{
        if(nome.equals("")){
            throw new Exception ("Nome obrigatório, preencha o campo!");
        }else{
            this.nome=nome;
        }
    }
     /**
     * Altera o descrição do produto.
     * @param descricao Descrição do produto a ser alterado.
     */
    public void setDescricao(String descricao) throws Exception{
        if(descricao.equals("")){
            throw new Exception ("Descição obrigatória, preencha o campo!");
        }else{
            this.descricao=descricao;
        }
    }
    /**
     * Altera a quantidade do produto.
     * @param quantidade Quantidade do produto a ser alterado.
     * @throws java.lang.Exception Lança exceção quando a quantidade for menor ou igual a zero.
     */
    
     /**
     * Altera o preço do produto.
     * @param preco Preço do produto a ser alterado.
     */
    public void setPreco(double preco) throws Exception{
        if(preco>0.0){
            this.preco=preco;
        }else{
            throw new Exception ("Preço inválido, insira um preço acima de 0.0!");
        }
    }

    
    
   /* public double calcularPreco(){
    
    }*/
  

    
    
   
    public double getPrecoPorKg(){
    return precoPorkg;
    }
    
    public int getPrecoPorUnidade(){
    return precoUnidade;
    }
    
    
    
    /**
     * Captura o código, nome, descrição, quantidade e preço do produto.
     * @return codigo, nome, descricao, quantidade, preco capturado.
     */
     public String toString (){
        return " Código: "+codigo+"| Nome: "+nome+"| Descrição: "+ descricao +"| Quantidade:" +quantidade+"| Preço: "+preco+" ";
    }

}
