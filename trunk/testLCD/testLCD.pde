
// --- Programme Arduino ---
// par X. HINAULT - 01/2010 

// --- Que fait ce programme ? ---
/* Affiche des messages texte sur l'afficheur LCD*/

// --- Fonctionnalités utilisées ---
// Utilise un afficheur LCD 4x20 en mode 4 bits 

// --- Circuit à réaliser ---

// Connexion du LCD sur les broches de la carte Arduino 
// Connecter broche RS du LCD sur la broche 2
// Connecter broche E du LCD sur la broche 3
// Connecter broche D4 du LCD sur la broche 4
// Connecter broche D5 du LCD sur la broche 5
// Connecter broche D6 du LCD sur la broche 6
// Connecter broche D7 du LCD sur la broche 7

//**************** Entête déclarative *******
// A ce niveau sont déclarées les librairies, les constantes, les variables...

// --- Inclusion des librairies utilisées ---
#include <LiquidCrystal.h> // Inclusion de la librairie pour afficheur LCD 

// --- Déclaration des constantes ---

// --- constantes des broches ---

const int RS=2; //declaration constante de broche 
const int E=3; //declaration constante de broche 

const int D4=4; //declaration constante de broche 
const int D5=5; //declaration constante de broche 
const int D6=6; //declaration constante de broche 
const int D7=7; //declaration constante de broche

char *a="Je t'aime";


// --- Déclaration des variables globales ---

// --- Initialisation des fonctionnalités utilisées ---
LiquidCrystal lcd(RS, E, D4, D5, D6, D7);// initialisation LCD en mode 4 bits 

//**************** FONCTION SETUP = Code d'initialisation *****
// La fonction setup() est exécutée en premier et 1 seule fois, au démarrage du programme

void setup()   { // debut de la fonction setup()
// --- ici instructions à exécuter au démarrage --- 
Serial.begin(9600);
lcd.begin(16,2); // Initialise le LCD avec 20 colonnes x 4 lignes 

delay(10); // pause rapide pour laisser temps initialisation

// Test du LCD

lcd.print("LCD OK") ; // affiche la chaîne texte - message de test
delay(2000); // pause de 2 secondes

lcd.clear(); // // efface écran et met le curseur en haut à gauche
delay(10); // pour laisser temps effacer écran

} // fin de la fonction setup()
// ********************************************************************************

//*************** FONCTION LOOP = Boucle sans fin = coeur du programme *************
// la fonction loop() s'exécute sans fin en boucle aussi longtemps que l'Arduino est sous tension

void loop(){ // debut de la fonction loop()

for(int i=0; i<9;i++)
  {
  lcd.setCursor(i,0);
  lcd.print(a[i]);
  delay(100);
  }
if (Serial.available() > 0)
{ 
  if(Serial.read()=='M') 
  {Serial.println("OK");
    lcd.setCursor(0,1);
  lcd.print("<3 <3 <3");
  delay(500);
  }
}

lcd.clear(); // // efface écran et met le curseur en haut à gauche
delay(100); // pour laisser temps effacer écran

// --- ici instructions à exécuter par le programme principal --- 

} // fin de la fonction loop() - le programme recommence au début de la fonction loop sans fin
// ********************************************************************************

// --- Fin programme ---

// --- Mémo instructions ---


// ----- memo LCD --- 
// LiquidCrystal(rs, enable, d4, d5, d6, d7) ; // initialisation 4 bits
// lcd.begin(cols, rows); // initialisation nombre colonne/ligne
// 
// lcd.clear(); // efface écran et met le curseur en haut à gauche
// lcd.home(); // repositionne le curseur en haut et à gauche SANS effacer écran
// 
// lcd.setCursor(col, row) ; // positionne le curseur à l'endroit voulu (colonne, ligne) (1ère=0 !) 
// lcd.print("texte") ; // affiche la chaîne texte
// 
// lcd.cursor() ; // affiche la ligne de base du curseur 
// lcd.noCursor() ; // cache le curseur 
// lcd.blink() ; // fait clignoter le curseur
// lcd.noBlink() ;// stoppe le clignotement du curseur
// lcd.noDisplay() ; // éteint le LCD sans modifier affichage
// lcd.display() ; // rallume le LCD sans modif affichage
// 
// lcd.scrollDisplayLeft(); // décale l'affichage d'une colonne vers la gauche
// lcd.scrollDisplayRight(); // décale l'affichage d'une colonne vers la droite 
// lcd.autoscroll() ; // les nouveaux caractères poussent les caractères déjà affichés
// noAutoscroll(); // stoppe le mode autoscroll


 
