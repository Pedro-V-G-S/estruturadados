/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

/**
 *
 * @author laboratorio
 */

// Classe para representar um nó de uma lista ligada
class Lista {
    int numero;
    Lista proximo;

    public Lista(int dado) {
        this.numero = dado;
        this.proximo = null;
    }
}

public class EstruturaDados {
    private int[] listan;          // Nome do array
    private int listatamanho;      // definição do tamanho da lista     
    private Lista listaativa;      // Estrutura dinamica a lista ligada 

    //construtor da classe
    //serve para inicializar os objetos e defini o começo com 0 e null
    public EstruturaDados(int capacidadeLista) {
        this.listan = new int[capacidadeLista];
        this.listatamanho = 0;
        this.listaativa = null;
    }

    // Método para adicionar um elemento ao array
    public void adicionarArray(int elemento) {  //nome do metodo e mais um dado para  
        if (listatamanho < listan.length) {  //OOBSERVAÇÃO: listan.length: A propriedade length de um array em Java retorna o tamanho total do array
            listan[listatamanho] = elemento; //define o parametro = elemento
            listatamanho++; //incremento
        } else {
            System.out.println("Lista cheia."); //Como a lista é definida para 5 esta menssagem aparece quanto tento adicionar o 6 elemnto.
        }
    }

    // Método para adicionar um elemento à lista ligada ou dinamica
    public void adicionarListaAtiva(int elemento) {
        Lista novaLista = new Lista(elemento);
        
        if (listaativa == null) {
            // A lista começa vazia e adiciona o numero
            listaativa = novaLista;
        } else {
            // estrutara para verificar a posição da lista e adiciona o proximo enquanto tiver para numero para adicona no caso 10 20 30 40 50 
            Lista atual = listaativa;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novaLista;
        }
    }

    // Método para exibir os elementos ou numeros da lista
    public void exibirArray() {
        System.out.print("Os numeros são: ");
        for (int i = 0; i < listatamanho; i++) {
            System.out.print(listan[i] + " ");
        }
        System.out.println();
    }

    // Método para exibir os elementos da lista ligada ou lsita dinamica
    public void exibirListaAtiva() {
        System.out.print("Lista Ativa: ");
        Lista atual = listaativa;
        while (atual != null) {
            System.out.print(atual.numero + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        EstruturaDados estrutura = new EstruturaDados(5); // uma duvida que tive era onde na lista estatica era delimitado o numero de vezes.
        

        // Adicionando elementos ao array
        estrutura.adicionarArray(7);
        estrutura.adicionarArray(2);
        estrutura.adicionarArray(3);
        
        // Adicionando elementos à lista ligada
        estrutura.adicionarListaAtiva(10);
        estrutura.adicionarListaAtiva(20);
        estrutura.adicionarListaAtiva(30);
        estrutura.adicionarListaAtiva(40);
        estrutura.adicionarListaAtiva(50);

        // Exibindo os elementos
        estrutura.exibirArray();
        estrutura.exibirListaAtiva();

        // adiciona mais elementos e estorando o a limitação de 5 elementos
        estrutura.adicionarArray(4);
        estrutura.adicionarArray(5);
        estrutura.adicionarArray(6); // Determinamos no começo no metodo main que o maximo de elementos é 5 então aqui vai exibir a mensagem "lista lotadada"

        // Exibindo novamente os elementos testando o estrutura.adicionarArray(6); para ver se entra na lista 
        estrutura.exibirArray();
    }
}

/*
Explique, com código, como a orientação a objetos pode melhorar a manipulação de estruturas de dados.

RESPOSTA: na programação orientada a objeto as estruturas são mais faceis de entender usando os conceitos 
como herança encapsulamento e outros o codigo é mais bem entendido.
*/