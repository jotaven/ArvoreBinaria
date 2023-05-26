import java.util.Scanner;

public class Principal {
    private static final Scanner sc = new Scanner(System.in);
    private static BinaryTree tree = new BinaryTree();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        String opt;
        System.out.println("   ----------------------   ");
        System.out.println("------ ARVORE BINARIA ------");
        System.out.println("   ----------------------   \n");
        do {
            System.out.println("---- Menu ----\n");
            System.out.println("1. Exibir arvore");
            System.out.println("2. Inserir");
            System.out.println("3. Buscar");
            System.out.println("4. Remover");
            System.out.println("5. Deletar arvore");
            System.out.println("0. Sair\n");
            System.out.print("Opção: ");
            opt = sc.next();

            switch (opt) {
                case "1" -> showTree();
                case "2" -> insertTree();
                case "3" -> searchTree();
                case "4" -> removeTree();
                case "5" -> deleteTree();
                case "257" -> secretExample();
            }

        } while (!opt.equals("0"));
    }

    public static void showTree() {


        if (tree.isEmpty()) {
            clear();
            System.out.println("Árvore vazia!");
            return;
        }

        String opt;
        do {
            System.out.println("De que maneira você quer exibir a arvore?");
            System.out.println("\n1. Pre-order");
            System.out.println("2. In-order");
            System.out.println("3. Pos-order");
            System.out.println("4. Graficamente");
            System.out.print("Opção: ");
            opt = sc.next();

            clear();

            switch (opt) {
                case "1" -> {
                    System.out.println("Pre-Order: ");
                    tree.printPreOrder();
                }
                case "2" -> {
                    System.out.println("In-Order: ");
                    tree.printInOrder();
                }
                case "3" -> {
                    System.out.println("Pos-Order: ");
                    tree.printPosOrder();
                }
                case "4" -> {
                    tree.printTree();
                }
                default -> System.out.println("Opção inválida!\n");
            }
        } while (Integer.parseInt(opt) < 1 || Integer.parseInt(opt) > 4);

    }

    public static void insertTree() {
        System.out.print("Qual valor você deseja inserir? ");
        int value = sc.nextInt();
        tree.insert(value);
        clear();
    }

    public static void removeTree() {
        System.out.print("Qual valor você deseja remover? ");
        int value = sc.nextInt();
        tree.remove(value);
        clear();
    }

    public static void deleteTree() {
        System.out.println("Você realmente deseja deletar a arvore? (Y/n)");
        String opt;
        do {
            opt = sc.nextLine().toLowerCase();
        } while (!opt.equals("n") && !opt.equals("y"));
        clear();
        if(opt.equals("n")) {
            return;
        }
        tree = new BinaryTree();
        System.out.println("Arvore deletada com sucesso!");

    }

    public static void searchTree() {
        System.out.print("Qual valor você deseja buscar? ");
        int value = sc.nextInt();
        Node search = tree.search(value);
        clear();
        if (search == null) {
            System.out.println("Valor não encontrado!");
            return;
        }

        System.out.println("Achei!");
        System.out.println(search);
    }

    public static void clear() {
        for (int i=0; i<24; i++) {
            System.out.println();
        }
    }

    public static void secretExample() {
        tree.insert(5);
        tree.insert(2);
        tree.insert(4);
        tree.insert(3);
        tree.insert(8);
        tree.insert(9);
        tree.insert(6);
        tree.insert(10);

        clear();
        System.out.println("Elementos inseridos!");
    }
}
