
package projetosenac;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Empresa {
    private String nome;
    private Interessado funcionario;
    private LocalDate dtAdmissao;
    private LocalDate dtDemissao;
    private boolean natureza;

    public Empresa(String nome, Interessado funcionario, LocalDate dtAdmissao, LocalDate dtDemissao, boolean natureza) {
        this.nome = nome;
        this.funcionario = funcionario;
        this.dtAdmissao = dtAdmissao;
        this.dtDemissao = dtDemissao;
        this.natureza = natureza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Interessado getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Interessado funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(LocalDate dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public LocalDate getDtDemissao() {
        return dtDemissao;
    }

    public void setDtDemissao(LocalDate dtDemissao) {
        this.dtDemissao = dtDemissao;
    }

    public boolean isNatureza() {
        return natureza;

    }

    public void setNatureza(boolean natureza) {
        this.natureza = natureza;
    }
    
    public Integer periodoTotalDias(){
        int dias = (int)ChronoUnit.DAYS.between(getDtAdmissao(), getDtDemissao());
        return dias;
    }
    
    public Integer periodoAnos(){
        int anos = (int)ChronoUnit.YEARS.between(getDtAdmissao(), getDtDemissao());
        return anos;
    }
    
    public int periodoMes(){
        int mes = (int)ChronoUnit.MONTHS.between(getDtAdmissao(), getDtDemissao())-(periodoAnos()*12);
        return mes;
    }
    
    public int periodoDias(){
        int dia = periodoTotalDias()-((periodoAnos()*365)+(periodoMes()*31));
        return (int) Math.floor(dia);
    }
    
    public DateTimeFormatter dataFormatada(){
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formataData;
    }
    
    public String natureza(){
        String natureza;
        if(isNatureza()==true){
            return natureza = "Privada";
        }
        return natureza = "Pública";
    }
}
