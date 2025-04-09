import java.util.Arrays;

public class ListaEstatica {
    String[] vetor;
    int nroElem;

    public ListaEstatica(int tam) {
        this.vetor = new String[tam];
        this.nroElem = 0;
    }

    public void add(String elemento){
        if(nroElem >= vetor.length){
            throw new ArrayIndexOutOfBoundsException("ta cheio");
        } else{
            vetor[nroElem] = elemento;
            nroElem++;
        }
    }

    public String get(int elemento){
        for (int i = 0; i < nroElem; i++) {
            if (i == elemento){
                System.out.println("Item encontrado " + vetor[i]);
                return vetor[i];
            }
        }
        return "não existe";
    }

    public int get(String elemeto){
        for (int i = 0; i < nroElem; i++) {
            if (elemeto.equals(vetor[i])){
                System.out.println("Item encontrado " + elemeto);
                return i;
            }
        }
        return -1;
    }

    public boolean removeInt(int index){
        if(index < 0 || index > nroElem){
            return false;
        } else {
            for (int i = index; i < nroElem-1; i++) {
                vetor[i] = vetor[i+1];
            }
            vetor[nroElem-1] = null;
            nroElem--;
            return true;
        }
    }

    public boolean removeString(String elemento){
        for (int i = 0; i < nroElem; i++) {
            if(elemento.equals(vetor[i])){
                vetor[i] = vetor[i+1];
                vetor[nroElem-1] = null;
                return true;
            }
        }
        return false;
    }

    public int size(){
        return nroElem;
    }

    @Override
    public String toString() {
        return "ListaEstatica{" +
                "vetor=" + Arrays.toString(vetor) +
                ", nroElem=" + nroElem +
                '}';
    }
}
