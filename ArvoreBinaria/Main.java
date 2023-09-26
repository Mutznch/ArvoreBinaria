public class Main {
    public static void main(String[] args) {
        ArvoreBinaria ab = new ArvoreBinaria(10,2,1,3,23,15,23,5,4,14,20);

        System.out.println(ab.buscaPreOrdem(2));
        ab.remover(2);
        System.out.println(ab.buscaPreOrdem(2));
    }
}
