package asiel_project.service;

import javax.ejb.ApplicationException;

@ApplicationException
public class VerblijfVolException extends RuntimeException{

    public VerblijfVolException(String message) {
        super(message);
    }
}
