package Linear.caeserCipher;

public class CaeserCipher {
    private final char[] encoder = new char[26];
    private final char[] decoder = new char[26];

    public CaeserCipher(int rotation) {
       for(int count = 0; count < encoder.length; count++){
           encoder[count] = (char) ('A' + (count + rotation) % 26);
           decoder[count] = (char) ('A' + (count - rotation + 26) % 26);
       }
    }

    public char[] getEncoder(){
        return encoder;
    }

    public char[] getDecoder(){
        return decoder;
    }

    public String decrypt(String secret) {
        return transform(secret, decoder);
    }


    public String encrypt(String message) {
        return transform(message, encoder);
    }

    private String transform(String secret, char[] code) {
        char[] message = secret.toCharArray();
        for(int count = 0; count < message.length; count++){
            if(Character.isUpperCase(message[count])){
                int counter = message[count] - 'A';
                message[count] = code[counter];
            }
        }
        return new String(message);
    }
}
