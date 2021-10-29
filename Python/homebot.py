import sys
from time import sleep
import signal
from gpiozero import LED, Button, Buzzer, Servo, DigitalInputDevice
from gpiozero.pins.pigpio import PiGPIOFactory
pigpio_factory = PiGPIOFactory()

from gpiozero.tones import Tone
from gpiozero import TonalBuzzer
from threading import Thread
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db
LED9 = LED (6)
LED8 = LED (13)
servo = Servo(19, pin_factory=pigpio_factory)
LED5 = LED (26)
LED6 =LED (27)
LED3 = LED (22)
LED4 = LED (23)
LED2 = LED (4)
LED =  LED(17)

servo.mid()
sleep(3)



PAHT_CRED = '/home/pi/Homebot/cred.json'
URL_DB = 'https://homebot2-c274a-default-rtdb.firebaseio.com/'
REF_HOME = 'home'
REF_LUCES = 'luces'
REF_LUZ_SALA = 'luz_sala'
REF_LUZ_CUARTO = 'luz_cuarto'
REF_LUZ_COCINA = 'luz_cocina'
REF_LUZ_BANO = 'luz_bano'
REF_VENTILADOR = 'ventilador'
REF_FOCO = 'foco'
REF_BOMBA = 'bomba'
REF_SERVO = 'servo'
REF_MOV = 'mov'



