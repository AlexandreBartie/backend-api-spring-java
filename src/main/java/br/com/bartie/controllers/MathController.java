package br.com.bartie.controllers;

import br.com.bartie.converters.NumberConverter;
import br.com.bartie.exceptions.UnsupportedMathOperationException;
import br.com.bartie.math.SimpleMatch;

// import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

//    private final AtomicLong counter = new AtomicLong();

    private SimpleMatch math = new SimpleMatch();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double Sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo)

            throws Exception {

                if (math.isValid(numberOne, numberTwo))
                return math.sum(NumberConverter.toDouble(numberOne), NumberConverter.toDouble(numberTwo));
    
            throw new UnsupportedMathOperationException(getWarning());
    }

    @RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double Subtract(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo)

            throws Exception {

        if (math.isValid(numberOne, numberTwo))
            return math.subtract(NumberConverter.toDouble(numberOne), NumberConverter.toDouble(numberTwo));

        throw new UnsupportedMathOperationException(getWarning());

    }

    @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double Multiply(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo)

            throws Exception {

        if (math.isValid(numberOne, numberTwo))
            return math.multiply(NumberConverter.toDouble(numberOne), NumberConverter.toDouble(numberTwo));

        throw new UnsupportedMathOperationException(getWarning());

    }

    @RequestMapping(value = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double Divide(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo)

            throws Exception {

        if (math.isValid(numberOne, numberTwo))
            return math.divide(NumberConverter.toDouble(numberOne), NumberConverter.toDouble(numberTwo));

        throw new UnsupportedMathOperationException(getWarning());

    }

    private String getWarning() {
        return "Please set only numeric values!";
    }

}
