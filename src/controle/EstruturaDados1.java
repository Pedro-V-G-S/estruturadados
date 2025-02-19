/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

/**
 *
 * @author laboratorio
 */

// Interface que define a estrutura de dados
interface EstruturaDados {
    void adicionar(int elemento);
    void exibir();
}

// Classe para manipular arrays (estrutura estática)
class EstruturaArray implements EstruturaDados {
    private int[] listan;          // Nome do array
    private int listatamanho;      // Definição do tamanho da lista     

    // Construtor da classe
    // Serve para inicializar os objetos e define o começo com 0
    public EstruturaArray(int capacidadeLista) {
        this.listan = new int[capacidadeLista];
        this.listatamanho = 0;
    }

    @Override
    public void adicionar(int elemento) {  
        if (listatamanho < listan.length) {  
            // listan.length: retorna o tamanho total do array
            listan[listatamanho] = elemento; 
            listatamanho++; 
        } else {
            System.out.println("Lista cheia."); // Como a lista é definida para um tamanho fixo, essa mensagem aparece ao tentar adicionar além da capacidade.
        }
    }

    @Override
    public void exibir() {
        System.out.print("Array: ");
        for (int i = 0; i < listatamanho; i++) {
            System.out.print(listan[i] + " ");
        }
        System.out.println();
    }
}

// Classe para representar um nó de uma lista ligada
class Lista {
    int numero;
    Lista proximo;

    public Lista(int numero) {
        this.numero = numero;
        this.proximo = null;
    }
}

// Classe para manipular listas ligadas (estrutura dinâmica)
class EstruturaListaLigada implements EstruturaDados {
    private Lista listaativa;      // Estrutura dinâmica: a lista ligada

    // Construtor inicializando a lista como vazia
    public EstruturaListaLigada() {
        this.listaativa = null;
    }

    @Override
    public void adicionar(int elemento) {
        Lista novaLista = new Lista(elemento);
        
        if (listaativa == null) {
            // A lista começa vazia e adiciona o número
            listaativa = novaLista;
        } else {
            // Percorre a lista até encontrar o último elemento e adiciona o próximo
            Lista atual = listaativa;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novaLista;
        }
    }

    @Override
    public void exibir() {
        System.out.print("Lista Ligada: ");
        Lista atual = listaativa;
        while (atual != null) {
            System.out.print(atual.numero + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

// Classe gerenciadora que permite trocar a estrutura de dados dinamicamente
class GerenciadorEstruturas {
    private EstruturaDados estrutura;

    public void setEstrutura(EstruturaDados estrutura) {
        this.estrutura = estrutura;
    }

    public void adicionar(int elemento) {
        if (estrutura != null) {
            estrutura.adicionar(elemento);
        } else {
            System.out.println("Nenhuma estrutura de dados definida!");
        }
    }

    public void exibir() {
        if (estrutura != null) {
            estrutura.exibir();
        } else {
            System.out.println("Nenhuma estrutura de dados definida!");
        }
    }
}

// Classe principal para testar as implementações
public class EstruturaDados1 {
    public static void main(String[] args) {
        GerenciadorEstruturas gerenciador = new GerenciadorEstruturas();

        // Testando com Array (estrutura estática)
        System.out.println("Usando Array:");
        gerenciador.setEstrutura(new EstruturaArray(5));
        gerenciador.adicionar(7);
        gerenciador.adicionar(2);
        gerenciador.adicionar(3);
        gerenciador.adicionar(4);
        gerenciador.adicionar(5);
        gerenciador.adicionar(6); // Deve mostrar "Lista cheia."
        gerenciador.exibir();

        // Testando com Lista Ligada (estrutura dinâmica)
        System.out.println("\nUsando Lista Ligada:");
        gerenciador.setEstrutura(new EstruturaListaLigada());
        gerenciador.adicionar(10);
        gerenciador.adicionar(20);
        gerenciador.adicionar(30);
        gerenciador.adicionar(40);
        gerenciador.adicionar(50);
        gerenciador.exibir();
    }
}
