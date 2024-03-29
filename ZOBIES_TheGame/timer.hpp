
#ifndef DEF_TIMER
#define DEF_TIMER

//Le Timer
class Timer
{
    private:
    //Le temps quand le timer est lanc�
    int startTicks;
    //Le temps enregistr� quand le Timer a �t� mit en pause
    int pausedTicks;
    //Le status du Timer
    bool paused;
    bool started;
    public:
    //Initialise les variables
    Timer();
    //Les diff�rentes actions du timer
    void start();
    void stop();
    void pause();
    void unpause();
    //recup�re le nombre de millisecondes depuis que le timer a �t� lanc�
    //ou r�cup�re le nombre de millisecondes depuis que le timer a �t� mis en pause
    int get_ticks();
    //Fonctions de v�rification du status du timer
    bool is_started();
    bool is_paused();
};

#endif


