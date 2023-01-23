package devestoquefruteira.DevEstoqueFruteira;

import java.util.ArrayList;
import java.util.List;
import devestoquefruteira.DevEstoqueFruteira.Execoes.CodigoInvalidoException;
public class EstoqueProduto implements IProduto{

    List<Produto> listaProdutos;

    /**
     * Construtor da Classe EstoqueProduto .
     * @param List Produto p.
     */
    public EstoqueProduto (List<Produto> p){
        this.listaProdutos = p;
    }
     /**
     * Construtor da Classe EstoqueProduto, sem parametro .
     * New no ArrayList.
     */
    public EstoqueProduto (){
        this.listaProdutos = new ArrayList<>();
    }
    
    /**
     * Adiciona um produto no estoque.
     * @param Produto p objeto
     * @throws java.lang.Exception Lança exceção quando o produto não pode ser adicionado.
     */
    @Override
    public void addProduto(Produto p) throws Exception {
        if (p != null) {
            listaProdutos.add(p);
        }else{
            throw new Exception("Produto não pode ser adicionado!");
        }   
    }

    /**
     * Remove o produto da lista, procura atraves do código e ao encontrar o remove da lista.
     * @param código do produto
     * @throws java.lang.Exception Lança exceção quando o produto não pode ser removido, por exemplo, 
     * porque não existe produto cadastrado com o código informado.
     * Utiliza o método da própria classe getProduto.
     */
    @Override 
    public void removeProduto(int codigo) throws Exception { 
        listaProdutos.remove(getProduto(codigo)); 
    }

    /**
     * Captura o Produto de acordo com o código informado.
     * @param código do produto
     * @throws java.lang.Exception Lança exceção quando o produto não pode ser removido, por exemplo, 
     * porque não existe produto cadastrado com o código informado.
     */
    @Override 
    public Produto getProduto(int codigo) throws Exception {
        for(int i=0;i<listaProdutos.size();i++){
            if (listaProdutos.get(i).getCodigo() == codigo ){ 
                return  listaProdutos.get(i) ;
            }
        }
        throw new CodigoInvalidoException();
    }

    /**
     * Altera a quantidade do produto de acordo com o código informado.
     * @param codigo Código do produto a ser alterado.
     * @param nova Nova quantidade do produto.
     * @throws java.lang.Exception Lança exceção quando não existe produto com o 
     * código informado ou quando a nova quantidade é inválida.
     * Procura na lista o produto atraves do código, se achar altera a quantidade com o método
     * setQuantidade.
     */
    @Override
    public void updateQuantidade(int codigo, double nova) throws Exception {
        for(int i=0;i<listaProdutos.size();i++){
            if (listaProdutos.get(i).getCodigo() ==codigo) {
                listaProdutos.get(i).setQuantidade(nova);
            }else{
                throw new CodigoInvalidoException();
            }
        }
        
    }

    /**
     * Altera o preço do produto de acordo com o código informado.
     * @param codigo Código do produto a ser alterado.
     * @param novo Novo preço do produto.
     * @throws java.lang.Exception Lança exceção quando não existe produto com o 
     * código informado ou quando o novo preço é inválida.
     * Procura na lista o produto atraves do código, se achar altera o preço com o método
     * setPreco.
     */
    @Override
    public void updatePreco(int codigo, double novo) throws Exception {
        for(int i=0;i<listaProdutos.size();i++){
            if (listaProdutos.get(i).getPreco() == codigo) {
                listaProdutos.get(i).setPreco(novo);
            }else{
                throw new CodigoInvalidoException();
            }
        }
        
    }

    /**
     * Adiciona uma quantidade do produto de acordo com o código informado.
     * @param codigo Código do produto a ser alterado.
     * @param quantidade Quantidade a ser acrecentada do produto.
     * @throws java.lang.Exception Lança exceção quando não existe produto com o 
     * código informado ou quando a quantidade é inválida.
     */
    @Override
    public void addQuantidade(int codigo, double quantidade) throws Exception {
        for(int i=0;i<listaProdutos.size();i++){
            if (listaProdutos.get(i).getCodigo() ==codigo) {
                double novaQuantidade = (listaProdutos.get(i).getQuantidade())+ quantidade;
                listaProdutos.get(i).setQuantidade(novaQuantidade);
            }else{
                throw new CodigoInvalidoException();
            }
        }
        
    }

    /**
     * Subtrai uma quantidade do produto de acordo com o código informado.
     * @param codigo Código do produto a ser alterado.
     * @param quantidade Quantidade a ser subtraída do produto.
     * @throws java.lang.Exception Lança exceção quando não existe produto com o 
     * código informado ou quando quantidade informada é inválida.
     */
    @Override
    public void subQuantidade(int codigo, double quantidade) throws Exception {
        for(int i=0;i<listaProdutos.size();i++){
            if (listaProdutos.get(i).getCodigo() ==codigo) {
                if(quantidade <= listaProdutos.get(i).getQuantidade()){
                    double novaQuantidade = (listaProdutos.get(i).getQuantidade())-quantidade;              
                    listaProdutos.get(i).setQuantidade(novaQuantidade);
                }else{
                   throw new Exception ("Quantidade inserida é maior que a do estoque!");
                }
            }else{
                throw new CodigoInvalidoException();
            }
        }
    }

    /**
    * Retorna uma String com todos os produtos e seus respectivos dados
    * @return dados Todos os dados da lista de produtos.
    */
    public String toString(){
        String dados="";
        for(Produto v: listaProdutos){
            dados+=v.toString()+"\n";
        }
        return dados;
       
    }
   
}
