package gestion_location_auto;

import java.util.Scanner;
import com.mysql.jdbc.Driver.*;
import java.io.*;

public class Gestion_Location_Auto {

    static private void pressEnterToContinue() { 
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {} 
    }
    
    public static void main(String[] args) {
        CreateDB db = new CreateDB();
        CreateTables CT = new CreateTables();
        insertVoitures IC = new insertVoitures();
        LogIn login = new LogIn();
        
        int choix = 0;
        Scanner masaisie = new Scanner(System.in,"UTF-8");
	 
	do {
	        System.out.println(" >> GESTION DE LOCATION AUTO  << \n");
	 	System.out.println("      1. Afficher les voitures disponibles   ");
                System.out.println("      2. Afficher les voitures plus reservees   ");
                System.out.println("      3. Ajouter un reservation   ");
                System.out.println("      4. Annuler cet reservation   ");
                System.out.println("      5. Rechercher les voitures plus cher   ");
	 	System.out.println("      6. Afficher la liste de tout les voitures");
                System.out.println("      7. Supprimer la base de donnees des etudiants  ");
                System.out.println("      0. Quitter l application  ");                
                                System.out.print("\n Entrez votre choix :  ");
	 	try
                 {
                  choix = masaisie.nextByte();
                
                 }catch(Exception e)
                  {
                     System.out.println("  Erreur, choix imprevu !!!!!   -------");
                     e.printStackTrace();
                  } 
	 	switch(choix)
	 	{
	 		case 1 : 
	 		        //system("cls"); 		  
                                System.out.println("\n ++++++ Choix 1 : Les voitures disponibles:  ++++++ \n");
                                ShowCarsDisponible SCD = new ShowCarsDisponible();
                                pressEnterToContinue();
                            	break;
			 
			 case 2 : 
			 	//system("cls");
                                System.out.println("\n ++++++ Choix 2 : Les VOITURES plus reservees  ++++++ \n");
                                ShowMoreReserve SMR = new ShowMoreReserve();
                                pressEnterToContinue();
                            	break;
			 case 3 : 
			 	System.out.println("\n ++++++ Choix 3 : Ajouter un RESERVATION  ++++++ \n");
                                addRes AD = new addRes();
                                pressEnterToContinue();
                                break;
			 /*case 4 : 
			 	System.out.println("\n ++++++ Choix 4 : Annuler un reservation  ++++++ \n");
                                updtnote unote = new updtnote();
                                pressEnterToContinue();
                                break;*/
			 case 5 : 
			 	System.out.println("\n ++++++ Choix 5 : Classification des voitures par le PRIX  ++++++ \n");
                                PlusCher PC = new PlusCher();
                                pressEnterToContinue();
                                break;
			 case 6 : 
			 	System.out.println("\n ++++++ Choix 6 : La liste de la session de rattrapage - CR  ++++++ \n");
                                ShowAllCars SAC = new ShowAllCars();
                                System.out.println("\n");
                                pressEnterToContinue();
                                break;
                         case 7 : 
			 	System.out.println("\n ++++++ Choix 7 : Recherche l'�tudiant major de la promo liste de la session de rattrapage - CR  ++++++ \n");
                                DeleteDB DDB = new DeleteDB();
                                System.out.println("\n");
                                pressEnterToContinue();
                                break;
			 case 0: {
			 	//system("cls");
			 	System.out.println("\n   Merci \n   -------   Fin de Programme   -------");
			 	
				break;
			 }
                         default : System.out.println("  Erreur, choix imprevu !!!!!   -------");
		 
                }    
              
	 } while(choix!=0);		

    }
    
}


