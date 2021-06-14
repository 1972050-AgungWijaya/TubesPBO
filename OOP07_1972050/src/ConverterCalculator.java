/**
 * @author agung 1972050
 */
public final class ConverterCalculator {
    public String convertToBinary(int number){
        return coreConvertFromDecimal(number,2);
    }
    public String convertToHexa(int number){
        return coreConvertFromDecimal(number,16);
    }
    public String convertToOctal(int number){
        return coreConvertFromDecimal(number,8);
    }
    public String convertBinerToDecimal(String number){
        return coreConvertToDecimal(number,2);
    }
    public String convertHexaToDecimal(String number){
        return coreConvertToDecimal(number,16);
    }

    private static String coreConvertFromDecimal(int number, int radix){
        StringBuilder sb=new StringBuilder();
        int i=0;
        if (radix==2 ||radix==16){
            char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
            while (number>0){
                if (i%5!=0) {
                    sb.insert(i, hexchars[number%radix]);
                    number = number / radix;
                    i+=1;
                }
                else{
                    sb.insert(i, " ");
                    i+=1;
                }
            }
            sb.reverse();
        }
        else {
            while (number > 0) {
                if (i % 4 != 0) {
                    sb.insert(i, number % radix);
                    number = number / radix;
                    i += 1;
                } else {
                    sb.insert(i, " ");
                    i += 1;
                }
            }
            sb.reverse();
        }
        return sb.toString();
    }
    private static String coreConvertToDecimal(String number,int radix){
        StringBuilder sb=new StringBuilder();
        StringBuilder sbn=new StringBuilder();
        sbn.append(number);
        sbn.reverse();
        int hasil=0;
        if (radix==2){
            number=sbn.toString();
            for (int i= 0; i< number.length(); i++) {
                if (number.charAt(i)=='1'){
                    hasil += 1 * Math.pow(radix, i);
                }
                else if (number.charAt(i)=='0'){
                    hasil+=0;
                }
                else{
                    hasil=0;
                    break;
                }
            }
        }
        else {
            char hexchars[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            number=sbn.toString();
            for (int i = 0; i < number.length(); i++) {
                for (int j = 0; j < hexchars.length; j++) {
                    if (number.toUpperCase().charAt(i) == hexchars[j]) {
                        hasil += j * Math.pow(radix, i);
                    }
                }
            }
        }
        sb.append(hasil);
        return sb.toString();
    }
}
