/*
constantes.h
------------


Rôle : définit des constantes communes à tout le programme (taille de la fenêtre...)
*/

#ifndef DEF_CONSTANTES
#define DEF_CONSTANTES


    #define LARGEUR_FENETRE     480
    #define HAUTEUR_FENETRE     640
    #define RESOLUTION     16
    #define TAILLE_CARAC_MENU     30
    #define SPSIZE     34

    #define P_HEIGHT 32
    #define P_WIDTH 32

    //Le nombre de frames par seconde
    const int FRAMES_PER_SECOND = 20;

    enum {MAIN,COUTEAU,GUN};

    enum {HAUT, BAS, GAUCHE, DROITE};
    enum {VIDE, MUR, CAISSE, OBJECTIF, MARIO, CAISSE_OK};

#endif

