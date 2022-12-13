package FFSSM;
import java.time.LocalDate;
import java.util.ArrayList;
public class Plongeur extends Personne {
	private int niveau;
	ArrayList<Licence> licences = new ArrayList();
	private GroupeSanguin groupe;
	
	public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance,int niveau) {
		super(numeroINSEE,nom,prenom,adresse,telephone,naissance);
		this.niveau = niveau;
	}
	
	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public ArrayList<Licence> getLicences() {
		return licences;
	}

	public void setLicences(ArrayList<Licence> licences) {
		this.licences = licences;
	}

	public GroupeSanguin getGroupe() {
		return groupe;
	}

	public void setGroupe(GroupeSanguin groupe) {
		this.groupe = groupe;
	}

	public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance) {
		super(numeroINSEE,nom,prenom,adresse,telephone,naissance);
	}
	
	public void ajouteLicence(String numero, LocalDate delivrance, Club c)
	{
		Licence l1 = new Licence(this,numero, delivrance, c);
		licences.add(l1);
	}
	
	public Licence derniereLicence()
	{
		return licences.get(licences.size()- 1); //Dernier élement
		
		
	}


}
