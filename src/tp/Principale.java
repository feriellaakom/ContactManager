package tp;

public class Principale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

        // Ajouter un contact
        DatabaseOperations.ajouterContact("Dupont", "Jean", "jean.dupont@example.com");

        // Modifier un contact (ID=1, par exemple)
        DatabaseOperations.modifierContact(1, "Dupont", "Jean", "jean.updated@example.com");

        // Supprimer un contact (ID=1, par exemple)
        DatabaseOperations.supprimerContact(1);
		  
	}

}
