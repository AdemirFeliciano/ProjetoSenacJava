
package projetosenac;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class ProjetoSenac {

    public static void main(String[] args) throws IOException, FileNotFoundException, InvalidFormatException {
        Interessado interessado = new Interessado("Ademir Feliciano Barbosa", "1234", "2018/1938484", "Hospital");
        Empresa[] empresa = new Empresa[3];
        
        empresa[0] = new Empresa("EmpresaA", interessado, LocalDate.of(1977, 12, 05), LocalDate.of(1978, 01, 18), true);
        empresa[1] = new Empresa("EmpresaB", interessado, LocalDate.of(1978, 01, 25), LocalDate.of(1978, 05, 19), false);
        empresa[2] = new Empresa("EmpresaC", interessado, LocalDate.of(1979, 03, 21), LocalDate.of(1980, 11, 17), false);
        
        interessado.somaDias(empresa);
        
        DespachoAverbacao despach = new DespachoAverbacao();
        despach.Averbacao(interessado, empresa);
        ResenhaAverbacao res = new ResenhaAverbacao();
        res.resenha(interessado, empresa);
       
        
    }
    
}
