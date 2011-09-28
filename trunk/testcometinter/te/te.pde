/*
  AnalogReadSerial
 Reads an analog input on pin 0, prints the result to the serial monitor 
 
 This example code is in the public domain.
 */
volatile boolean state;

void setup() {
  Serial.begin(9600);
  attachInterrupt(0, yo, CHANGE);
  pinMode(13,OUTPUT);
}

void loop() {
  digitalWrite(13,state);
}

void yo()
{
  state=!state;
  Serial.print("interruption \n");
  if (state==0)
  {
  Serial.print("BAS");
  }
  else{
  Serial.print("HAUT");
  }
  digitalWrite(13,state);
}
