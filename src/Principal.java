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
            System.out.println("5. Esvaziar arvore");
            System.out.println("0. Sair\n");
            System.out.print("Opção: ");
            opt = sc.next();
            sc.nextLine();

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
            sc.nextLine();
            clear();

            String stringOpt;
            do {
                System.out.println("Qual dado que deseja?");
                System.out.println("1. Nome");
                System.out.println("2. RGM");
                System.out.print("Opção: ");
                stringOpt = sc.nextLine();
                clear();
            } while (!stringOpt.equals("1") && !stringOpt.equals("2"));

            boolean stringBool = stringOpt.equals("1");

            switch (opt) {
                case "1" -> {
                    System.out.println("Pre-Order: ");
                    tree.printPreOrder(stringBool);
                }
                case "2" -> {
                    System.out.println("In-Order: ");
                    tree.printInOrder(stringBool);
                }
                case "3" -> {
                    System.out.println("Pos-Order: ");
                    tree.printPosOrder(stringBool);
                }
                case "4" -> {
                    tree.printTree();
                }
                default -> System.out.println("Opção inválida!\n");
            }
        } while (Integer.parseInt(opt) < 1 || Integer.parseInt(opt) > 4);

    }

    public static void insertTree() {
        System.out.print("Qual o nome do novo aluno? ");
        String name = sc.nextLine();
        System.out.printf("Qual o rgm de %s? ", name);
        int rgm = sc.nextInt();
        tree.insert(new Student(name, rgm));
        clear();
    }

    public static void removeTree() {
        System.out.print("Qual valor você deseja remover? ");
        int value = sc.nextInt();
        tree.remove(value);
        clear();
    }

    public static void deleteTree() {
        System.out.println("Você realmente deseja esvaziar a arvore? (Y/n)");
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
        System.out.print("Qual o rgm do aluno que você deseja buscar? ");
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
        tree.insert(new Student("João", 50));
        tree.insert(new Student("Pedro", 12));
        tree.insert(new Student("José", 156));
        tree.insert(new Student("Álvaro", 23));
        tree.insert(new Student("Bruna", 1));
        tree.insert(new Student("Marcos", 54));
        tree.insert(new Student("Richarlyson", 7));

        clear();
        System.out.println("Elementos inseridos!");
    }
}
