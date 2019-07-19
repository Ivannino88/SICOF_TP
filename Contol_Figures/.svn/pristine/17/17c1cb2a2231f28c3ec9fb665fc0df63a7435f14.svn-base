package com.mx.totalplay.implement.encriptador;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


//import com.totalplay.apps.crm.view.utils.CRMPageConstant;
@SuppressWarnings("unused")
public class Encriptador {
	private SecretKey key;       
    private Cipher cipher;  
    private String algoritmo= "AES";
    private int keysize=16;
    
    public Encriptador() {
    }
    
    public Encriptador(String as_llave) {
        addKey(as_llave);
    }
    
    
    /**
    * Crea la Llave para encriptar/desencriptar
    * @param value
    */
    private void addKey( String value ){
        byte[] valuebytes;
        valuebytes = value.getBytes();
        key = new SecretKeySpec( Arrays.copyOf( valuebytes, keysize ) , algoritmo );      
    }

    private String HexToString(byte[] arregloEncriptado) {
        String textoEncriptado = "";
        for (int i = 0; i < arregloEncriptado.length; i++) {
            int aux = arregloEncriptado[i] & 0xff;
            if (aux < 16) {
                textoEncriptado = textoEncriptado.concat("0");
            }
            textoEncriptado = textoEncriptado.concat(Integer.toHexString(aux));
        }
        return textoEncriptado;
    }
    
    private byte[] StringToHex(String encriptado) {
        byte[] enBytes = new byte[encriptado.length() / 2];
        for (int i = 0; i < enBytes.length; i++) {
            int index = i * 2;
            String aux = encriptado.substring(index, index + 2);
            int v = Integer.parseInt(aux, 16);
            enBytes[i] = (byte) v;
        }
        return enBytes;
    }
    
    
    public String of_DesencriptarAES128(String as_texto, String addkey){
        String ls_cadena = "";
        //Llave para la encriptacion
        addKey(addkey);
        try {
            Cipher cipher = Cipher.getInstance(algoritmo);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] original = cipher.doFinal(StringToHex(as_texto));
            ls_cadena = new String(original);
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AESEncriptador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(AESEncriptador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(AESEncriptador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(AESEncriptador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(AESEncriptador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls_cadena;
    }

        
    public String of_EncriptarAES128(String as_texto, String addkey){
        String ls_cadena = "";
        //Llave para la encriptacion
        addKey(addkey);
        
        try {
            Cipher cipher = Cipher.getInstance(algoritmo);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(as_texto.getBytes());
            ls_cadena = HexToString(encrypted);
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AESEncriptador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(AESEncriptador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(AESEncriptador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(AESEncriptador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(AESEncriptador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls_cadena;
    }
    
    public static void main(String[] args) {
    	Encriptador asd = new Encriptador();
    	//System.out.println(asd.of_DesencriptarAES128("4ad78d292e51080994899bf85866c2293ba9c93600fa7332892864f5d5b3a9ab4fdd8d97938d3bda9262c183654cf9cac8982dbb8254efc20cad044ebdfbd62be3f63678c17bb194072a9eeceb91a3da08e117c5b8d2af049575f667bc85dff973fb202fcac9f3e9eb681893f37f6a0fb59a6913ac8527b0400681084ffd359d", "CRMWeb"));
    	
    }

}
