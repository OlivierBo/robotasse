/*
main.c
------

Par Olivier BOUTON
*/

#include <stdlib.h>
#include <stdio.h>
#include <SDL/SDL.h>
#include <SDL/SDL_image.h>
#include <SDL/SDL_ttf.h>
#include <fmodex/fmod.h>
#include "constantes.h"
#include "menu.hpp"
#include "options.hpp"
#include "jouer.hpp"
#include "timer.hpp"


int main ( int argc, char** argv )
{    int i=0;
     SDL_Surface *ecran = NULL, *titre = NULL,*texte1 = NULL, *menu = NULL;
     SDL_Surface *texte2 = NULL, *texte3 = NULL, *texte4 = NULL;
     SDL_Rect dstrect;
     SDL_Rect position;
     SDL_Event event;
     TTF_Font *police0 = NULL, *police1 = NULL;
     SDL_Color couleurCyan = {224, 255, 255};
     SDL_Color couleurRouge = {255, 0, 0};
     SDL_Color couleurNoire = {28, 28, 28};
     SDL_Color a= couleurRouge, b= couleurNoire,c= couleurNoire,d= couleurNoire;

printf( "Hello\n");


    FMOD_SYSTEM *system;
	FMOD_SOUND *musiqueintro;

	FMOD_RESULT resultat;

	/* Création et initialisation d'un objet système */
	FMOD_System_Create(&system);
	FMOD_System_Init(system, 1, FMOD_INIT_NORMAL, NULL);

	/* Chargement du son et vérification du chargement */
	resultat = FMOD_System_CreateSound(system, "Sons/mmenu.mp3",  FMOD_LOOP_NORMAL | FMOD_CREATESAMPLE, 0, &musiqueintro);
	if (resultat != FMOD_OK)
	{
		fprintf(stderr, "Impossible de lire mmenu\n");
		exit(EXIT_FAILURE);
	}
    FMOD_Sound_SetLoopCount(musiqueintro, -1);
    FMOD_System_PlaySound(system, FMOD_CHANNEL_FREE, musiqueintro, 0, NULL);

        // initialize SDL video
    if ( SDL_Init( SDL_INIT_VIDEO ) < 0 )
    {
        printf( "Unable to init SDL: %s\n", SDL_GetError() );
        return 1;
    }



    if(TTF_Init() == -1)
    {
        fprintf(stderr, "Erreur d'initialisation de TTF_Init : %s\n", TTF_GetError());
        return 1;
    }
    //Icone
    SDL_WM_SetIcon(SDL_LoadBMP("ico.bmp"), NULL);
    // create a new window
    ecran = SDL_SetVideoMode(HAUTEUR_FENETRE, LARGEUR_FENETRE, RESOLUTION, SDL_HWSURFACE|SDL_DOUBLEBUF); // |SDL_FULLSCREEN pour après
    if ( !ecran )
    {
        printf("Unable to set 640x480 video: %s\n", SDL_GetError());
        return 1;
    }

    SDL_WM_SetCaption("ZOBIES-THE-GAME", NULL);

printf( "Hello2\n");

    // load an image
    menu = IMG_Load("menu.jpg");
    if (!menu)
    {
        printf("Unable to load image: %s\n", SDL_GetError());
        return 1;
    }
    // centre the bitmap on ecran
    dstrect.x = (ecran->w - menu->w) / 2;
    dstrect.y = (ecran->h - menu->h) / 2;
    police0 = TTF_OpenFont("28 Days Later.ttf", TAILLE_CARAC_MENU+10);
    police1 = TTF_OpenFont("Feathergraphy2.ttf", TAILLE_CARAC_MENU);
printf( "Hello3\n");
    // program main loop
    SDL_EnableKeyRepeat(250, 100);  //Effet pour générer des répétitions d'événements
    bool done = false;
    while (!done)
    {
        SDL_WaitEvent(&event);
        switch(event.type)
        {
            case SDL_QUIT:
                done = true;
                break;
            case SDL_KEYDOWN:
                switch(event.key.keysym.sym)
                {
                    case SDLK_UP: // Flèche haut
                        if(i==0){i=3;}
                        else{i--;}
                        break;
                    case SDLK_DOWN: // Flèche bas
                        if(i==3){i=0;}
                        else{i++;}
                        break;
                    case SDLK_ESCAPE:
                        done = true;
                        break;
                    case SDLK_RETURN:
                        switch(i)
                        {
                            case 0:
                            jouerz(ecran);
                            break;

                            case 1:
                            menuhistoire(ecran);
                            break;

                            case 2:
                            options(ecran);
                            break;

                            case 3:
                            done = true;
                            break;
                        }
                        break;

                    case SDLK_p:
                    FMOD_CHANNELGROUP *canal;
                    FMOD_BOOL etat;
                    FMOD_System_GetMasterChannelGroup(system, &canal);
                    FMOD_ChannelGroup_GetPaused(canal, &etat);

                    if (etat == 1) // Si la chanson est en pause
                    FMOD_ChannelGroup_SetPaused(canal, 0); // On enlève la pause
                    else // Sinon, elle est en cours de lecture
                    FMOD_ChannelGroup_SetPaused(canal, 1); // On met en pause
                    break;

                    default:
                    break;
                }

        } // end of message processing

        switch (i) //Choisi quel titre sera en rouge
            {
            case 0:
                a=couleurRouge; b=couleurNoire; c=couleurNoire; d=couleurNoire;
                break;
            case 1:
                a=couleurNoire; b=couleurRouge; c=couleurNoire; d=couleurNoire;
                break;
            case 2:
                a=couleurNoire; b=couleurNoire; c=couleurRouge; d=couleurNoire;
                break;
             case 3:
                a=couleurNoire; b=couleurNoire; c=couleurNoire; d=couleurRouge;
                break;
            }
        // DRAWING STARTS HERE

        printf( "Hello4\n");

        // clear ecran
        SDL_FillRect(ecran, NULL, SDL_MapRGB(ecran->format, 0, 0, 0));
                printf( "Hello456\n");
        // draw bitmap
        SDL_BlitSurface(menu, NULL, ecran, &dstrect);
        titre = TTF_RenderText_Blended(police0, "ZOBIES GAME", couleurRouge);
        position.x = LARGEUR_FENETRE/2;
        position.y = 0;
        SDL_BlitSurface(titre, NULL, ecran, &position); /* Blit du texte par-dessus */
        texte1 = TTF_RenderText_Blended(police1, "1 : Nouvelle partie", a);
        position.x = 50;
        position.y = HAUTEUR_FENETRE/7;
        SDL_BlitSurface(texte1, NULL, ecran, &position); /* Blit du texte par-dessus */
        texte2 = TTF_RenderText_Blended(police1, "2 : Choix du niveau", b);
        position.x = 50;
        position.y = 2*HAUTEUR_FENETRE/7;
        SDL_BlitSurface(texte2, NULL, ecran, &position); /* Blit du texte par-dessus */
        texte3 = TTF_RenderText_Blended(police1, "3 : Options", c);
        position.x = 50;
        position.y = 3*HAUTEUR_FENETRE/7;
        SDL_BlitSurface(texte3, NULL, ecran, &position); /* Blit du texte par-dessus */
        texte4 = TTF_RenderText_Blended(police1, "4 : Quitter", d);
        position.x = 50;
        position.y = 4*HAUTEUR_FENETRE/7;
        SDL_BlitSurface(texte4, NULL, ecran, &position); /* Blit du texte par-dessus */


        // finally, update the ecran :)
        SDL_Flip(ecran);
    } // end main loop

	FMOD_Sound_Release(musiqueintro);
	FMOD_System_Close(system);
	FMOD_System_Release(system);
    printf( "Hello5\n");
    // free loaded bitmap
    SDL_FreeSurface(menu);
    SDL_FreeSurface(ecran);
    SDL_FreeSurface(texte1);
    SDL_FreeSurface(texte2);
    SDL_FreeSurface(texte3);
    SDL_FreeSurface(texte4);
    TTF_CloseFont(police0); /* Doit être avant TTF_Quit() */
    TTF_CloseFont(police1); /* Doit être avant TTF_Quit() */
    TTF_Quit();
    //make sure SDL cleans up before exit
    SDL_Quit();
    // all is well ;)
    printf("Exited cleanly\n");
    return 0;
}

