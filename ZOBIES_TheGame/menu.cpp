#include <stdlib.h>
#include <stdio.h>
#include <SDL/SDL.h>
#include <SDL/SDL_image.h>
#include <SDL/SDL_ttf.h>
#include "constantes.h"
#include "menu.hpp"


void menuhistoire(SDL_Surface* ecran)
{
bool donem=false;
SDL_Surface *ecranmh = NULL;
     SDL_Rect dstrect;
     SDL_Event event;
ecranmh = IMG_Load("ecranmenuhistoire.jpg");
    if (!ecranmh)
    {
        printf("Unable to load image: %s\n", SDL_GetError());
    }
    // centre the bitmap on ecran
    dstrect.x = (ecran->w - ecranmh->w) / 2;
    dstrect.y = (ecran->h - ecranmh->h) / 2;
   SDL_EnableKeyRepeat(250, 100);  //Effet pour générer des répétitions d'événements

while (!donem)
    {
    SDL_WaitEvent(&event);
        switch(event.type)
        {
            case SDL_QUIT:
                donem = true;
                break;
            case SDL_KEYDOWN:
                switch(event.key.keysym.sym)
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
        SDL_BlitSurface(ecranmh, 0, ecran, &dstrect);
        // finally, update the ecran :)
        SDL_Flip(ecran);
    }
SDL_FreeSurface(ecranmh);
}


