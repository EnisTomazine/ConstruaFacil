package unitTests;

import devcalc.Calc;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestaCalc {

    @Test
    public void testarSomarDoisNumeros(){
        //1 - Prepara - Configurar - Given
        int num1 = 5;
        int num2 = 7;
        int resultadoEsperado = 12;

        // 2 - Executar - When
        int resultadoAtual = Calc.somarDoisNumeros(num1, num2);

        // 3 - Validar - Then
        System.out.println("O resultado Esperado e " + resultadoEsperado + "\n O resultado Atual foi " + resultadoAtual);
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    public void testarSubtrairDoisNumeros(){
        int num1 = 10;
        int num2 = 6;
        int resultadoEsperado = 4;

        int resultadoAtual = Calc.subtrairDoisNumeros(num1,num2);

        System.out.println("O resultado Esperado e " + resultadoEsperado + "\n O resultado Atual foi " + resultadoAtual);
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    @Test
    public void testarMultiplicarDoisNumeros(){
        int num1 = 2;
        int num2 = 4;
        int resultadoEsperado = 8;

        int resultadoAtual = Calc.multiplicarDoisNumeros(num1,num2);

        System.out.println("O resultado Esperado e " + resultadoEsperado + "\n O resultado Atual foi " + resultadoAtual);
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    @Test
    public void testarDividirDoisNumeros(){
        int num1 = 10;
        int num2 = 5;
        int resultadoEsperado = 2;

        int resultadoAtual = Calc.dividirDoisNumeros(num1,num2);

        System.out.println("O resultado Esperado e " + resultadoEsperado + "\n O resultado Atual foi " + resultadoAtual);
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    @Test
    public void testarDividirPorZero(){
        int num1 = 10;
        int num2 = 0;
        int resultadoEsperado = 0;

        int resultadoAtual = Calc.dividirDoisNumeros(num1,num2);

        System.out.println("O resultado Esperado e " + resultadoEsperado + "\n O resultado Atual foi " + resultadoAtual);
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    public void testarSubtrairDoisNumerosNaoPassa(){
        int num1 = 10;
        int num2 = 5;
        int resultadoEsperado = 4;

        int resultadoAtual = Calc.subtrairDoisNumeros(num1,num2);

        System.out.println("O resultado Esperado e " + resultadoEsperado + "\n O resultado Atual foi " + resultadoAtual);
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    @Test
    public void testarMultiplicarDoisNumerosNaoPassa(){
        int num1 = 2;
        int num2 = 1;
        int resultadoEsperado = 8;

        int resultadoAtual = Calc.multiplicarDoisNumeros(num1,num2);

        System.out.println("O resultado Esperado e " + resultadoEsperado + "\n O resultado Atual foi " + resultadoAtual);
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    @Test
    public void testarDividirDoisNumerosNaoPassa(){
        int num1 = 10;
        int num2 = 2;
        int resultadoEsperado = 2;

        int resultadoAtual = Calc.dividirDoisNumeros(num1,num2);

        System.out.println("O resultado Esperado e " + resultadoEsperado + "\n O resultado Atual foi " + resultadoAtual);
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    @Test
    public void testarDividirPorZeroNaoPassa(){
        int num1 = 10;
        int num2 = 0;
        int resultadoEsperado = 1;

        int resultadoAtual = Calc.dividirDoisNumeros(num1,num2);

        System.out.println("O resultado Esperado e " + resultadoEsperado + "\n O resultado Atual foi " + resultadoAtual);
        assertEquals(resultadoEsperado, resultadoAtual);
    }



}
