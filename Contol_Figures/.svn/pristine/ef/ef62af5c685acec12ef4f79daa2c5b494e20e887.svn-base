package com.mx.totalplay.implement.encriptador;

import java.io.IOException;
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

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;



@SuppressWarnings("unused")
public class AESEncriptador {
    
    private SecretKey key;       
    private Cipher cipher;  
    private String algoritmo= "AES";
    private int keysize=16;
	private final String addkey = "CRMWeb";
    
    public AESEncriptador() {
    }
    
    public AESEncriptador(String as_llave) {
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

     /**
    * Metodo para encriptar un texto
    * @param texto
    * @return String texto encriptado
    */
    public String encriptar( String texto ){
        
        addKey("AclaracionesTotalPlayEnlaceTFE");
        
        String value="";
        try {
            cipher = Cipher.getInstance( algoritmo );             
            cipher.init( Cipher.ENCRYPT_MODE, key );             
            byte[] textobytes = texto.getBytes();
            byte[] cipherbytes = cipher.doFinal( textobytes );
            value = new BASE64Encoder().encode( cipherbytes );
        } catch (NoSuchAlgorithmException ex) {
            System.err.println( ex.getMessage() );
        } catch (NoSuchPaddingException ex) {
            System.err.println( ex.getMessage() );
        } catch (InvalidKeyException ex) {
            System.err.println( ex.getMessage() );
        } catch (IllegalBlockSizeException ex) {
            System.err.println( ex.getMessage() );
        } catch (BadPaddingException ex) {
            System.err.println( ex.getMessage() );
        }
        return value;
    }

     /**
    * Metodo para desencriptar un texto
    * @param texto Texto encriptado
    * @return String texto desencriptado
    */
    public String desencriptar( String texto ){
        
        addKey("AclaracionesTotalPlayEnlaceTFE");
        
        String str="";        
        try {
            byte[] value = new BASE64Decoder().decodeBuffer(texto);                 
            cipher = Cipher.getInstance( algoritmo );            
            cipher.init( Cipher.DECRYPT_MODE, key );
            byte[] cipherbytes = cipher.doFinal( value );
            str = new String( cipherbytes );                                  
        } catch (InvalidKeyException ex) {
            System.err.println( ex.getMessage() );
        }  catch (IllegalBlockSizeException ex) {
            System.err.println( ex.getMessage() );
        } catch (BadPaddingException ex) {
            System.err.println( ex.getMessage() );            
        }   catch (IOException ex) {
            System.err.println( ex.getMessage() );
        }catch (NoSuchAlgorithmException ex) {
            System.err.println( ex.getMessage() );
        } catch (NoSuchPaddingException ex) {
            System.err.println( ex.getMessage() );
        }
        return str;
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
    
    
    public String of_DesencriptarAES128(String as_texto){
        String ls_cadena = "";
        //Llave para la encriptacion
        addKey("userInfo");
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

        
    public String of_EncriptarAES128(String as_texto){
        String ls_cadena = "";
        //Llave para la encriptacion
        addKey("AclaracionesTotalPlayEnlaceTFE");
        
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
    
    public String of_DesencAES128(String as_texto){
        String ls_cadena = "";
        
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
        
    public String of_EncAES128(String as_texto){
        String ls_cadena = "";
        
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
        AESEncriptador  des = new AESEncriptador();
        //System.out.println(des.of_DesencriptarAES128("a2c8c332136ab8e790fe5cab89ac371bf2beefee13c47813682c4bc2cb50ecbb041b401525ab83c989b97cdea8901a435ee4e1589a78b054d237715b8999fdd410b21203552e96f038c4bd1c0455c0d2ada2e822ea48256569003950fb6d753dd7a993ae6ea788d0fbd3696d0f9f2c8f3c6d7eaff392a4c07eeaee5e0cc372b69464e15c93d4ee20c241c8915aeb87ee7dfd864c10c499f5ee006fc06b92ef8710d131820f8f126bc8ef0005ec5feb62"));
        //  System.out.println(des.of_DesencriptarAES128("486aa203cd3d4bb06ac07d1dfcb6954a10b7284315491feecba7f9b92e762ef31b934c427e8f64dd8c4988592cb6a497061ee6d1bf6ab1ef276016402ea4388659c2860387978214c5c31cd8a912b2abc8f15dc0df87a430bb8f487c462f45051b9a45accc75e4a396d46eae8ce842aa"));
        
        
            
    }
}
