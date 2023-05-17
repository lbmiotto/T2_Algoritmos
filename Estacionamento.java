import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Estacionamento {
    private static final int CAPACIDADE_MAXIMA = 12;

    public static void main(String[] args) {

        Queue<String> estacionamento = new LinkedList<>();

        String[] entradas = { "C ABC123", "C XYZ789", "P XYZ789", "C DEF456", "C GHI789", "C JKL123", "P ABC123", "F" };

        for (String entrada : entradas) {
            Scanner scanner = new Scanner(entrada);

            if (scanner.hasNext()) {
                String acao = scanner.next();

                if (scanner.hasNext()) {
                    String placa = scanner.next();

                    if (acao.equals("C")) {
                        boolean estacionado = estacionarCarro(estacionamento, placa);
                        System.out.println("Carro com placa " + placa + (estacionado ? " estacionado" : " aguardando"));
                    } else if (acao.equals("P")) {
                        int deslocamentos = removerCarro(estacionamento, placa);
                        System.out.println("Carro com placa " + placa + " saiu, deslocou-se " + deslocamentos + " vezes");
                    } else if (acao.equals("F")) {
                        break;
                    }
                }
            }

            scanner.close();
        }
    }

    private static boolean estacionarCarro(Queue<String> estacionamento, String placa) {
        if (estacionamento.size() == CAPACIDADE_MAXIMA) {
            return false;
        }

        estacionamento.add(placa);
        return true;
    }

    private static int removerCarro(Queue<String> estacionamento, String placa) {
        int deslocamentos = 0;

        while (!estacionamento.isEmpty()) {
            String carro = estacionamento.remove();
            deslocamentos++;

            if (carro.equals(placa)) {
                return deslocamentos;
            }
        }

        return -1;
    }
}
