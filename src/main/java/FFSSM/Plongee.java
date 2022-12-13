/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

	private Site lieu;
	private Moniteur chefDePalanquee;
	private LocalDate date;
	private int profondeur;
	private int duree;
	private ArrayList<Plongeur> plongeurs = new ArrayList();

	public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
	}

	public void ajouteParticipant(Plongeur participant) {
		plongeurs.add(participant);
	}

	public LocalDate getDate() {
		return date;
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {
		int test = 0;
		boolean result = true;
		for(Plongeur p : plongeurs)
		{
			if(p.derniereLicence().estValide(date) != true)
			{
				test = 1;
			}
			
			if(test != 0)
			{
				result = false;
			}
		}return result;
	}

}
