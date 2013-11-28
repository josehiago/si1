package numeroporextenso;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NumeroPorExtenso {
	
	public static final String ZERO = "zero";
    public static final String CEM = "cem";
    private boolean milSemUm = false;
    public static final BigDecimal MIL = new BigDecimal(1000);
    public static final BigDecimal CENTO = new BigDecimal(100);
    public static final BigDecimal ZERAO = new BigDecimal(0);
    private TipoSeparador separadorGrupo = TipoSeparador.VIRGULA;
    private TipoSeparador separadorUltimoGrupo = TipoSeparador.VIRGULA;
    private TipoSeparador separadorDepoisDeMil = TipoSeparador.VIRGULA;
	
	public String[] UNIDADES = {"", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", 
    "dez", "onze", "doze", "treze", "quatorze","quinze","dezesseis","dezessete","dezoito","dezenove"};
    public String[] DEZENAS = {"", "", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", 
    		                   "noventa"};
    public String[] CENTENAS = {"", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos",
    		                    "setecentos", "oitocentos", "novecentos"};
    public String[] ordensmaiores= {"", "mil", "milhão", "bilhão"};
    public String[] ordensduplas = {"", "mil", "milhões", "bilhões"};
    
	
	public NumeroPorExtenso(boolean milSemUm) {
        this.milSemUm = milSemUm;
        separadorUltimoGrupo = separadorGrupo;
    }
	
	public NumeroPorExtenso(boolean milSemUm, boolean virgulaEntreGrupos, boolean virgulaDepoisDeMil) {
        this.milSemUm = milSemUm;
        separadorGrupo = virgulaEntreGrupos?TipoSeparador.VIRGULA:TipoSeparador.NENHUM;
        separadorUltimoGrupo = separadorGrupo;
        separadorDepoisDeMil = virgulaDepoisDeMil?separadorGrupo:TipoSeparador.NENHUM;
    }

	public static NumeroPorExtenso getDefaultInstance() {
    	NumeroPorExtenso defaultInstance = new NumeroPorExtenso(false, true, true);
        return defaultInstance;
    }

    String unidades(int numero) {
        if (numero == 0) return ZERO;
        if (numero < UNIDADES.length) return UNIDADES[numero];
        throw new RuntimeException("valor: " + numero);
    }
    
    String dezenas(int numero) {
        if (numero < UNIDADES.length) 
        	return unidades(numero);
        int unidade = numero % 10;
        numero = numero / 10;
        String unidadeStr = "";
        if (unidade != 0) {
                unidadeStr = TipoSeparador.E.getSeparador() + unidades(unidade);
        }
        if (numero < DEZENAS.length) 
        	return DEZENAS[numero] + unidadeStr;
        throw new RuntimeException();
     }
    
     String centenas(int numero) {
        if (numero == 100) 
        	return CEM;
        if (numero < 100) 
        	return dezenas(numero);
        int rem = numero % 100;
        numero = numero/100;
        String dezenaStr = "";
        if (rem != 0) {
                dezenaStr = TipoSeparador.E.getSeparador() + dezenas(rem);
        }
        if (numero < CENTENAS.length) 
        	return CENTENAS[numero] + dezenaStr;
        throw new RuntimeException();
      }
     
      String montaOrdem(int numero, int ordem) {
         if (numero == 0) 
        	 return "";
         String nomeGrupo = "";
         if (numero == 1) {
        	     milSemUm = true;//se for false ele poe um na frente dos numeros
                 if (ordem == 1 && milSemUm) {
                         return ordensmaiores[ordem];
                 }
                 nomeGrupo = ordensmaiores[ordem];
         } else {
                 nomeGrupo = ordensduplas[ordem];
         }
         if (ordem == 0) 
        	 return centenas(numero);
         return centenas(numero) + TipoSeparador.NENHUM.getSeparador() + nomeGrupo;
       }

       
       protected List<OrdemGrupo> montaOrdem(BigDecimal numero) {
         List<OrdemGrupo> grupos = new ArrayList<OrdemGrupo>();
         int i = 0;
         while (numero.compareTo(ZERAO) > 0) {
                 BigDecimal[] tmp = numero.divideAndRemainder(MIL);
                 if (tmp[1].intValue() > 0) {
                	 OrdemGrupo grupo = new OrdemGrupo(tmp[1].intValue(), i, montaOrdem(tmp[1].intValue(), i));
                         grupos.add(grupo);
                 }
                 numero = tmp[0];
                 i++;
         }
         return grupos;
        }

        protected String reagrupa(List<OrdemGrupo> grupos) {
           boolean omiteUltimoSeparador = false;
           if (grupos.get(0).getValor() > 100 && grupos.get(0).getValor() % 100 != 0) {
                 omiteUltimoSeparador = true;
           }
           Iterator<OrdemGrupo> it = grupos.iterator();
           String ret = it.next().getExtenso();
           if (!omiteUltimoSeparador && it.hasNext()) {
                 ret = it.next().getExtenso() + TipoSeparador.E.getSeparador() + ret;
           } else if (it.hasNext()) {
        	     OrdemGrupo grupo = it.next();
                 TipoSeparador separador = grupo.getPosicao().equals(1)?separadorDepoisDeMil:separadorUltimoGrupo;
                 ret = grupo.getExtenso() + separador.getSeparador() + ret;
           }
           while (it.hasNext()) {
                 ret = it.next().getExtenso() + separadorGrupo.getSeparador() + ret;
           }
           return ret;
         }
 
         public  <T extends Number> String converteInteiro(T number) {
        	 BigDecimal numero = new BigDecimal(number.toString());
        	 if (numero.compareTo(MIL) < 0) return centenas(numero.intValue());
        	 	List<OrdemGrupo> grupos = montaOrdem(numero);
        	    return reagrupa(grupos);
         }
}