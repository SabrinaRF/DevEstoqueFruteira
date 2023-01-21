package trabalhoag3.TrabalhoAG3.Execoes;

public class CodigoInvalidoException extends RuntimeException {

    public CodigoInvalidoException (){
        super("Código inválido, insira outro!");
    }
}
