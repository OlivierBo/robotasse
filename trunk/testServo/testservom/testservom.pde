
// --- Programme Arduino ---
// par X. HINAULT - 01/2010 

// --- Que fait ce programme ? ---
/* Test de la position d'un servomoteur par saisie directe de la largeur d'impulsion dans le Terminal côté PC*/

// --- Fonctionnalités utilisées ---
// Utilise la connexion série vers le PC 
// Utilise un servomoteur 

// --- Circuit à réaliser ---
// Connexion série entre la carte Arduino et le PC (utilise les broches 0 et 1)  
// Connecter Broche de commande d'un Servomoteur sur la broche 2 (configurée en sortie)

//**************** Entête déclarative *******
// A ce niveau sont déclarées les librairies, les constantes, les variables...

// --- Inclusion des librairies utilisées ---

#include <Servo.h> // librairie pour servomoteur

// --- Déclaration des constantes ---

// --- constantes des broches ---

const int SERVO=2; //declaration constante de broche 


// --- Déclaration des variables globales ---

int ReceptionOctet=0; // variable de stockage des octets reçus par port série
int ReceptionNombre=0; // variable de calcul du nombre reçu par port série
int impulsion=1500; // variable pour impulsion - valeur médiane initiale

// --- Initialisation des fonctionnalités utilisées ---

Servo mon_servo;  // crée un objet servo pour contrôler le servomoteur

//**************** FONCTION SETUP = Code d'initialisation *****
// La fonction setup() est exécutée en premier et 1 seule fois, au démarrage du programme

void setup()   { // debut de la fonction setup()

// --- ici instructions à exécuter au démarrage --- 

mon_servo.attach(SERVO);  // attache l'objet servo à la broche de commande du servomoteur

Serial.begin(9600); // initialise connexion série à 115200 bauds
// IMPORTANT : régler le terminal côté PC avec la même valeur de transmission 

pinMode(SERVO, OUTPUT); //met la broche en sortie 



} // fin de la fonction setup()
// ********************************************************************************

//*************** FONCTION LOOP = Boucle sans fin = coeur du programme *************
// la fonction loop() s'exécute sans fin en boucle aussi longtemps que l'Arduino est sous tension

void loop(){ // debut de la fonction loop()

// --- ici instructions à exécuter par le programme principal --- 


//--- lecture d'un nombre reçu par le Terminal et positionnement du servomoteur --- 
if (Serial.available()>0) { // si caractère dans la file d'attente

  //---- lecture du nombre reçu 
  while (Serial.available()>0) { // tant que buffer pas vide pour lire d'une traite tous les caractères reçus

    ReceptionOctet= Serial.read(); // renvoie le 1er octet présent dans la file attente série (-1 si aucun) 
    ReceptionOctet=ReceptionOctet-48; // transfo valeur ASCII en valeur décimale

    if ((ReceptionOctet>=0)&&(ReceptionOctet<=9))     ReceptionNombre = (ReceptionNombre*10)+ReceptionOctet; 
    // si valeur reçue correspond à un chiffre on calcule nombre

    delay(1); // pause pour laisser le temps au Serial.available de recevoir les caractères

  } // fin while

   Serial.print ("Nombre recu= ");
   Serial.println(ReceptionNombre); // affiche valeur numerique entière ou à virgule au format décimal


   //----- positionnement du servomoteur en fonction de la largeur d'impulsion demandée 
   impulsion=ReceptionNombre; 

    if (impulsion>2600)impulsion=2600; // pour éviter valeur supérieure à 2600 = position maxi possible servomoteur
    if (impulsion<300)impulsion=300; // pour éviter valeur inférieure à 300 = position maxi possible servomoteur

    mon_servo.writeMicroseconds(impulsion); // génère l'impulsion de la durée voulue en µs pour le servomoteur

    Serial.print ("Impulsion servomoteur = ");
    Serial.print(impulsion); // affiche valeur numerique entière 
    Serial.println (" microsecondes ");

    delay (1000); //entre chaque changement de position

    ReceptionNombre=0; // réinitialisation de la variable de calcul du nombre reçu

} // end if


} // fin de la fonction loop() - le programme recommence au début de la fonction loop sans fin
// ********************************************************************************

// --- Fin programme ---
