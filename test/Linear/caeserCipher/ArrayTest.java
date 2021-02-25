package Linear.caeserCipher;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ArrayTest {
    CaeserCipher cipher;

    @BeforeEach
    void setUp() {
        cipher = new CaeserCipher(3);
    }

    @AfterEach
    void tearDown() {
        cipher = null;
    }

    @Test
    void encoder_characterArrayCanBeGetAfterObjectConstruction(){
        assertNotNull(cipher.getEncoder());
    }

    @Test
    void decoder_characterArrayCanBeGetAfterObjectConstruction(){
        assertNotNull(cipher.getDecoder());
    }

    @Test
    void plainText_canBeDecrypted(){
        String name = "THE EAGLE IS IN PLAY; MEET AT JOE’S";
        String decryptedString = cipher.decrypt(name);
        assertEquals("WKH HDJOH LV LQ SODB; PHHW DW MRH’V", decryptedString);
    }

    @Test
    void cipher_canBeEncrypted(){
        String name = "THE EAGLE IS IN PLAY; MEET AT JOE’S";
        String decryptedString = cipher.decrypt(name);
        String encryptedString = cipher.encrypt(decryptedString);
        assertEquals(name, encryptedString);
    }
}