#include <Servo.h>  
  
#define INCR  1  
  
// on déclare le servomoteur comme une variable typée  
Servo servo1;  
Servo servo2;  
// l'angle actuel du servomoteur  
int angle = 0;  
// le sens actuel du servomoteur  
int sens = 0;  
  
/** 
 * Initialisation du programme 
 */  
void setup()  
{  
  servo1.attach(9); // le servomoteur est sur une patte PWM
 servo2.attach(10); 
 Serial.begin(9600); 
}  
  
/** 
 * Boucle infinie qui va gérer la rotation et faire alterner le sens de rotation  
 */  
void loop()  
   { delay(10);
if (Serial.available()>0)
{  
   switch (Serial.read())
   {
     case '0':
     servo1.write(0);
     Serial.println("1=0");
     break;
     
     case '1':
     servo1.write(45);
      Serial.println("1=45");
     break;
     
     case '2':
     servo1.write(90);
      Serial.println("1=90");
     break;
     
     case '3':
     servo2.write(0);
      Serial.println("2=0");
     break;
     
     case '4':
     servo2.write(45);
      Serial.println("2=45");
     break;
     
     case '5':
     servo2.write(90);
      Serial.println("2=90");
     break;

     default:
     servo2.write(0);
     servo1.write(0);
      Serial.println("1 et 2 = 0");
     break;
     
   }
  
    
}
} 
