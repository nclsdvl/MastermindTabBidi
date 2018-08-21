/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermindtabbidi;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public class MastermindTabBidi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        int count = 0;
        String couleurDispo[] = {"vert", "blanc", "jaune", "noir", "rouge", "cyan"};
        String solution[] = /*new String[4];*/ {"vert", "cyan", "blanc", "vert"};
        String proposition[] = new String[4];
        String tab[][] = new String[4][4];
        int BP = 0;
        int MP = 0;
        
        
//----------------generation aléatoire d'un tableau solution[4] contenant la solution------------//
        
        /*int nbAlea1 = (int) (Math.random() * couleurDispo.length);
        int nbAlea2 = (int) (Math.random() * couleurDispo.length);
        int nbAlea3 = (int) (Math.random() * couleurDispo.length);
        int nbAlea4 = (int) (Math.random() * couleurDispo.length);
        
        solution[0] = couleurDispo[nbAlea1];
        solution[1] = couleurDispo[nbAlea2];
        solution[2] = couleurDispo[nbAlea3];
        solution[3] = couleurDispo[nbAlea4];*/
        
        
// -------------------------------Regles du jeu--------------------------//



        System.out.println ("Hello! Jouons au MasterMind!");
        System.getProperty( "line.separator" );
        System.out.println ("Tu as 10 essais pour trouver la combinaison de 4 couleurs que j'ai choisi");   
        System.out.println ("Tu as le choix parmi ces 6 couleurs :");
        System.out.println ("bleu, rouge, jaune, vert, blanc, noir");
        System.out.println ("A chaque essai je te donnerais le nombre de couleurs exacts bien placées ainsi que le nombre de couleurs exacts mais mal placées.");
        System.out.println ("Tes reponses doivent etre donné selon le meme format que cet exemple : jaune bleu rouge jaune");
        System.out.println ("");
        System.out.println ("C'est parti !");
        
        boolean result = Arrays.equals(solution, proposition);  
        
        while (count<10 && result == false){


/*-----------------------Scan, enregistrement, et mise en tableau de la reponse-----------------------*/

            System.out.println ("Quelle est ta " +(count+1)+"° proposition?");
            Scanner sc = new Scanner(System.in);
            String chaineProposition = sc.nextLine();
            proposition = chaineProposition.split(" ");
                
            
/*----REMPLISSAGE DE LA DIAGONALE DE SOLUTION ET MISE A 0 DES LIGNES ET DES COLONNES CORRESPONDANTES ----*/
/* ---------------------------- + COMPTAGE DES REPONSES BIEN PLACEES-------------------------------------*/
            BP = 0;
            for (int i=0; i<solution.length; i++){

                
                    
                    if ( solution[i].equals(proposition[i])){
                       
                        BP++;
                        for (int k=0; k<solution.length; k++){
                            tab[i][k] = "0";
                            tab[k][i] = "0";
                        }
                    
                    }
            }
   
        System.out.println("Vous avez "+BP+ " bonne(s) couleur(s) bien placée(s)");
            
/*----------REMPLISSAGE DU RESTE DU TABLEAU + COMPTAGE DES REPONSES MAL PLACEES--------------------*/
        MP = 0;   
            for (int i=0; i<solution.length; i++){
                for (int j=0; j<proposition.length; j++){
                
                    /*if (tab[i][j] != "0" && proposition[i].equals(solution[j])){
                        tab[i][j] = "1";
                        MP++;*/
                    
                    if (tab[i][j] == null ){ 
                        if(proposition[i].equals(solution[j])){
                         
                        MP++; 
                        for (int k=0; k<solution.length; k++){
                            tab[i][k] = "0";
                            tab[k][i] = "0";
                        }
                        }
                    
                       
                    }
                }
            }
        System.out.println("Vous avez "+ MP + " bonne(s) couleur(s) mal placée(s)");
        System.out.println("");   
        result = Arrays.equals(solution, proposition);
        count++;
        }
        
    if (result == true) {
            System.out.println ("FELICITATION ! ");
            System.out.println (" ");
            System.out.println ("la solution était bien : " + solution[0]+" "+ solution[1]+ " "+solution[2]+" "+solution[3]);
            
            if (count<5){
                System.out.println (" ");
               System.out.println ("En moins de 5 essais Tu es un BOSS !!!"); 
            }
            if ( count<8 && count >= 5){
                System.out.println (" ");
                System.out.println ("En "+(count)+" essais tu t'en sors pas trop mal !");
            }
            if (count>=8) {
                System.out.println (" ");
                System.out.println ("En "+(count)+" essais bof tu peux mieux faire...");
            }
         }

        else if (count >= 10){
            System.out.println ("PERDU!!!! C'est acté tu es vraiment une GROSSE TANCHE!!!!!!!!!!!");
            System.out.println (" ");
            System.out.println ("la solution était : " + solution[0]+" "+ solution[1]+ " "+solution[2]+" "+solution[3]);
        }
    }
    
}   

