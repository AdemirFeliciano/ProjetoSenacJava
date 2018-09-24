package projetosenac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakClear;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class ResenhaAverbacao {
    public void resenha(Interessado interessado, Empresa empresa[]){
        CriaPasta cria = new CriaPasta();
        cria.criaPastaResenha();
        
        FileOutputStream out = null;
        FileInputStream input = null;
        XWPFDocument docx = new XWPFDocument();
        
        try {
           
            String img = "img.png";
            input = new FileInputStream(new File(img));
            XWPFParagraph paragrafo1 = docx.createParagraph();
            paragrafo1.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun linha1 = paragrafo1.createRun();
            linha1.setFontFamily("Time New Roman");
            linha1.addPicture(input,XWPFDocument.PICTURE_TYPE_PNG, img, Units.toEMU(40), Units.toEMU(40));
            linha1.addBreak();
            linha1.setText("Secretaria de Estado da Saúde Pública");
            linha1.addBreak();
            linha1.setText("Coordenadoria de Recursos Humanos");
            linha1.addBreak();
            linha1.setText("Subcoordenadoria de Gestão das Relações do Trabalho");
            linha1.addBreak();
            linha1.setText("Av. Deodoro da Fonseca, 730, Cidade Alta, Natal/RN - 59.025-600 /n");
            linha1.addBreak();
            linha1.setText("08.241.754/0001-45 - Fones: 3232-2679 – 2643 -  sesap@rn.gov.br");
            linha1.addBreak();
            linha1.addBreak();
            linha1.addBreak();
            linha1.setText("RESENHA DE AVERBAÇÃO DE TEMPO DE CONTRIBUIÇÃO Nº 166/2018*");
           
            XWPFTable tabela = docx.createTable();
            
            XWPFTableRow linha = tabela.getRow(0);
            linha.getCell(0).setText("---------SERVIDOR(A)---------");
            linha.addNewTableCell().setText(" MATRÍCULA ");
            linha.addNewTableCell().setText("-------PERÍODO-------");
            linha.addNewTableCell().setText("--DIAS--");
            linha.addNewTableCell().setText("NATUREZA");
            linha.addNewTableCell().setText(" AUTORIZAÇÃO ");
            
            DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yy");
            XWPFParagraph paragrafo2 = docx.createParagraph();
            XWPFRun linha3 = paragrafo2.createRun();
            linha3.setText(interessado.getNome());
            linha3.addTab();
            linha3.setText(interessado.getMatricula());
            linha3.addTab();
            for(int i = 0; i<=empresa.length-1;i++){
            linha3.setText(formataData.format(empresa[i].getDtAdmissao())+"-"+formataData.format(empresa[i].getDtDemissao()));
            linha3.addTab();
            linha3.setText(Integer.toString(empresa[i].periodoTotalDias()));
            linha3.addTab();
            linha3.setText(empresa[i].natureza());
            linha3.addBreak();
            linha3.addTab();
            linha3.addTab();
            linha3.addTab();
            linha3.addTab();
            linha3.addTab();
            }
             out = new FileOutputStream(new File("C:\\App\\Resenha Averbação\\"+interessado.getNome()+".docx"));
            docx.write(out);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
