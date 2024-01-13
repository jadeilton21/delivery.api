package delivery.api.api.exception;

public class DocumentoDuplicadoException extends RuntimeException{

    private static final long serialVersionUID = 1L;


    public DocumentoDuplicadoException(String exception){
        super(exception);
    }
}
