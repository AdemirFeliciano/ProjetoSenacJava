
package projetosenac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

public class DespachoAverbacao {

   
 public void Averbacao(Interessado interessado, Empresa empresa[])throws FileNotFoundException, InvalidFormatException, IOException {
	   try {
                CriaPasta cria = new CriaPasta();
                cria.criaPastaDespacho();
		XWPFDocument docx = new XWPFDocument();
	        CTSectPr sectPr = docx.getDocument().getBody().addNewSectPr();
		XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(docx, sectPr);
			
		//Escreve cabeçalho
                
		CTP ctpHeader = CTP.Factory.newInstance();
		XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, docx);
                headerParagraph.setAlignment(ParagraphAlignment.CENTER);
                XWPFRun createRun = headerParagraph.createRun();
                XWPFRun createRun2 = headerParagraph.createRun();
                createRun.setFontSize(10);
                createRun.setFontFamily("Times New Roman");
                XWPFParagraph[] parsHeader = new XWPFParagraph[1];
	        parsHeader[0] = headerParagraph;
                
                String img = "img.png";
                InputStream input = new FileInputStream(img);
                createRun.addPicture(input,XWPFDocument.PICTURE_TYPE_PNG, img, Units.toEMU(25), Units.toEMU(25));
                createRun.addBreak();
                createRun.setText("Secretaria de Estado da Saúde Pública");
                createRun.addBreak();
                createRun.setText("Coordenadoria de Recursos Humanos");
                createRun.addBreak();
                createRun.setText("Subcoordenadoria de Gestão das Relações do Trabalho");
                createRun.addBreak();
                createRun.setText("Grupo Auxiliar de Direitos e Vantagens");
                createRun.addBreak();
                createRun2.setFontSize(8);
                createRun2.setFontFamily("Times New Roman");
                createRun2.setColor("808080");
                createRun2.setText("Av. Deodoro da Fonseca, 730, Cidade Alta, Natal/RN - 59.025-600");
                createRun2.addBreak();
                createRun2.setText("sesap@rn.gov.br - 08.241.754/0001-45");

                policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);
                
                //Escreve o corpo
                XWPFParagraph bodyParagraph1 = docx.createParagraph();
                XWPFRun run = bodyParagraph1.createRun();
                run.setFontFamily("Times New Roman");
                XWPFRun run1 = bodyParagraph1.createRun();
                run1.setFontFamily("Times New Roman");
                run1.setBold(true);
                XWPFParagraph bodyParagraph4 = docx.createParagraph();
                XWPFRun run2 = bodyParagraph4.createRun();
                run2.setFontFamily("Times New Roman");
                XWPFRun run3 = bodyParagraph4.createRun();
                run3.setFontFamily("Times New Roman");
                run3.setBold(true);
                XWPFParagraph bodyParagraph5 = docx.createParagraph();
                XWPFRun run4 = bodyParagraph5.createRun();
                run4.setFontFamily("Times New Roman");
                XWPFRun run5 = bodyParagraph5.createRun();
                run5.setFontFamily("Times New Roman");
                run5.setBold(true);
                XWPFParagraph bodyParagraph6 = docx.createParagraph();
                XWPFRun run6 = bodyParagraph6.createRun();
                run6.setFontFamily("Times New Roman");
                XWPFRun run7 = bodyParagraph6.createRun();
                run7.setFontFamily("Times New Roman");
                run7.setBold(true);
                XWPFParagraph bodyParagraph7 = docx.createParagraph();
                XWPFRun run8 = bodyParagraph7.createRun();
                run8.setFontFamily("Times New Roman");
                XWPFRun run9 = bodyParagraph7.createRun();
                run9.setFontFamily("Times New Roman");
                run9.setBold(true);
                
