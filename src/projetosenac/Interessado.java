
package projetosenac;

public class Interessado {
    private String nome;
    private String matricula;
    private String processo;
    private String lotacao;
    private Integer dias;
    private Integer mes;
    private Integer anos;

    public Interessado(String nome, String matricula, String processo, String lotacao) {
        this.nome = nome;
        this.matricula = matricula;
        this.processo = processo;
        this.lotacao = lotacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getLotacao() {
        return lotacao;
    }

    public void setLotacao(String lotacao) {
        this.lotacao = lotacao;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
        setAnos(dias);
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnos() {
        return anos;
    }

    public void setAnos(Integer anos) {
        this.anos = anos/365;
        int m = (anos%365)/30;
        setMes(m);
    }
    
    public void somaDias(Empresa empresa[]){
        int dias=0;
        for(int i = 0; i<=empresa.length-1; i++){
            dias += empresa[i].periodoTotalDias();
        }
        setDias(dias);
    }
    
}
