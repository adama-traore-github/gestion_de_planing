import java.sql.*;

public class BDManager {

    private Connection conn;

    public BDManager() {
        try {
            // Remplacez par vos informations de connexion
            conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/gestion_planning", "postgres", "nostra");
            System.out.println("Connexion à PostgreSQL réussie !");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }

    public void ajouterTache(String titre, String description, int priorite) {
        String query = "INSERT INTO taches (titre, description, priorite, statut) VALUES (?, ?, ?, 'Non commencé')";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, titre);
            pstmt.setString(2, description);
            pstmt.setInt(3, priorite);
            pstmt.executeUpdate();
            System.out.println("Tâche ajoutée avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout : " + e.getMessage());
        }
    }

    public void afficherTaches() {
        String query = "SELECT * FROM taches";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Titre : " + rs.getString("titre"));
                System.out.println("Description : " + rs.getString("description"));
                System.out.println("Priorité : " + rs.getInt("priorite"));
                System.out.println("Statut : " + rs.getString("statut"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage : " + e.getMessage());
        }
    }

    public void modifierStatut(int id, String nouveauStatut) {
        String query = "UPDATE taches SET statut = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nouveauStatut);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Statut de la tâche modifié avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du statut : " + e.getMessage());
        }
    }

    public void supprimerTache(int id) {
        String query = "DELETE FROM taches WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Tâche supprimée avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }
}
