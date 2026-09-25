package arvore_de_recursao;

import java.util.Scanner;

public class Arvore_de_Recursao2 {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);

	        System.out.println("========================================");
	        System.out.println("          ARVORE DE RECURSAO");
	        System.out.println("========================================");

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

	        // ========================================
	        // RECORRENCIA
	        // ========================================

	        System.out.println("========================================");
	        System.out.println("RECORRENCIA");
	        System.out.println("========================================");

	        System.out.println(
	                "T(n) = " + a + "T(n/" + b + ") + " + funcao
	        );

	        System.out.println();

	        // ========================================
	        // ARVORE DE RECURSAO
	        // ========================================

	        System.out.println("========================================");
	        System.out.println("ARVORE DE RECURSAO");
	        System.out.println("========================================");

	        System.out.println();

	        // Nivel 0
	        mostrarNivel(
	                0,
	                potencia(a, 0),
	                tamanhoProblema(b, 0),
	                substituirN(funcao, tamanhoProblema(b, 0))
	        );

	        System.out.println();

	        // Nivel 1
	        mostrarNivel(
	                1,
	                potencia(a, 1),
	                tamanhoProblema(b, 1),
	                substituirN(funcao, tamanhoProblema(b, 1))
	        );

	        System.out.println();

	        // Nivel 2
	        mostrarNivel(
	                2,
	                potencia(a, 2),
	                tamanhoProblema(b, 2),
	                substituirN(funcao, tamanhoProblema(b, 2))
	        );

	        System.out.println();

	        // Nivel 3
	        mostrarNivel(
	                3,
	                potencia(a, 3),
	                tamanhoProblema(b, 3),
	                substituirN(funcao, tamanhoProblema(b, 3))
	        );

	        System.out.println();

	        System.out.println("...");

	        System.out.println();

	        // ========================================
	        // NIVEL GENERICO
	        // ========================================

	        System.out.println("========================================");
	        System.out.println("NIVEL GENERICO");
	        System.out.println("========================================");

	        System.out.println();

	        System.out.println("Nivel: i");

	        System.out.println(
	                "Numero de nos: " + a + "^i"
	        );

	        System.out.println(
	                "Tamanho do problema: n/" + b + "^i"
	        );

	        System.out.println(
	                "Custo de cada no: f(n/" + b + "^i)"
	        );

	        System.out.println(
	                "Custo do nivel: "
	                + a + "^i * f(n/" + b + "^i)"
	        );

	        System.out.println();

	        // ========================================
	        // CUSTO ACUMULADO
	        // ========================================

	        System.out.println("========================================");
	        System.out.println("CUSTO ACUMULADO");
	        System.out.println("========================================");

	        System.out.println();

	        System.out.println(
	                "Custo acumulado = "
	                + "Σ ["
	                + a + "^i * f(n/" + b + "^i)"
	                + "]"
	        );

	        System.out.println(
	                "para i = 0 ate h - 1"
	        );

	        System.out.println();

	        System.out.println(
	                "h = log_" + b + "(n)"
	        );

	        System.out.println();

	        System.out.println(
	                "Custo acumulado = "
	                + "Σ ["
	                + a + "^i * f(n/" + b + "^i)"
	                + "]"
	                + ", i = 0 ... log_" + b + "(n) - 1"
	        );

	        scanner.close();
	    }

	    // ========================================
	    // MOSTRA UM NIVEL
	    // ========================================

	    public static void mostrarNivel(
	            int nivel,
	            String quantidadeNos,
	            String tamanhoProblema,
	            String custoPorNo) {

	        String custoNivel = multiplicar(
	                quantidadeNos,
	                custoPorNo
	        );

	        System.out.println("Nivel: " + nivel);

	        System.out.println(
	                "Numero de nos: " + quantidadeNos
	        );

	        System.out.println(
	                "Tamanho do problema: " + tamanhoProblema
	        );

	        System.out.println(
	                "Custo de cada no: " + custoPorNo
	        );

	        System.out.println(
	                "Custo dos nos do nivel: " + custoNivel
	        );
	    }

	    // ========================================
	    // a^i
	    // ========================================

	    public static String potencia(
	            int base,
	            int expoente) {

	        if (expoente == 0) {
	            return "1";
	        }

	        if (expoente == 1) {
	            return String.valueOf(base);
	        }

	        return base + "^" + expoente;
	    }

	    // ========================================
	    // n / b^i
	    // ========================================

	    public static String tamanhoProblema(
	            int b,
	            int nivel) {

	        if (nivel == 0) {
	            return "n";
	        }

	        if (nivel == 1) {
	            return "n/" + b;
	        }

	        return "n/" + b + "^" + nivel;
	    }

	    // ========================================
	    // f(n) -> f(n/b^i)
	    // ========================================

	    public static String substituirN(
	            String funcao,
	            String tamanho) {

	        String resultado = funcao;

	        /*
	         * Protege n^2 e n^3 antes de substituir
	         * o n comum.
	         */
	        resultado = resultado.replace(
	                "n^3",
	                "__POT3__"
	        );

	        resultado = resultado.replace(
	                "n^2",
	                "__POT2__"
	        );

	        // Substitui o n comum
	        resultado = resultado.replace(
	                "n",
	                "(" + tamanho + ")"
	        );

	        // Recupera n^2
	        resultado = resultado.replace(
	                "__POT2__",
	                "(" + tamanho + ")^2"
	        );

	        // Recupera n^3
	        resultado = resultado.replace(
	                "__POT3__",
	                "(" + tamanho + ")^3"
	        );

	        return resultado;
	    }

	    // ========================================
	    // Multiplica quantidade de nos pelo custo
	    // ========================================

	    public static String multiplicar(
	            String quantidade,
	            String custo) {

	        if (quantidade.equals("1")) {
	            return custo;
	        }

	        return quantidade + " * (" + custo + ")";
	    }

	}


