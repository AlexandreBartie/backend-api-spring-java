package br.com.bartie.backendapispringjava;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bartie.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double Sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value !");

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) {
        if (isNumeric(strNumber)) {
            String number = formatNumber(strNumber);
            if (isNumeric(number))
                return Double.parseDouble(strNumber);
        }
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = formatNumber(strNumber);
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private String formatNumber(String strNumber) {
    return strNumber.replace(',', '.'); }

}
