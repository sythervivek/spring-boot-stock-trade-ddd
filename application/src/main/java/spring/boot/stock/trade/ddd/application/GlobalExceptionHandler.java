package spring.boot.stock.trade.ddd.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import spring.boot.stock.trade.ddd.application.exceptions.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidIdentifierException.class)
    public ResponseEntity<String> handleInvalidIdentifierException(InvalidIdentifierException ex) {
        return new ResponseEntity<String>("{ Error: " + ex.getMessage() +"}", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidOrderQuantityException.class)
    public ResponseEntity<String> handleInvalidOrderQuantityException(InvalidOrderQuantityException ex) {
        return new ResponseEntity<String>("{ Error: " + ex.getMessage() +"}", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidOrderTypeException.class)
    public ResponseEntity<String> handleInvalidOrderTypeException(InvalidOrderTypeException ex) {
        return new ResponseEntity<String>("{ Error: " + ex.getMessage() +"}", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<String> handleOrderNotFoundException(OrderNotFoundException ex) {
        return new ResponseEntity<String>("{ Error: " + ex.getMessage() +"}", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PortfolioNotFoundException.class)
    public ResponseEntity<String> handlePortfolioNotFoundException(PortfolioNotFoundException ex) {
        return new ResponseEntity<String>("{ Error: " + ex.getMessage() +"}", HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(InvalidDataFormatException.class)
    public ResponseEntity<String> handleInvalidPortfolioDataFormatException(InvalidDataFormatException ex) {
        return new ResponseEntity<String>("{ Error: " + ex.getMessage() +"}", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
