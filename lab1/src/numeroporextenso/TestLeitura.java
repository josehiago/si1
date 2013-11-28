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
                assertEquals("um milhão", n.converteInteiro(1000000L));
                assertEquals("dois milhões", n.converteInteiro(new BigInteger("2000000")));
                assertEquals("um", n.converteInteiro((short)1));
                assertEquals("um", n.converteInteiro(1.01));
                assertEquals("mil", n.converteInteiro(1000));
                assertEquals("mil e um", n.converteInteiro(1001));
                assertEquals("doze mil, trezentos e quarenta e cinco", n.converteInteiro(12345.67));
                assertEquals("um milhão", n.converteInteiro(1000000));
                assertEquals("mil e um", n.converteInteiro(new BigDecimal(1001)));
                assertEquals("doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345)));
                assertEquals("um bilhão, trinta e quatro milhões, doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(1034012345)));
                assertEquals("mil e um", n.converteInteiro(new BigDecimal(1001)));
                assertEquals("doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345.67)));
                assertEquals("um bilhão, trinta e quatro milhões, doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(1034012345.67)));
                assertEquals("mil e um", n.converteInteiro(new BigDecimal(1001)));
                assertEquals("doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345.67)));
                assertEquals("um bilhão, trinta e quatro milhões, doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(1034012345.67)));
                assertEquals("mil e um", n.converteInteiro(new BigDecimal(1001)));
                assertEquals("doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345.67)));
                assertEquals("um bilhão, trinta e quatro milhões, doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(1034012345.67)));
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
        	    assertEquals("Número não corresponde", "zero", numero.converteInteiro(0));
                assertEquals("Número não corresponde", "um", numero.converteInteiro(1));
                assertEquals("Número não corresponde", "dois", numero.converteInteiro(2));
                assertEquals("Número não corresponde", "três", numero.converteInteiro(3));
                assertEquals("Número não corresponde", "quatro", numero.converteInteiro(4));
                assertEquals("Número não corresponde", "cinco", numero.converteInteiro(5));
                assertEquals("Número não corresponde", "seis", numero.converteInteiro(6));
                assertEquals("Número não corresponde", "sete", numero.converteInteiro(7));
                assertEquals("Número não corresponde", "oito", numero.converteInteiro(8));
                assertEquals("Número não corresponde", "nove", numero.converteInteiro(9));
                assertEquals("Número não corresponde", "dez", numero.converteInteiro(10));
               
        }
       
        @Test
        public void test2() {
        	    NumeroPorExtenso numero = new NumeroPorExtenso(false);
                assertEquals("Número não corresponde", "onze", numero.converteInteiro(11));
                assertEquals("Número não corresponde", "doze", numero.converteInteiro(12));
                assertEquals("Número não corresponde", "treze", numero.converteInteiro(13));
                assertEquals("Número não corresponde", "quatorze", numero.converteInteiro(14));
                assertEquals("Número não corresponde", "quinze", numero.converteInteiro(15));
                assertEquals("Número não corresponde", "dezesseis", numero.converteInteiro(16));
                assertEquals("Número não corresponde", "dezessete", numero.converteInteiro(17));
                assertEquals("Número não corresponde", "dezoito", numero.converteInteiro(18));
                assertEquals("Número não corresponde", "dezenove", numero.converteInteiro(19));
                assertEquals("Número não corresponde", "vinte", numero.converteInteiro(20));
                       
        }
       
        @Test
        public void test3() {
        		NumeroPorExtenso numero = new NumeroPorExtenso(false);
                assertEquals("Número não corresponde", "vinte e um", numero.converteInteiro(21));
                assertEquals("Número não corresponde", "trinta e quatro", numero.converteInteiro(34));
                assertEquals("Número não corresponde", "quarenta e oito", numero.converteInteiro(48));
                assertEquals("Número não corresponde", "cinquenta e seis", numero.converteInteiro(56));
                assertEquals("Número não corresponde", "sessenta e cinco", numero.converteInteiro(65));
                assertEquals("Número não corresponde", "setenta e três", numero.converteInteiro(73));
                assertEquals("Número não corresponde", "oitenta e um", numero.converteInteiro(81));
                assertEquals("Número não corresponde", "noventa e dois", numero.converteInteiro(92));
                assertEquals("Número não corresponde", "cem", numero.converteInteiro(100));
                                       
        }
       
        @Test
        public void test4() {
        	NumeroPorExtenso numero = new NumeroPorExtenso(false);
        	
                assertEquals("Número não corresponde", "cento e setenta e seis", numero.converteInteiro(176));
                assertEquals("Número não corresponde", "cento e oitenta e cinco", numero.converteInteiro(185));
                assertEquals("Número não corresponde", "duzentos e quinze", numero.converteInteiro(215));
                assertEquals("Número não corresponde", "trezentos e quarenta e cinco", numero.converteInteiro(345));
                assertEquals("Número não corresponde", "novecentos e trinta", numero.converteInteiro(930));
                assertEquals("Número não corresponde", "mil, duzentos e quarenta e cinco", numero.converteInteiro(1245));
                assertEquals("Número não corresponde", "dez mil", numero.converteInteiro(10000));
                assertEquals("Número não corresponde", "dez mil, quatrocentos e cinquenta e seis", numero.converteInteiro(10456));
                assertEquals("Número não corresponde", "um milhão", numero.converteInteiro(1000000));
                assertEquals("Número não corresponde", "dez milhões", numero.converteInteiro(10000000));
                       
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