class IOT():

    def __init__(self):
        cred = credentials.Certificate(PAHT_CRED)
        firebase_admin.initialize_app(cred, {
            'databaseURL': URL_DB
        })

        self.refHome = db.reference(REF_HOME)
        
        self.estructuraInicialDB() # solo ejecutar la primera vez

        self.refLuces = self.refHome.child(REF_LUCES)
        self.refLuzSala = self.refLuces.child(REF_LUZ_SALA)
        self.refLuzCuarto = self.refLuces.child(REF_LUZ_CUARTO)
        self.refLuzCocina = self.refLuces.child(REF_LUZ_COCINA)
        self.refLuzBano = self.refLuces.child(REF_LUZ_BANO)
        self.refVentilador = self.refLuces.child(REF_VENTILADOR)
        self.refFoco = self.refLuces.child(REF_FOCO)
        self.refBomba = self.refLuces.child(REF_BOMBA)
        self.refServo = self.refLuces.child(REF_SERVO)
        self.refMov = self.refLuces.child(REF_MOV)
        


    def estructuraInicialDB(self):
        self.refHome.set({
            'luces': {
                'luz_sala':False,
                'luz_cuarto':False,
                'luz_cocina':False,
                'luz_bano':False,
                'ventilador':False,
                'foco':True,
                'bomba':True,
                'servo':False,
                'mov':False

                
            }

        })
    
    def ledControlGPIO(self, estado):
        if estado:
            LED.on()
            print('SALA ENCENDIDA')
            
        else:
            LED.off()
            print('SALA APAGADA')
           


    def ledControlGPIO2(self, estado2):
        if estado2:
            LED2.on() 
            print('CUARTO ENCENDIDO')
        else:
            LED2.off()
            print('CUARTO APAGADO')

    def ledControlGPIO3(self, estado3):
        if estado3:
            LED3.on()
            print('COCINA ENCENDIDA')
        else:
            LED3.off()
            print('COCINA APAGADA')

    def ledControlGPIO4(self, estado4):
        if estado4:
            LED4.on()
            print('BANO ENCENDIDO')
        else:
            LED4.off()
            print('BANO APAGADO')

    def ledControlGPIO5(self, estado5):
        if estado5:
            LED5.on()
            print('VENTILADOR ENCENDIDO')
        else:
            LED5.off()
            print('VENTILADOR APAGADO')

    def ledControlGPIO6(self, estado6):
        if estado6:
            LED6.on()
            print('FOCO APAGADO')
        else:
            LED6.off()
            print('FOCO ENCENDIDO')     

    def ledControlGPIO7(self, estado7):
        if estado7:
           servo.min()
           print("SERVO MAX")  
           sleep(3)
        else:
           servo.mid()
           print("SERVO MID")  
           sleep(3)  

    def ledControlGPIO8(self, estado8):
        if estado8:
            LED8.on()
            print('BOMBA APAGADA')
        else:
            LED8.off()
            print('BOMBA ENCENDIDA') 

    def ledControlGPIO9(self, estado9):
        if estado9:
            LED9.on()
            print('ALARMA ENCENDIDA')
        else:
            LED9.off()
            print('ALARMA APAGADA') 

    def lucesStart(self):

        E, i = [], 0

        estado_anterior = self.refLuzSala.get()
        self.ledControlGPIO(estado_anterior)

        E.append(estado_anterior)

        while True:
          estado_actual = self.refLuzSala.get()
          E.append(estado_actual)

          if E[i] != E[-1]:
              self.ledControlGPIO(estado_actual)

          del E[0]
          i = i + i
          sleep(0.4)

    def lucesStart2(self):

        P, a = [], 0

        estado_anterior2 = self.refLuzCuarto.get()
        self.ledControlGPIO2(estado_anterior2)

        P.append(estado_anterior2)

        while True:
          estado_actual2 = self.refLuzCuarto.get()
          P.append(estado_actual2)

          if P[a] != P[-1]:
              self.ledControlGPIO2(estado_actual2)

          del P[0]
          a = a + a
          sleep(0.4)

    def lucesStart3(self):

        C, g = [], 0

        estado_anterior3 = self.refLuzCocina.get()
        self.ledControlGPIO3(estado_anterior3)

        C.append(estado_anterior3)

        while True:
          estado_actual3 = self.refLuzCocina.get()
          C.append(estado_actual3)

          if C[g] != C[-1]:
              self.ledControlGPIO3(estado_actual3)

          del C[0]
          g = g + g
          sleep(0.4)

    def lucesStart4(self):

        R, d = [], 0

        estado_anterior4 = self.refLuzBano.get()
        self.ledControlGPIO4(estado_anterior4)

        R.append(estado_anterior4)

        while True:
          estado_actual4 = self.refLuzBano.get()
          R.append(estado_actual4)

          if R[d] != R[-1]:
              self.ledControlGPIO4(estado_actual4)

          del R[0]
          d = d + d
          sleep(0.4)  

    def lucesStart5(self):

        W, y = [], 0

        estado_anterior5 = self.refVentilador.get()
        self.ledControlGPIO5(estado_anterior5)

        W.append(estado_anterior5)

        while True:
          estado_actual5 = self.refVentilador.get()
          W.append(estado_actual5)

          if W[y] != W[-1]:
              self.ledControlGPIO5(estado_actual5)

          del W[0]
          y = y + y
          sleep(0.4)   

    def lucesStart6(self):

        F, g = [], 0

        estado_anterior6 = self.refFoco.get()
        self.ledControlGPIO6(estado_anterior6)

        F.append(estado_anterior6)

        while True:
          estado_actual6 = self.refFoco.get()
          F.append(estado_actual6)

          if F[g] != F[-1]:
              self.ledControlGPIO6(estado_actual6)

          del F[0]
          g = g + g
          sleep(0.4)      

    def lucesStart7(self):

        K, l = [], 0

        estado_anterior7 = self.refServo.get()
        self.ledControlGPIO7(estado_anterior7)

        K.append(estado_anterior7)

        while True:
          estado_actual7 = self.refServo.get()
          K.append(estado_actual7)

          if K[l] != K[-1]:
              self.ledControlGPIO7(estado_actual7)

          del K[0]
          l = l + l
          sleep(0.4)        


    def lucesStart8(self):

        Q, t = [], 0

        estado_anterior8 = self.refBomba.get()
        self.ledControlGPIO8(estado_anterior8)

        Q.append(estado_anterior8)

        while True:
          estado_actual8 = self.refBomba.get()
          Q.append(estado_actual8)

          if Q[t] != Q[-1]:
              self.ledControlGPIO8(estado_actual8)

          del Q[0]
          t = t + t
          sleep(0.4)   

    def lucesStart9(self):

        S, n = [], 0

        estado_anterior9 = self.refMov.get()
        self.ledControlGPIO9(estado_anterior9)

        S.append(estado_anterior9)

        while True:
          estado_actual9 = self.refMov.get()
          S.append(estado_actual9)

          if S[n] != S[-1]:
              self.ledControlGPIO9(estado_actual9)

          del S[0]
          n = n + n
          sleep(0.4)  
    

      


print ('HOMEBOT INICIADO')
iot = IOT()

subproceso_led = Thread(target=iot.lucesStart)
subproceso_led.daemon = True
subproceso_led.start()

subproceso_led2 = Thread(target=iot.lucesStart2)
subproceso_led2.daemon = True
subproceso_led2.start()

subproceso_led3 = Thread(target=iot.lucesStart3)
subproceso_led3.daemon = True
subproceso_led3.start()

subproceso_led4 = Thread(target=iot.lucesStart4)
subproceso_led4.daemon = True
subproceso_led4.start()

subproceso_led5 = Thread(target=iot.lucesStart5)
subproceso_led5.daemon = True
subproceso_led5.start()

subproceso_led6 = Thread(target=iot.lucesStart6)
subproceso_led6.daemon = True
subproceso_led6.start()

subproceso_led7 = Thread(target=iot.lucesStart7)
subproceso_led7.daemon = True
subproceso_led7.start()

subproceso_led8 = Thread(target=iot.lucesStart8)
subproceso_led8.daemon = True
subproceso_led8.start()

subproceso_led9 = Thread(target=iot.lucesStart9)
subproceso_led9.daemon = True
subproceso_led9.start()

signal.pause()