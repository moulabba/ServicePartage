package com.Soufiane.test;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import personnes.dao.DAO_Personne;
import personnes.modele.Personne;




@ManagedBean(name = "ajouterPersonne")
public class AjouterPersonne {
	
	private ArrayList<Personne> listPersonnes; 
	private String password;
	public String ajouterPersonne1(){
		
		//DAO_Personne daoPersonne= new DAO_Personne();
		//daoPersonne.ajouterPerson("moulabbi", "soufiane", "soufiane.moulabbi@gmail.com", "sale", "0", "admin", "ad", true);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("soufiane", "test");
		
		System.out.println(session.getAttribute("soufiane"));
		FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL,
                "Invalid Login!",
                "Please Try Again!"));
		return "success";  
	}
	
		

	public ArrayList<Personne> getListPersonnes() {

		DAO_Personne daoPersonne = new DAO_Personne();
		
		for (int i = 0; i < daoPersonne.getAllPersonne().size(); i++) {
			
		}
		return daoPersonne.getAllPersonne();
	}

	public void setListPersonnes(ArrayList<Personne> listPersonnes) {
		this.listPersonnes = listPersonnes;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
}