package tp;

import java.io.Serializable;

public class Contact implements Serializable {
	  private String nom;
	   private String prenom;
	   private String email;
	   private String telephone;

	    // Constructeur
	   public Contact(String nom, String prenom, String email, String telephone) {
	        this.nom = nom;
	        this.prenom = prenom;
	        this.email = email;
	        this.telephone = telephone;
	    }

	    // Getters et Setters
	    public String getNom() { return nom; }
	    public void setNom(String nom) { this.nom = nom; }

	    public String getPrenom() { return prenom; }
	    public void setPrenom(String prenom) { this.prenom = prenom; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getTelephone() { return telephone; }
	    public void setTelephone(String telephone) { this.telephone = telephone; }

	    // Méthode pour afficher un contact
	    @Override
	    public String toString() {
	        return "Nom: " + nom + ", Prénom: " + prenom + ", Email: " + email + ", Téléphone: " + telephone;
	    }

	    // Convertir en format CSV pour l'enregistrement
	    public String toCSV() {
	        return nom + "," + prenom + "," + email + "," + telephone;
	    }

	    // Convertir une ligne CSV en objet Contact
	    public static Contact fromCSV(String line) {
	        String[] data = line.split(",");
	        if (data.length == 4) {
	            return new Contact(data[0], data[1], data[2], data[3]);
	        }
	        return null;
	    }
}
