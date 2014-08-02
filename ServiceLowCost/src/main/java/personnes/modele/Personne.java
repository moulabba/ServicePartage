package personnes.modele;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "personne", catalog = "serviceLowCost")
public class Personne implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer personneId;
	
	private String 	nom;
	private String 	prenom;
	private String 	email;
	private String 	login;
	private String 	password;
	private boolean isAdmin;
	private boolean archive;
	private String 	ville;
	private String 	backup;
	
	public Personne() {
	}

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	@Column ( name = "login", unique = true)
	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Personne_ID", unique = true, nullable = false)
	public Integer getPersonneId() {
		return this.personneId;
	}

	@Column(name = "nom")
	public String getNom() {
		return this.nom;
	}

	@Column(name = "prenom")
	public String getPrenom() {
		return this.prenom;
	}
	
	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin
	 *            the isAdmin to set
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void setPersonneId(Integer personneId) {
		this.personneId = personneId;
	}

	public void setNom (String nom) {
		this.nom = nom;
	}

	public void setPrenom (String prenom) {
		this.prenom = prenom;
	}

	/**
	 * 
	 */
	public void setArchive (boolean archive){
		this.archive = archive;
	}
	/**
	 * 
	 * @return
	 */
	@Column ( name = "archive")
	public boolean getArchive(){
		return this.archive;
	}

	@Column ( name = "ville")
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Column ( name = "backup" )
	public String getBackup() {
		return backup;
	}

	public void setBackup(String backup) {
		this.backup = backup;
	}
	
	@Transient
	public String getNomPrenom(){
		return this.getNom()+" "+this.getPrenom();
	}
}
