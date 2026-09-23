package arvore_de_recursao;

import java.util.Scanner;

public class Arvore_de_Recursao {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);

	        
	        System.out.println("ÁRVORE DE RECURSÃO");
	        System.out.println();

	        System.out.print("Digite a quantidade de subproblemas (a): ");
	        int a = scanner.nextInt();

	        System.out.print("Digite o divisor do problema (b): ");
	        int b = scanner.nextInt();

	        scanner.nextLine();

	        System.out.print("Digite a funcao de custo f(n): ");
	        String funcao = scanner.nextLine();

	        if (a < 1 || b <= 1 || funcao.trim().isEmpty()) {
	            System.out.println("Parametros invalidos.");
	            scanner.close();
	            return;
	        }

	        System.out.println();
	        System.out.println("RECORRÊNCIA");
	        System.out.println();

	        System.out.println(
	                "T(n) = " + a + "T(n/" + b + ") + " + funcao
	        );

	        System.out.println();
	        System.out.println("ÁRVORE DE RECURSÃO");
	        System.out.println();

	        System.out.println();

	        int nivel = 0;
	        String custoAcumulado = "0";

	        while (nivel < 10) {

	            String quantidadeNos = potencia(a, nivel);
	            String tamanhoProblema = tamanhoProblema(b, nivel);
	            String custoPorNo = substituirN(funcao, tamanhoProblema);
	            String custoNivel = multiplicar(
	                    quantidadeNos,
	                    custoPorNo
	            );

	            custoAcumulado = somar(
	                    custoAcumulado,
	                    custoNivel
	            );

	            System.out.println("----------------------------------------");
	            System.out.println("Nivel: " + nivel);
	            System.out.println("Numero de nos: " + quantidadeNos);
	            System.out.println("Tamanho do problema: " + tamanhoProblema);
	            System.out.println("Custo de cada no: " + custoPorNo);
	            System.out.println("Custo dos nos do nivel: " + custoNivel);
	            System.out.println("Custo acumulado: " + custoAcumulado);

	            nivel++;
	        }

	        System.out.println();
	        System.out.println("ALTURA DA ÁRVORE");
	        System.out.println();

	        System.out.println(
	                "n / " + b + "^h = 1"
	        );

	        System.out.println(
	                "h = log_" + b + "(n)"
	        );

	        System.out.println();
	        System.out.println("FÓRMULA GERAL");
	        System.out.println();

	        System.out.println(
	                "Numero de nos no nivel i: " + a + "^i"
	        );

	        System.out.println(
	                "Tamanho do problema no nivel i: n/" + b + "^i"
	        );

	        System.out.println(
	                "Custo de cada no: f(n/" + b + "^i)"
	        );

	        System.out.println(
	                "Custo dos nos do nível: "
	                + a + "^i * f(n/" + b + "^i)"
	        );

	        System.out.println();
	        

	        scanner.close();
	    }

	    public static String potencia(int base, int expoente) {

	        if (expoente == 0) {
	            return "1";
	        }

	        if (expoente == 1) {
	            return String.valueOf(base);
	        }

	        return base + "^" + expoente;
	    }

	    public static String tamanhoProblema(int b, int nivel) {

	        if (nivel == 0) {
	            return "n";
	        }

	        if (nivel == 1) {
	            return "n/" + b;
	        }

	        return "n/" + b + "^" + nivel;
	    }

	    public static String substituirN(
	            String funcao,
	            String tamanho) {

	        String resultado = funcao;

	        resultado = resultado.replace(
	                "n^2",
	                "(" + tamanho + ")^2"
	        );

	        resultado = resultado.replace(
	                "n^3",
	                "(" + tamanho + ")^3"
	        );

	        resultado = resultado.replace(
	                "n",
	                "(" + tamanho + ")"
	        );

	        return resultado;
	    }

	    public static String multiplicar(
	            String quantidade,
	            String custo) {

	        if (quantidade.equals("1")) {
	            return custo;
	        }

	        return quantidade + " * (" + custo + ")";
	    }

	    public static String somar(
	            String primeiro,
	            String segundo) {

	        if (primeiro.equals("0")) {
	            return segundo;
	        }

	        return primeiro + " + " + segundo;
	    }
		
}
	

