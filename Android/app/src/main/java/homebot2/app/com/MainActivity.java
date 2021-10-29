package homebot2.app.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refHome = database.getReference("home");
    DatabaseReference refLuces, refBotones, refLuzSala, refPulsadorA, refLuzCocina, refLuzBano, refLuzCuarto, refFoco, refVentilador, refBomba,refServo,refMov;
    ToggleButton btnToggle, btnToggle2, btnToggle3, btnToggle4, btnToggle5, btnToggle6, btnToggle7, btnToggle8, btnToggle9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refLuces = refHome.child("luces");
        refLuzSala = refLuces.child("luz_sala");
        refLuzCocina = refLuces.child("luz_cocina");
        refLuzBano = refLuces.child("luz_bano");
        refLuzCuarto = refLuces.child("luz_cuarto");
        refVentilador = refLuces.child("ventilador");
        refFoco = refLuces.child("foco");
        refBomba = refLuces.child("bomba");
        refServo = refLuces.child("servo");
        refMov = refLuces.child("mov");


        btnToggle = (ToggleButton) findViewById(R.id.toggleButton);
        btnToggle.setTextOn("Apagar Sala");
        btnToggle.setTextOff("Encender Sala");

        btnToggle2 = (ToggleButton) findViewById(R.id.toggleButton2);
        btnToggle2.setTextOn("Apagar Cocina");
        btnToggle2.setTextOff("Encender Cocina");

        btnToggle3 = (ToggleButton) findViewById(R.id.toggleButton3);
        btnToggle3.setTextOn("Apagar Baño");
        btnToggle3.setTextOff("Encender Baño");

        btnToggle4 = (ToggleButton) findViewById(R.id.toggleButton4);
        btnToggle4.setTextOn("Apagar Cuarto");
        btnToggle4.setTextOff("Encender Cuarto");

        btnToggle5 = (ToggleButton) findViewById(R.id.toggleButton5);
        btnToggle5.setTextOn("Apagar Aire");
        btnToggle5.setTextOff("Encender Aire");

        btnToggle6 = (ToggleButton) findViewById(R.id.toggleButton6);
        btnToggle6.setTextOn("Apagar Foco");
        btnToggle6.setTextOff("Encender Foco");

        btnToggle7 = (ToggleButton) findViewById(R.id.toggleButton7);
        btnToggle7.setTextOn("Abrir Garita");
        btnToggle7.setTextOff("Cerrar Garita");

        btnToggle8 = (ToggleButton) findViewById(R.id.toggleButton8);
        btnToggle8 .setTextOn("Abrir bomba");
        btnToggle8 .setTextOff("Cerrar bomba");

        btnToggle9 = (ToggleButton) findViewById(R.id.toggleButton9);
        btnToggle9.setTextOn("Encender Alarma");
        btnToggle9.setTextOff("Apagar Alarma");




        controlLED(refLuzSala, btnToggle);
        controlLED2(refLuzCocina, btnToggle2);
        controlLED3(refLuzBano, btnToggle3);
        controlLED4(refLuzCuarto, btnToggle4);
        controlLED5(refVentilador, btnToggle5);
        controlLED6(refFoco, btnToggle6);
        controlLED7(refServo, btnToggle7);
        controlLED8(refBomba, btnToggle8);
        controlLED9(refMov, btnToggle9);


    }

    private void controlLED(final DatabaseReference refLed, final ToggleButton toggle_btn) {

        toggle_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed.setValue(isChecked);
            }
        });

        refLed.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led = (Boolean) dataSnapshot.getValue();
                toggle_btn.setChecked(estado_led);
                if (estado_led) {
                    toggle_btn.setTextOn("Apagar Sala");
                } else {
                    toggle_btn.setTextOff("Encender Sala");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });
    }

    private void controlLED2(final DatabaseReference refLed2, final ToggleButton toggle_btn2) {

        toggle_btn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed2.setValue(isChecked);
            }
        });

        refLed2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led2 = (Boolean) dataSnapshot.getValue();
                toggle_btn2.setChecked(estado_led2);
                if (estado_led2) {
                    toggle_btn2.setTextOn("Apagar Cocina");
                } else {
                    toggle_btn2.setTextOff("Encender Cocina");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });
    }

    private void controlLED3(final DatabaseReference refLed3, final ToggleButton toggle_btn3) {

        toggle_btn3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed3.setValue(isChecked);
            }
        });

        refLed3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led3 = (Boolean) dataSnapshot.getValue();
                toggle_btn3.setChecked(estado_led3);
                if (estado_led3) {
                    toggle_btn3.setTextOn("Apagar Baño");
                } else {
                    toggle_btn3.setTextOff("Encender Baño");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });
    }

    private void controlLED4(final DatabaseReference refLed4, final ToggleButton toggle_btn4) {

        toggle_btn4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed4.setValue(isChecked);
            }
        });

        refLed4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led4 = (Boolean) dataSnapshot.getValue();
                toggle_btn4.setChecked(estado_led4);
                if (estado_led4) {
                    toggle_btn4.setTextOn("Apagar Cuarto");
                } else {
                    toggle_btn4.setTextOff("Encender Cuarto");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });
    }

    private void controlLED5(final DatabaseReference refLed5, final ToggleButton toggle_btn5) {

        toggle_btn5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed5.setValue(isChecked);
            }
        });

        refLed5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led5 = (Boolean) dataSnapshot.getValue();
                toggle_btn5.setChecked(estado_led5);
                if (estado_led5) {
                    toggle_btn5.setTextOn("Apagar Aire");
                } else {
                    toggle_btn5.setTextOff("Encender Aire");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });
    }

    private void controlLED6(final DatabaseReference refLed6, final ToggleButton toggle_btn6) {

        toggle_btn6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed6.setValue(isChecked);
            }
        });

        refLed6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led6 = (Boolean) dataSnapshot.getValue();
                toggle_btn6.setChecked(estado_led6);
                if (estado_led6) {
                    toggle_btn6.setTextOn("Encender Foco");
                } else {
                    toggle_btn6.setTextOff("Apagar Foco");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });
    }
    private void controlLED7(final DatabaseReference refLed7, final ToggleButton toggle_btn7) {

        toggle_btn7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed7.setValue(isChecked);
            }
        });

        refLed7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led7 = (Boolean) dataSnapshot.getValue();
                toggle_btn7.setChecked(estado_led7);
                if (estado_led7) {
                    toggle_btn7.setTextOn("Cerrar Garita");
                } else {
                    toggle_btn7.setTextOff("Abrir Garita");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });
    }

    private void controlLED8(final DatabaseReference refLed8, final ToggleButton toggle_btn8) {

        toggle_btn8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed8.setValue(isChecked);
            }
        });

        refLed8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led8 = (Boolean) dataSnapshot.getValue();
                toggle_btn8.setChecked(estado_led8);
                if (estado_led8) {
                    toggle_btn8.setTextOn("Cerrar Bomba");
                } else {
                    toggle_btn8.setTextOff("Abrir Bomba");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });
    }

    private void controlLED9(final DatabaseReference refLed9, final ToggleButton toggle_btn9) {

        toggle_btn9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed9.setValue(isChecked);
            }
        });

        refLed9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led9 = (Boolean) dataSnapshot.getValue();
                toggle_btn9.setChecked(estado_led9);
                if (estado_led9) {
                    toggle_btn9.setTextOn("Apagar Alarma");
                } else {
                    toggle_btn9.setTextOff("Activar Alarma");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });
    }
}
