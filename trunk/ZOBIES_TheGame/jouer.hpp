#ifndef DEF_JOUER
#define DEF_JOUER


class personnage
{
private:
//Les coordonnées x et y du point
int x, y;
//La vitesse du point
int xVel, yVel;
public:
//Initialisation des variables
personnage();
//Recupere la touche pressee et ajuste la vitesse du point
void handle_input();
//Montre le point sur l'ecran
void show();
};

void setImageUp(void);

void jouerz(SDL_Surface* ecran);


#endif



