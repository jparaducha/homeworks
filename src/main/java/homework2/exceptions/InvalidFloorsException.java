/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2.exceptions;

/**
 * @author Paraducha Juan
 */
public class InvalidFloorsException extends RuntimeException {

    public InvalidFloorsException() {
    }

    public InvalidFloorsException(String message) {
        super(message);
    }
}
