import java.util.*;
import java.util.stream.Collectors;

public class DesafioStreamAPI {
    public static void main(String[] args) {

        // Esta Lista numeros será usada para todos os exercicios quando for nescessario dentro do exercico
        // terá uma lista copia para fazer atualizações ou modificações
        List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 8, 10, 5, 4, 3));


        // DESAFIO 1 Mostre a lista na ordem numérica:
        List<Integer> numerosCrescente = numeros.stream().sorted().toList();
        System.out.println(numerosCrescente);
        // Imprimindo a soma dos numeros pares da lista;


        // DESAFIO 2  Imprima a soma dos números pares da lista:

        List<Integer> numerosPares = new ArrayList<>(numeros).stream()
                .filter(numero -> numero % 2 == 0) // filtrando pegando apenas os numeros pares
                .distinct() // removendo numeros repetidos
                .sorted() // ordenando na ordem crescente
                .toList();// adicionando em uma lista
        System.out.println("Todos os numeros pares da Lista são: " + numerosPares);

        // DESAFIO 3
        // todos os numeros da lista sao positivos ?
        boolean todosPositivos = numeros.stream().allMatch(n -> n > 0);
        if (todosPositivos) {
            System.out.println("Todos os numeros da lista sao positivos");
        } else {
            System.out.println("exitem números na lista que nao sao positivos");
        }

        // DESAFIO 4 removendo nuemros impares e atualizando a lista
        List<Integer> copiaListOriginal = new ArrayList<>(numeros);
        List<Integer> numerosRemover = numeros.stream()
                .filter(n -> n % 2 != 0)
                .toList(); // ou .collect(Collectors.toList());

        copiaListOriginal.removeIf(n -> n % 2 != 0); // Remove números ímpares da lista original

        System.out.println("Números removidos: " + numerosRemover);
        System.out.println("Lista atualizada: " + numeros);

        // DESAFIO 5 calcule a media dos numeros maiores que 5
        List<Integer> numerosMaiorQue = numeros.stream().filter(n -> n > 5).toList();
        System.out.println("numeros maiores que 5 " + numerosMaiorQue);
        int soma = numerosMaiorQue.stream().reduce(0, Integer::sum);
        System.out.println("a media da soma dos numeros maiores que 5 : " + soma / numerosMaiorQue.size());

        // DESAFIO 6 verificar se a lista contem algum numero maior que 10;
        boolean ContainNumero = numeros.stream().anyMatch(numero -> numero > 10);
        System.out.println("Existe na lista um numero maior que 10: " + ContainNumero);

        // DESAFIO 7 Encontrar o segundo número maior da lista;
        Optional<Integer> segundoValor = numeros.stream().sorted().skip(0).findFirst();

        if (segundoValor.isPresent()) {
            System.out.println("O segundo valor da lista é: " + segundoValor.get());
        } else {
            System.out.println("Valor nao encontrado na lista");
        }

        // DESAFIO 7 Encontrar o Segundo maior numero da lista:
        List<Integer> numerosCopiadosNovaList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 8, 10, 5, 4, 3));
        Integer maiorNumeroLista = numerosCopiadosNovaList.stream().max(Integer::compare).orElse(null);
        List<Integer> encontrarSegundoNumeroMaior = new ArrayList<>(numerosCopiadosNovaList);
        Integer segundoMaiorValor = encontrarSegundoNumeroMaior.stream()
                .sorted(Comparator.reverseOrder()) // Ordenar em ordem decrescente
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println("Primeiro maior número da lista é: " + maiorNumeroLista);
        System.out.println("Segundo maior número da lista é: " + segundoMaiorValor);

        // Desafio 9 Verificar se todos os numeros da lista sao distintos "Nao se repetem"
        boolean numerosSaoDistintos = numeros.stream() // Criar um fluxo (stream) a partir da lista
                .distinct() // removendo numeros Duplicados
                .count() != numeros.size(); // Compara o número de elementos únicos com o tamanho da lista original para determinar se há duplicatas.

        System.out.println("A lista possui duplicatas?: " + numerosSaoDistintos);

        // Desafio 10 Agrupe os valores impares múltiplos de 3 ou de 5;
        Map<Boolean, List<Integer>> result1 = numeros.stream()
                .filter(numerosList -> numerosList % 2 != 0) // Filtrar números ímpares
                .filter(numerosList -> (numerosList % 3 == 0 || numerosList % 5 == 0)) // Filtrar números múltiplos de 3 ou 5
                .collect(Collectors.groupingBy(
                        numerosList -> (numerosList % 3 == 0), // Agrupar pelo critério de múltiplos de 3 (true) ou 5 (false)
                        Collectors.toList() // Colocar os elementos correspondentes em uma lista
                ));

        System.out.println("Valores ímpares múltiplos de 3 ou 5 agrupados:");
        System.out.println("Múltiplos de 3: " + result1.get(true));
        System.out.println("Múltiplos de 5 : " + result1.get(false));

        // Desafio 11 - Multiplicar os números por eles mesmos
        System.out.println("Multiplicando todos os numeros da lista por ele mesmo: ");
        List<Integer> listaOriginalOrdenada = new ArrayList<>(numeros).stream().sorted().toList();
        List<Integer> somarQuadradoNumeros = numeros.stream()
                .sorted()
                .map(numero -> numero * numero)
                .toList();
        System.out.println("Lista Original a ser Multiplicada: " + listaOriginalOrdenada );
        System.out.println("Numeros multiplicados por si Mesmo: " + somarQuadradoNumeros);

        // Desafio 12 - Encontre o produto de todos os números da lista
        List<Integer> encontrarProdutoList = Arrays.asList(1, 2, 3, 4, 5);
        int product = encontrarProdutoList.stream()
                .sorted()
                .reduce(1, (numero1, numero2) -> numero1 * numero2);
        System.out.println("O produto de todos os números da lista é: " + product);

        // Desafio 13 - Filtrar todos os números que estão dentro do intervalo 5 e 10

        String filter = numeros.stream()
                .filter(num -> num >= 5 && num <= 10)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println("Filtrar todos os números que estão dentro do intervalo de 5 e 10: " + filter);

        // Desafio 14 - Exemplo de Joining
        List<String> palavras = Arrays.asList("Olá", "mundo", "como", "você", "está");
        String resultadoJoining = palavras.stream()
                .collect(Collectors.joining(", "));
        System.out.println(resultadoJoining);

        // Desafio 15 - Encontre o maior número ímpar da lista
        Integer maiorNumeroImpar = numeros.stream()
                .filter(num -> num % 2 != 0)
                .max(Integer::compare)
                .orElse(null);
        System.out.println("O maior número ímpar é: " + maiorNumeroImpar);

        // Desafio 16 - Verifique se a lista contém pelo menos um número negativo
        boolean ContainNumeroMenorQueZero = numeros.stream().anyMatch(numero -> numero < 0);
        System.out.println("A lista contém pelo menos um número negativo? " + ContainNumeroMenorQueZero);

        // Desafio 17 - Agrupe os números em pares e ímpares
        List<Integer> listaNumerosPares = numeros.stream().filter(num -> num % 2 == 0).toList();
        List<Integer> listaNumerosImpares = numeros.stream().filter(num -> num % 2 != 0).toList();
        System.out.println("Números Pares: " + listaNumerosPares);
        System.out.println("Números Ímpares: " + listaNumerosImpares);

        // Desafio 18 - Filtrar os números primos da lista
        List<Integer> numeros1 = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List<Integer> primos = filtrarNumerosPrimos(numeros1);
        System.out.println("Números primos na lista: " + primos);

        // Desafio 19 - Verifique se todos os números da lista são iguais
        boolean saoTodosIguais = numeros.stream().distinct().count() == numeros.size();
        if (saoTodosIguais) {
            System.out.println("Os números da lista são únicos");
        } else {
            System.out.println("Há números repetidos na lista." + numeros);
        }

        // Desafio 20 - Encontre a soma dos números divisíveis por 3 e 5
        List<Integer> numeroDivisivelPorTres = numeros.stream().filter(numero -> numero % 3 == 0).toList();
        Integer somaDivPorTres = numeroDivisivelPorTres.stream().reduce(Integer::sum).orElse(null);
        System.out.println("Números divisíveis por 3: " + numeroDivisivelPorTres);
        System.out.println("A soma dos números divisíveis por 3 é: " + somaDivPorTres);

        List<Integer> numeroDivisivelPorCinco = numeros.stream().filter(numero -> numero % 5 == 0).toList();
        Integer somaDivPorCinco = numeroDivisivelPorCinco.stream().reduce(Integer::sum).orElse(null);
        System.out.println("Números divisíveis por 5: " + numeroDivisivelPorCinco);
        System.out.println("A soma dos números divisíveis por 5 é: " + somaDivPorCinco);
    }

    // Método para filtrar números primos
    public static List<Integer> filtrarNumerosPrimos(List<Integer> numeros) {
        return numeros.stream()
                .filter(DesafioStreamAPI::isPrimo)
                .collect(Collectors.toList());
    }

    // Método para verificar se um número é primo
    public static boolean isPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}