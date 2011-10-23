#include <stdlib.h>
#include <stdio.h>
#include <SDL/SDL.h>
#include <SDL/SDL_image.h>
#include <SDL/SDL_ttf.h>
#include "constantes.h"
#include "jouer.hpp"

SDL_Event eventJ;

SDL_Rect clip[12];
SDL_Rect clipCout[12];
SDL_Rect clipCoutUp[12];
SDL_Rect clipGun[12];
SDL_Rect clipGunUp[12];

void jouerz(SDL_Surface* ecran)
{

bool donem=false;
SDL_Surface *niveau1 = NULL;
SDL_Rect dstrect;

niveau1 = IMG_Load("niveau1.jpg");
    if (!niveau1)
    {
        printf("Unable to load image: %s\n", SDL_GetError());
    }
    // centre the bitmap on ecran
    dstrect.x = (ecran->w - niveau1->w) / 2;
    dstrect.y = (ecran->h - niveau1->h) / 2;
   SDL_EnableKeyRepeat(250, 100);  //Effet pour générer des répétitions d'événements

while (!donem)
    {
    SDL_WaitEvent(&eventJ);
        switch(eventJ.type)
        {
            case SDL_QUIT:
                donem = true;
                break;
            case SDL_KEYDOWN:
                switch(eventJ.key.keysym.sym)
                {

                    case SDLK_ESCAPE:
                        donem = true;
                        break;


                    default :
                    break;
                }

        }
      // clear ecran
        SDL_FillRect(ecran, 0, SDL_MapRGB(ecran->format, 0, 0, 0));
        // draw bitmap
        SDL_BlitSurface(niveau1, 0, ecran, &dstrect);
        // finally, update the ecran :)
        SDL_Flip(ecran);
    }
SDL_FreeSurface(niveau1);
}


personnage::personnage()
{
//Initialisation des coordonnees
x = 0;
y = 0;
//Initialisation de la vitesse
xVel = 0;
yVel = 0;
}

void personnage::handle_input()
{
    //Si une touche a ete pressee
    if( eventJ.type == SDL_KEYDOWN )
    {
    //ajustement de la vitesse
    switch( eventJ.key.keysym.sym )
    {
    case SDLK_UP: yVel -= P_HEIGHT / 2; break;
    case SDLK_DOWN: yVel += P_HEIGHT / 2; break;
    case SDLK_LEFT: xVel -= P_WIDTH / 2; break;
    case SDLK_RIGHT: xVel += P_WIDTH / 2; break;
    default: break;
    }
    }
    //Si une touche a ete relachee
    else if( eventJ.type == SDL_KEYUP )
    {
    //ajustement de la vitesse
    switch( eventJ.key.keysym.sym )
    {
    case SDLK_UP: yVel += P_HEIGHT / 2; break;
    case SDLK_DOWN: yVel -= P_HEIGHT / 2; break;
    case SDLK_LEFT: xVel += P_WIDTH / 2; break;
    case SDLK_RIGHT: xVel -= P_WIDTH / 2; break;
    default: break;
    }
    }
}

void personnage::show()
{
    //Bouge le point à gauche ou à droite
    x += xVel;
    //Si le point se rapproche trop des limites(gauche ou droite) de l'ecran
    if( ( x < 0 ) || ( x + P_WIDTH > LARGEUR_FENETRE ) )
    {
    //On revient
    x -= xVel;
    }
    //Bouge le point en haut ou en bas
    y += yVel;
    //Si le point se rapproche trop des limites(haute ou basse) de l'ecran
    if( ( y < 0 ) || ( y + P_HEIGHT > HAUTEUR_FENETRE ) )
    {
    //On revient
    y -= yVel;
    }
    //Affiche le point
   /// apply_surface( x, y, point, screen );
}

void setImageUp(void)
{
int i=0;
//Man without gun knife
for(i=0;i<4;i++){
clip[i].x=34*i;
clip[i].y=0;
clip[i].w=SPSIZE;
clip[i].h=SPSIZE;
}

for(i=0;i<4;i++){
clip[i+4].x=34*i;
clip[i+4].y=34;
clip[i+4].w=SPSIZE;
clip[i+4].h=SPSIZE;
}

for(i=0;i<4;i++){
clip[i+8].x=34*i;
clip[i+8].y=68;
clip[i+8].w=SPSIZE;
clip[i+8].h=SPSIZE;
}

//Man with knife out
for(i=0;i<4;i++){
clipCout[i].x=34*i;
clipCout[i].y=102;
clipCout[i].w=SPSIZE;
clipCout[i].h=SPSIZE;
}

for(i=0;i<4;i++){
clipCout[i+4].x=34*i;
clipCout[i+4].y=238;
clipCout[i+4].w=SPSIZE;
clipCout[i+4].h=SPSIZE;
}

for(i=0;i<4;i++){
clipCout[i+8].x=34*i;
clipCout[i+8].y=272;
clipCout[i+8].w=SPSIZE;
clipCout[i+8].h=SPSIZE;
}
//Man with knife out
for(i=0;i<4;i++){
clipCoutUp[i].x=34*i;
clipCoutUp[i].y=136;
clipCoutUp[i].w=SPSIZE;
clipCoutUp[i].h=SPSIZE;
}

for(i=0;i<4;i++){
clipCoutUp[i+4].x=34*i;
clipCoutUp[i+4].y=306;
clipCoutUp[i+4].w=SPSIZE;
clipCoutUp[i+4].h=SPSIZE;
}

for(i=0;i<4;i++){
clipCoutUp[i+8].x=34*i;
clipCoutUp[i+8].y=340;
clipCoutUp[i+8].w=SPSIZE;
clipCoutUp[i+8].h=SPSIZE;
}


//Man with gun out
for(i=0;i<4;i++){
clipGun[i].x=34*i;
clipGun[i].y=306;
clipGun[i].w=SPSIZE;
clipGun[i].h=SPSIZE;
}

for(i=0;i<4;i++){
clipGun[i+4].x=34*i;
clipGun[i+4].y=374;
clipGun[i+4].w=SPSIZE;
clipGun[i+4].h=SPSIZE;
}

for(i=0;i<4;i++){
clipGun[i+8].x=34*i;
clipGun[i+8].y=408;
clipGun[i+8].w=SPSIZE;
clipGun[i+8].h=SPSIZE;
}


//Man with gun in
for(i=0;i<4;i++){
clipGunUp[i].x=34*i;
clipGunUp[i].y=204;
clipGunUp[i].w=SPSIZE;
clipGunUp[i].h=SPSIZE;
}

for(i=0;i<4;i++){
clipGunUp[i+4].x=170+34*i;
clipGunUp[i+4].y=0;
clipGunUp[i+4].w=SPSIZE;
clipGunUp[i+4].h=SPSIZE;
}

for(i=0;i<4;i++){
clipGunUp[i+8].x=170+34*i;
clipGunUp[i+8].y=34;
clipGunUp[i+8].w=SPSIZE;
clipGunUp[i+8].h=SPSIZE;
}

}
