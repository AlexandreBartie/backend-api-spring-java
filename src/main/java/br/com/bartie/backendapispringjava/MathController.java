package br.com.bartie.backendapispringjava;

import br.com.bartie.exceptions.UnsupportedMathOperationException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double Sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo)

            throws Exception {

                if (isValidParameters(numberOne, numberTwo))
                return convertToDouble(numberOne) - convertToDouble(numberTwo);
    
            throw new UnsupportedMathOperationException(getWarning());
    }

    @RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double Subtract(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo)

            throws Exception {

        if (isValidParameters(numberOne, numberTwo))
            return convertToDouble(numberOne) - convertToDouble(numberTwo);

        throw new UnsupportedMathOperationException(getWarning());

    }

    private boolean isValidParameters(String numberOne, String numberTwo)
    { return (isNumeric(numberOne) && isNumeric(numberTwo)); }

    private Double convertToDouble(String strNumber) {
        if (isNumeric(strNumber)) {
            String number = formatNumber(strNumber);
            if (isNumeric(number))
                return Double.parseDouble(number);
        }
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null)
            return false;
        String number = formatNumber(strNumber);
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private String formatNumber(String strNumber) {
        return strNumber.replace(',', '.');
    }

    private String getWarning() {
        return "Please set only numeric values!";
    }

}
