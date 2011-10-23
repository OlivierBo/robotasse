#include <stdlib.h>
#include <stdio.h>
#include <SDL/SDL.h>
#include <SDL/SDL_image.h>
#include <SDL/SDL_ttf.h>
#include "constantes.h"
#include "options.hpp"

void options(SDL_Surface* ecran)
{
bool donem=false;
SDL_Surface *ecranop = NULL;
     SDL_Rect dstrect;
     SDL_Event event;
ecranop = IMG_Load("ecranmenuoptions.jpg");
    if (!ecranop)
    {
        printf("Unable to load image: %s\n", SDL_GetError());
    }
    // centre the bitmap on ecran
    dstrect.x = (ecran->w - ecranop->w) / 2;
    dstrect.y = (ecran->h - ecranop->h) / 2;
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
        SDL_BlitSurface(ecranop, 0, ecran, &dstrect);
        // finally, update the ecran :)
        SDL_Flip(ecran);
    }
SDL_FreeSurface(ecranop);
}


