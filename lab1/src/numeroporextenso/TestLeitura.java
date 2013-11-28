package numeroporextenso;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

public class TestLeitura {

        @Test
        public void testConverteInteiro() {
                NumeroPorExtenso n = new NumeroPorExtenso(false);
                assertEquals("mil", n.converteInteiro(1000));
                assertEquals("mil e um", n.converteInteiro(1001));
                assertEquals("doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345.67)));
                assertEquals("um milh�o", n.converteInteiro(1000000L));
                assertEquals("dois milh�es", n.converteInteiro(new BigInteger("2000000")));
                assertEquals("um", n.converteInteiro((short)1));
                assertEquals("um", n.converteInteiro(1.01));
                assertEquals("mil", n.converteInteiro(1000));
                assertEquals("mil e um", n.converteInteiro(1001));
                assertEquals("doze mil, trezentos e quarenta e cinco", n.converteInteiro(12345.67));
                assertEquals("um milh�o", n.converteInteiro(1000000));
                assertEquals("mil e um", n.converteInteiro(new BigDecimal(1001)));
                assertEquals("doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345)));
                assertEquals("um bilh�o, trinta e quatro milh�es, doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(1034012345)));
                assertEquals("mil e um", n.converteInteiro(new BigDecimal(1001)));
                assertEquals("doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345.67)));
                assertEquals("um bilh�o, trinta e quatro milh�es, doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(1034012345.67)));
                assertEquals("mil e um", n.converteInteiro(new BigDecimal(1001)));
                assertEquals("doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345.67)));
                assertEquals("um bilh�o, trinta e quatro milh�es, doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(1034012345.67)));
                assertEquals("mil e um", n.converteInteiro(new BigDecimal(1001)));
                assertEquals("doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345.67)));
                assertEquals("um bilh�o, trinta e quatro milh�es, doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(1034012345.67)));
        }
        
        @Test
        public void testGetInstance() {
                NumeroPorExtenso instance = NumeroPorExtenso.getDefaultInstance();
                assertNotNull(instance);
        }
        
        @Test
        public void TestaTudo(){
                
        }
       
        @Test
        public void test1() {
        	    NumeroPorExtenso numero = new NumeroPorExtenso(false);
        	    assertEquals("N�mero n�o corresponde", "zero", numero.converteInteiro(0));
                assertEquals("N�mero n�o corresponde", "um", numero.converteInteiro(1));
                assertEquals("N�mero n�o corresponde", "dois", numero.converteInteiro(2));
                assertEquals("N�mero n�o corresponde", "tr�s", numero.converteInteiro(3));
                assertEquals("N�mero n�o corresponde", "quatro", numero.converteInteiro(4));
                assertEquals("N�mero n�o corresponde", "cinco", numero.converteInteiro(5));
                assertEquals("N�mero n�o corresponde", "seis", numero.converteInteiro(6));
                assertEquals("N�mero n�o corresponde", "sete", numero.converteInteiro(7));
                assertEquals("N�mero n�o corresponde", "oito", numero.converteInteiro(8));
                assertEquals("N�mero n�o corresponde", "nove", numero.converteInteiro(9));
                assertEquals("N�mero n�o corresponde", "dez", numero.converteInteiro(10));
               
        }
       
        @Test
        public void test2() {
        	    NumeroPorExtenso numero = new NumeroPorExtenso(false);
                assertEquals("N�mero n�o corresponde", "onze", numero.converteInteiro(11));
                assertEquals("N�mero n�o corresponde", "doze", numero.converteInteiro(12));
                assertEquals("N�mero n�o corresponde", "treze", numero.converteInteiro(13));
                assertEquals("N�mero n�o corresponde", "quatorze", numero.converteInteiro(14));
                assertEquals("N�mero n�o corresponde", "quinze", numero.converteInteiro(15));
                assertEquals("N�mero n�o corresponde", "dezesseis", numero.converteInteiro(16));
                assertEquals("N�mero n�o corresponde", "dezessete", numero.converteInteiro(17));
                assertEquals("N�mero n�o corresponde", "dezoito", numero.converteInteiro(18));
                assertEquals("N�mero n�o corresponde", "dezenove", numero.converteInteiro(19));
                assertEquals("N�mero n�o corresponde", "vinte", numero.converteInteiro(20));
                       
        }
       
        @Test
        public void test3() {
        		NumeroPorExtenso numero = new NumeroPorExtenso(false);
                assertEquals("N�mero n�o corresponde", "vinte e um", numero.converteInteiro(21));
                assertEquals("N�mero n�o corresponde", "trinta e quatro", numero.converteInteiro(34));
                assertEquals("N�mero n�o corresponde", "quarenta e oito", numero.converteInteiro(48));
                assertEquals("N�mero n�o corresponde", "cinquenta e seis", numero.converteInteiro(56));
                assertEquals("N�mero n�o corresponde", "sessenta e cinco", numero.converteInteiro(65));
                assertEquals("N�mero n�o corresponde", "setenta e tr�s", numero.converteInteiro(73));
                assertEquals("N�mero n�o corresponde", "oitenta e um", numero.converteInteiro(81));
                assertEquals("N�mero n�o corresponde", "noventa e dois", numero.converteInteiro(92));
                assertEquals("N�mero n�o corresponde", "cem", numero.converteInteiro(100));
                                       
        }
       
        @Test
        public void test4() {
        	NumeroPorExtenso numero = new NumeroPorExtenso(false);
        	
                assertEquals("N�mero n�o corresponde", "cento e setenta e seis", numero.converteInteiro(176));
                assertEquals("N�mero n�o corresponde", "cento e oitenta e cinco", numero.converteInteiro(185));
                assertEquals("N�mero n�o corresponde", "duzentos e quinze", numero.converteInteiro(215));
                assertEquals("N�mero n�o corresponde", "trezentos e quarenta e cinco", numero.converteInteiro(345));
                assertEquals("N�mero n�o corresponde", "novecentos e trinta", numero.converteInteiro(930));
                assertEquals("N�mero n�o corresponde", "mil, duzentos e quarenta e cinco", numero.converteInteiro(1245));
                assertEquals("N�mero n�o corresponde", "dez mil", numero.converteInteiro(10000));
                assertEquals("N�mero n�o corresponde", "dez mil, quatrocentos e cinquenta e seis", numero.converteInteiro(10456));
                assertEquals("N�mero n�o corresponde", "um milh�o", numero.converteInteiro(1000000));
                assertEquals("N�mero n�o corresponde", "dez milh�es", numero.converteInteiro(10000000));
                       
        }
        
        
        
        /*public static void main(String[] args) {
    		NumeroPorExtenso numero = new NumeroPorExtenso(28, false);
    		System.out.println(numero.converteInteiro(0));
    		System.out.println(numero.converteInteiro(2));
    		System.out.println(numero.converteInteiro(8));
    		System.out.println(numero.converteInteiro(24));
    		System.out.println(numero.converteInteiro(98));
    		System.out.println(numero.converteInteiro(118));
    		System.out.println(numero.converteInteiro(150));
    		System.out.println(numero.converteInteiro(199));
    		System.out.println(numero.converteInteiro(204));
    		System.out.println(numero.converteInteiro(456));
    		System.out.println(numero.converteInteiro(988));
    		System.out.println(numero.converteInteiro(1000));
    		System.out.println(numero.converteInteiro(1000000));
    	}*/
}