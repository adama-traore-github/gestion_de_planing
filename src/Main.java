import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BDManager db = new BDManager();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Ajouter une tâche");
            System.out.println("2. Afficher les tâches");
            System.out.println("3. Modifier le statut d'une tâche");
            System.out.println("4. Supprimer une tâche");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();  // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    System.out.print("Titre : ");
                    String titre = scanner.nextLine();
                    System.out.print("Description : ");
                    String description = scanner.nextLine();
                    System.out.print("Priorité (1=Haute, 2=Moyenne, 3=Basse) : ");
                    int priorite = scanner.nextInt();
                    db.ajouterTache(titre, description, priorite);
                    break;
                case 2:
                    db.afficherTaches();
                    break;
                case 3:
                    System.out.print("ID de la tâche à modifier : ");
                    int idModifier = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nouveau statut : ");
                    String nouveauStatut = scanner.nextLine();
                    db.modifierStatut(idModifier, nouveauStatut);
                    break;
                case 4:
                    System.out.print("ID de la tâche à supprimer : ");
                    int idSupprimer = scanner.nextInt();
                    db.supprimerTache(idSupprimer);
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, réessayez.");
            }
        } while (choix != 5);

        scanner.close();
    }
}
