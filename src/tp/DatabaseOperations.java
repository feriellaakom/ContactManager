package tp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOperations {
	public static void ajouterContact(String nom, String prenom, String email) {
        String query = "INSERT INTO contacts (nom, prenom, email) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, email);
            
            int result = pstmt.executeUpdate();
            
            if (result > 0) {
                System.out.println("✅ Contact ajouté avec succès !");
            } else {
                System.out.println("❌ Échec de l'ajout du contact.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de l'ajout du contact.");
            e.printStackTrace();
        }
    }

    // Modifier un contact (par ID)
    public static void modifierContact(int id, String nom, String prenom, String email) {
        String query = "UPDATE contacts SET nom = ?, prenom = ?, email = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, email);
            pstmt.setInt(4, id);
            
            int result = pstmt.executeUpdate();
            
            if (result > 0) {
                System.out.println("✅ Contact modifié avec succès !");
            } else {
                System.out.println("❌ Échec de la modification du contact.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la modification du contact.");
            e.printStackTrace();
        }
    }

    // Supprimer un contact (par ID)
    public static void supprimerContact(int id) {
        String query = "DELETE FROM contacts WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, id);
            
            int result = pstmt.executeUpdate();
            
            if (result > 0) {
                System.out.println("✅ Contact supprimé avec succès !");
            } else {
                System.out.println("❌ Échec de la suppression du contact.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la suppression du contact.");
            e.printStackTrace();
        }
    }



    public static void listerContacts() {
        String query = "SELECT * FROM contacts";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn = null;
			Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Liste des contacts :");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nom: " + rs.getString("nom"));
                System.out.println("Prénom: " + rs.getString("prenom"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("--------");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

   
    	
    	
    	
    }
    

	
	
	


