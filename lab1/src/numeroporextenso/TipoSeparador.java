package numeroporextenso;

public enum TipoSeparador {
	
	NENHUM(" "),  E(" e "), VIRGULA(", ");
    String separadorStr;
    TipoSeparador(String separadorStr) {
            this.separadorStr = separadorStr;
    } 
    public String getSeparador() {
            return separadorStr;
    }

}

