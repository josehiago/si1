package numeroporextenso;

public class OrdemGrupo {
    Integer valor;
    Integer posicao;
    String extenso;
    public OrdemGrupo(Integer valor, Integer posicao, String extenso) {
            this.valor = valor;
            this.posicao = posicao;
            this.extenso = extenso;
    }
    public Integer getValor() {
            return this.valor;
    }
    public Integer getPosicao() {
            return this.posicao;
    }
    public String getExtenso() {
            return this.extenso;
    }
}