                run.setText("Interessado(a):     ");
                run1.setText(interessado.getNome());
                run2.setText("Matrícula nº:        ");
                run3.setText(interessado.getMatricula());
                run4.setText("Processo nº:         ");
                run5.setText(interessado.getProcesso());
                run6.setText("Lotação:               ");
                run7.setText("@lotacao");
                run8.setText("Assunto:               ");
                run9.setText("Despacho Averbação");
                
                
                XWPFParagraph bodyParagraph2 = docx.createParagraph();
                bodyParagraph2.setAlignment(ParagraphAlignment.CENTER);
                XWPFRun r2 = bodyParagraph2.createRun();
                r2.addBreak();
                r2.addBreak();
                r2.setFontFamily("Times New Roman");
                r2.setBold(true);
                r2.setText("DESPACHO");
                
	        XWPFParagraph bodyParagraph3 = docx.createParagraph();
                bodyParagraph3.setAlignment(ParagraphAlignment.BOTH);
                XWPFRun r3 = bodyParagraph3.createRun();
                r3.setFontFamily("Times New Roman");
                r3.setTextPosition(18);
                r3.addTab();
                r3.addTab();
                String texto = "De acordo com as informações contidas no processo supracitado - ";
                String texto3 = "especialmente no que se refere à Certidão de Tempo de Contribuição-CTC e à ficha funcional - ";
                String texto2 = "este grupo auxiliar identificou o(s) seguinte(s) período(s) "
                        + "de tempo de contribuição com possibilidade de averbação, retirada(s) a(s) concomitância(s):";
                r3.setText(texto + texto3 + texto2);
                 
                XWPFTable tabela = docx.createTable();
                XWPFTableRow linha = tabela.getRow(0);
                linha.getCell(0).setText("------------- ORGÃO/EMPRESA ------------");
                linha.addNewTableCell().setText("----------- PERÍODO -----------");
                linha.addNewTableCell().setText("---- LÍQUIDO ----");
                linha.addNewTableCell().setText("--- NATUREZA ---");
                DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                for(int i=0; i <=empresa.length-1; i++){
                XWPFTableRow linha2 = tabela.createRow();
                linha2.getCell(0).setText(empresa[i].getNome());
                linha2.getCell(1).setText(formataData.format(empresa[i].getDtAdmissao())+" a "+formataData.format(empresa[i].getDtDemissao()));
                linha2.getCell(2).setText("");
                linha2.getCell(3).setText(empresa[i].natureza());
                }
                XWPFParagraph bodyParagraph9 = docx.createParagraph();
                XWPFRun run11 = bodyParagraph9.createRun();
                bodyParagraph9.setAlignment(ParagraphAlignment.BOTH);
                run11.setFontFamily("Times New Roman");
                run11.setFontSize(11);
                run11.setText("Conforme cálculo espelhado no sistema de conversão fornecido pelo INSS, "
                        + "o aproveitamento do(s) período(s) apresentado(s) acima, corresponde a um total"
                        + " de "+interessado.getDias()+"("+Extenso.valorPorExtenso(interessado.getDias())+") dias, resultando em "
                        + ""+interessado.getAnos()+"("+Extenso.valorPorExtenso(interessado.getAnos())+") ano(s),"
                        + " "+interessado.getMes()+"("+Extenso.valorPorExtenso(interessado.getMes())+") mês(es).");
                
                XWPFParagraph bodyParagraph8 = docx.createParagraph();
                XWPFRun run10 = bodyParagraph8.createRun();
                run10.setBold(true);
                run10.addBreak();
                run10.addBreak();
                run10.setFontFamily("Times New Roman");
                run10.setFontSize(12);
                run10.addTab();
                run10.addTab();
                run10.setTextPosition(18);
                run10.setText("Diante do exposto, À ASSESSORIA JURÍDICA para análise e parecer quanto ao pedido do(a) servidor(a).");
                
	        FileOutputStream out = new FileOutputStream("C:\\App\\Despacho Averbação\\"+interessado.getNome()+".docx");
	        docx.write(out);
	        out.close();
	    } catch (Exception ex) {
		   ex.printStackTrace();
	    }


	}
}