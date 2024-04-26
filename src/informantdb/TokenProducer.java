/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package informantdb;

import java.util.Date;
import org.eclipse.persistence.internal.oxm.conversion.Base64;

/**
 *
 * @author Student
 */
public class TokenProducer {

    static public String produce() throws InterruptedException {

        long miliSeconds = System.currentTimeMillis();
        String miliSecondsStr = String.valueOf(miliSeconds);
        byte i[] = Base64.base64Encode(miliSecondsStr.getBytes());
        StringBuffer converted = new StringBuffer();
        for(var h : i){
            converted.append((char) h);
        }
        Thread.sleep(1);
        return String.valueOf(converted);
    }

}
