/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptacion;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 *
 * @author jklm2
 */
public class Base64 {
    public String encode(String cadenaSinCodificar){
        String base64encodedString=null;
        try {
		
         // Encode using basic encoder
            base64encodedString = java.util.Base64.getEncoder().encodeToString(
            cadenaSinCodificar.getBytes("utf-8"));
         System.out.println("Base64 Encoded String (Basic) :" + base64encodedString);
		
         

      } catch(UnsupportedEncodingException e) {
         System.out.println("Error :" + e.getMessage());
      }
        return base64encodedString;
    }
    public String decode(String base64encodedString){
        String decodeString =  null;
        try {
         // Decode
         byte[] base64decodedBytes = java.util.Base64.getDecoder().decode(base64encodedString);
	decodeString = new String(base64decodedBytes, "utf-8");
         //System.out.println("Original String: " + decodeString);
         
         base64encodedString = java.util.Base64.getUrlEncoder().encodeToString(
            base64encodedString.getBytes("utf-8"));
         //System.out.println("Base64 Encoded String (URL) :" + base64encodedString);
		
         StringBuilder stringBuilder = new StringBuilder();
		
         for (int i = 0; i < 10; ++i) {
            stringBuilder.append(UUID.randomUUID().toString());
         }
	

      } catch(UnsupportedEncodingException e) {
         System.out.println("Error :" + e.getMessage());
      }
        return decodeString;
    }
}
