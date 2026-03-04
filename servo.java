#include <Servo.h>

Servo myServo;  

void setup() {
  Serial.begin(9600);     
  myServo.attach(9);      
  Serial.println("Enter angle from 0 to 180:");
}

void loop() {
  if (Serial.available() > 0) {
    
    int angle = Serial.parseInt();  

    if (angle >= 0 && angle <= 180) {
      myServo.write(angle);  
      
      Serial.print("Servo moved to: ");
      Serial.println(angle);
    } 
    else {
      Serial.println("Invalid input! Enter 0-180 only.");
    }

    while (Serial.available() > 0) {
      Serial.read();  
    }
  }
}