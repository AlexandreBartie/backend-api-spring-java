package br.com.bartie.math;

import br.com.bartie.converters.NumberConverter;

public class SimpleMatch {

    public Double sum(Double numberOne, Double numberTwo)
    { return numberOne + numberTwo; }
    
    public Double subtract(Double numberOne, Double numberTwo)
    { return numberOne - numberTwo; }

    public Double multiply(Double numberOne, Double numberTwo)
    { return numberOne * numberTwo; }

    public Double divide(Double numberOne, Double numberTwo)
    { return numberOne / numberTwo; }

    public boolean isValid(String numberOne, String numberTwo)
    { return (NumberConverter.isValid(numberOne) && NumberConverter.isValid(numberTwo)); }

}
