
package projetosenac;

import java.io.File;

public class CriaPasta {
    
    public void criaPasta(){
        boolean criaPasta = new File("c://App").mkdirs();
        
    }
    
    public void criaPastaDespacho(){
        criaPasta();
        boolean criaPasta = new File("c://App//Despacho Averbação").mkdirs();
    }
    
    public void criaPastaResenha(){
        criaPasta();
        boolean criaPasta = new File("c://App//Resenha Averbação").mkdirs();
    }
}
