public class ArvoreBinaria {
    private Integer info;
    private ArvoreBinaria esquerda;
    private ArvoreBinaria direita;

    public ArvoreBinaria(int info, int ...nums) {
        this.info = info;

        for (int n: nums) inserirElemento(n);
    }

    public void inserirElemento(int valor) {
        if (info == null)
            info = valor;
        else if (valor < info) {
            if (esquerda != null)
                esquerda.inserirElemento(valor);
            else
                esquerda = new ArvoreBinaria(valor);
        } else {
            if (direita != null)
                direita.inserirElemento(valor);
            else
                direita = new ArvoreBinaria(valor);
        }
    }

    public boolean buscaPreOrdem(int valor) {
        if (valor == info) return true;

        return (esquerda != null && esquerda.buscaPreOrdem(valor)) ||
                (direita != null && direita.buscaPreOrdem(valor));
    }

    public void removerMaiorValor() {
        if (direita == null)
            remover(info);
        if (direita.getDireita() == null)
            direita = null;
        else direita.removerMaiorValor();
    }

    public void removerMenorValor() {
        if (esquerda == null)
            remover(info);
        if (esquerda.getEsquerda() == null)
            esquerda = null;
        else esquerda.removerMenorValor();
    }

    public void remover(int valor) {
        if (!buscaPreOrdem(valor)) return;

        if (valor == info) {
            if (direita == null && esquerda == null)
                info = null;
            else {
                info = acharSubstituto();
                if (direita != null) {
                    if (direita.getEsquerda() != null)
                        direita.remover(info);
                    else direita = null;
                }
                else {
                    if (esquerda.getDireita() != null)
                        esquerda.remover(info);
                    else esquerda = null;
                }
            }
        } else if (valor < info) {
            if (esquerda.getInfo() == valor &&
                esquerda.getDireita() == null &&
                esquerda.getEsquerda() == null
            ) esquerda = null;
            else esquerda.remover(valor);
        } else {
            if (direita.getInfo() == valor &&
                direita.getDireita() == null &&
                direita.getEsquerda() == null
            ) direita = null;
            else direita.remover(valor);
        }
    }

    private int acharSubstituto() {
        ArvoreBinaria prox = direita != null ? direita : esquerda;
        int sub = info;
        while (prox != null) {
            sub = prox.getInfo();
            prox = direita != null ? prox.getEsquerda() : prox.getDireita();
        }
        return sub;
    }

    public int getInfo() {
        return info;
    }

    public ArvoreBinaria getEsquerda() {
        return esquerda;
    }

    public ArvoreBinaria getDireita() {
        return direita;
    }
}
