public class Demo {

    public static int returnSum(int x){
        if (x <= 0) {
            return 0;
        }
        return x + returnSum(x - 1);
    }

    public static String toBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        } else if (decimal == 1) {
            return "1";
        }
        return toBinary(decimal / 2) + (decimal % 2);
    }

    //added this for fun

    public static String wordsToBinary(String words){
        String output = "";
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            output = output+(toBinary((int)c)+" ");
        }
        return output;
    }

    private static int toDecimalHelper(int binary, int exponent) {
        if (binary == 0) {
            return 0;
        }
        int bit = binary % 10;
        return bit * (int)Math.pow(2, exponent) + toDecimalHelper(binary / 10, exponent + 1);
    }

    public static String binaryToWords(String binary){
        String output = "";
        String[] words = binary.split(" ");
        for (int i = 0; i < words.length; i++) {
            int n = toDecimalHelper(Integer.parseInt(words[i]), 0);
            output = output+((char)n);
        }
        return output;
    }

    //final output

    public static void main(String[] args) {
        System.out.println("Return Sum: "+returnSum(8));
        System.out.println("Binary: "+toBinary(128));
        System.out.println("Words To Binary: "+wordsToBinary("Hello World!"));
        System.out.println("Binary To Words: "+binaryToWords(wordsToBinary("Hello World!")));
    }
}
