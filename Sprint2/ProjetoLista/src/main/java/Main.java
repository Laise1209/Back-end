import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(4);
        lista.add("teste1");
        System.out.println("Item adicionado " + lista.vetor[0]);

        lista.add("teste2");
        System.out.println("Item adicionado (que será removido com string) " + lista.vetor[1]);

        lista.add("teste3");
        System.out.println("Item adicionado (que será removido com int) " + lista.vetor[2]);

        lista.add("teste4");
        System.out.println("Item adicionado " + lista.vetor[3]);

        //maior que a lista -> precisa dar erro
//        lista.add("teste5");
//        System.out.println("Item adicionado " + lista.vetor[4]);

        lista.get(1);

        lista.get("teste1");

        lista.removeInt(2);
        System.out.println("Item atual = " + lista.vetor[2]);

        lista.removeString("teste2");//vetor1
        System.out.println("Item atual = " + lista.vetor[1]);

        System.out.println(lista.toString());

    }
}
