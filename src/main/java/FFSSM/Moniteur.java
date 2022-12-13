/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    ArrayList<Embauche> emb = new ArrayList();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
    	Optional<Club> optional;
    	if(emb.isEmpty())
    	{
    		optional = Optional.empty();  
    	}else
    	{
    		optional = Optional.ofNullable(emb.get(emb.size()-1).getEmployeur());
    	}
        return optional;
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
    	Embauche emb1 = new Embauche(debutNouvelle,this,employeur);
    	emb.add(emb1);
    }

    public List<Embauche> emplois() {
         return emb;
    }

}
