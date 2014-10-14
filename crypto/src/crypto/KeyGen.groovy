package crypto


import java.io.UnsupportedEncodingException;
import java.security.*
import javax.crypto.*
import org.apache.commons.codec.binary.*


class KeyGen {
	private SecretKey key;
	private Cipher ecipher;
	private Cipher dcipher;
	private static KeyGen keyGen;
	private entype = "AES"
 
	private KeyGen() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException{
		key = KeyGenerator.getInstance(entype).generateKey();
		ecipher = Cipher.getInstance(entype);
		dcipher = Cipher.getInstance(entype);
		ecipher.init(Cipher.ENCRYPT_MODE, key);
		dcipher.init(Cipher.DECRYPT_MODE, key);
	}
 
	public static KeyGen getInstance() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
		if(keyGen == null) {
			keyGen = new KeyGen();
		}
		return keyGen;
	}
 
	public String encrypt(String str) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
		byte[] utf8 = str.getBytes("UTF8");
		byte[] enc = ecipher.doFinal(utf8);
		byte[] encodedBytes = Base64.encodeBase64(str.getBytes());
 		return new String(encodedBytes);
	}
 
	public String decrypt(String str) throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		byte[] decodedBytes = Base64.decodeBase64(str);
		return new String(decodedBytes, "UTF8");
	}
 


}
