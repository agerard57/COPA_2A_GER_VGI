package clients;

import java.util.Scanner;

import Main_app.Choix;

public class ModifierClient{
	protected int selection;
	 public static void MenuModifierClient() {
		int selection = 0;
			System.out.println("Quel champ modifier ?");

			do
			{
				System.out.println("[1] Le nom");
				System.out.println("[2] Le prénom");
				
			System.out.println("Utilisez le clavier numérique pour faire votre choix...");
			Scanner LireConsole = new Scanner(System.in);
			selection = LireConsole.nextInt();
//			LireConsole.close();
				
				switch (selection)
				{
				
				case 1 :
					Choix.choixMenuClientAjouter1();
					break;
					
				case 2 :
					Choix.choixMenuClientAjouter2();
					break;	
					
			
					
				default :
					System.out.println ("La séléction est incorrecte !");
					}
				return;
			} while (selection != 2);
	 }

}
