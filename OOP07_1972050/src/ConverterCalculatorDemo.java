/**
 * @author agung 1972050
 */
public class ConverterCalculatorDemo {
    public static void main(String[] args) {
        ConverterCalculator cvc=new ConverterCalculator();
        int number=20000;
        System.out.println(cvc.convertToBinary(number));
        System.out.println(cvc.convertToHexa(number));
        System.out.println(cvc.convertToOctal(number));
        System.out.println(cvc.convertHexaToDecimal("FF"));
        System.out.println(cvc.convertHexaToDecimal("256a"));
        System.out.println(cvc.convertBinerToDecimal("1112"));
        System.out.println(cvc.convertBinerToDecimal("110011001111"));
    }
}
