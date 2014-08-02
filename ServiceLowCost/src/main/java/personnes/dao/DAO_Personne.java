package personnes.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import personnes.modele.Personne;


import utiles.HibernateUtil;

public class DAO_Personne {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();


	/**
	 * Cette méthode permet de créer un nouvau utilisateur.
	 * 
	 * @param name
	 *            : Le nom du collaborateur
	 * @param email
	 *            : l'email du collaborateur
	 * @param login
	 *            : le login du collaborateur
	 * @param password
	 *            : le mot de passe du collaborateur
	 * @return true si tout se passe bien, et false sinon.
	 */
	public boolean ajouterPerson(String nom, String prenom, String email,
			String ville, String backup, String login, String password,
			boolean isAdmin) {

		try {
			System.out.println("Maven + Hibernate + MySQL");
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"spring.xml");
			Personne personne = (Personne) context.getBean("personne");
			session = HibernateUtil.checkSession(session);
			org.hibernate.Transaction tx = session.beginTransaction();

			// Création de l'object personne
			personne.setNom(nom);
			personne.setPrenom(prenom);
			personne.setEmail(email);
			personne.setVille(ville);
			personne.setBackup(backup);
			personne.setLogin(login);
			personne.setPassword(password);
			personne.setAdmin(isAdmin);
			personne.setArchive(false);

			// Persistance en base de données
			session.save(personne);
			tx.commit();
			((ConfigurableApplicationContext) context).close();
			return true;
		} catch (Exception e) {
			System.err
					.println("Erreur lors de l'ajout du l'utilisateur. Message : "
							+ e.getMessage());
			return false;
		}
		
	}

	public ArrayList<Personne> getAllPersonne(){
		
		
		try {
			session = HibernateUtil.checkSession(session);
			org.hibernate.Transaction tx = session.beginTransaction();

			// Exécution de la requête
			Query query = session
					.createQuery(" FROM Personne WHERE archive = 0");
			ArrayList<Personne> list = (ArrayList<Personne>) query.list();

			tx.commit();
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
