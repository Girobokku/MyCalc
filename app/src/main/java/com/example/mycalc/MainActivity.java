package com.example.mycalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String numeroActual = "";
    private String operacionActual = "";
    private double valorAnterior = 0;
    private boolean nuevaOperacion = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        // Obtener referencias a los botones
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonC = findViewById(R.id.buttonC);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonDot = findViewById(R.id.buttonDot);
        Button buttonEqual = findViewById(R.id.buttonEqual);

        // Asignar OnClickListener a los botones numéricos
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroActual += "0";
                actualizarDisplay();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroActual += "1";
                actualizarDisplay();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroActual += "2";
                actualizarDisplay();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroActual += "3";
                actualizarDisplay();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroActual += "4";
                actualizarDisplay();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroActual += "5";
                actualizarDisplay();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroActual += "6";
                actualizarDisplay();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroActual += "7";
                actualizarDisplay();
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroActual += "8";
                actualizarDisplay();
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroActual += "9";
                actualizarDisplay();
            }
        });

        // Asignar OnClickListener a los botones de operación
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarOperacion();
                operacionActual = "+";
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarOperacion();
                operacionActual = "-";
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarOperacion();
                operacionActual = "*";
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarOperacion();
                operacionActual = "/";
            }
        });

        // Asignar OnClickListener al botón igual
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarOperacion();
                operacionActual = "";
            }
        });

        // Asignar OnClickListener al botón "C" (reiniciar)
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroActual = "";
                operacionActual = "";
                valorAnterior = 0;
                nuevaOperacion = true;
                actualizarDisplay();
            }
        });

        // Asignar OnClickListener al botón de la coma decimal
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!numeroActual.contains(".")) {
                    numeroActual += ".";
                    actualizarDisplay();
                }
            }
        });
    }

    // Método para actualizar el contenido del display
    private void actualizarDisplay() {
        display.setText(numeroActual);
    }

    // Método para realizar operaciones matemáticas
    private void realizarOperacion() {
        if (!nuevaOperacion) {
            if (!operacionActual.isEmpty()) {
                try {
                    double numero = Double.parseDouble(numeroActual);
                    if (operacionActual.equals("+")) {
                        valorAnterior += numero;
                    } else if (operacionActual.equals("-")) {
                        valorAnterior -= numero;
                    } else if (operacionActual.equals("*")) {
                        valorAnterior *= numero;
                    } else if (operacionActual.equals("/")) {
                        if (numero != 0) {
                            valorAnterior /= numero;
                        } else {
                            numeroActual = "Error";
                            actualizarDisplay();
                            return;
                        }
                    }
                } catch (NumberFormatException e) {
                    numeroActual = "Error";
                    actualizarDisplay();
                    return;
                }
            } else {
                try {
                    valorAnterior = Double.parseDouble(numeroActual);
                } catch (NumberFormatException e) {
                    numeroActual = "Error";
                    actualizarDisplay();
                    return;
                }
            }
            numeroActual = "";
        }
        nuevaOperacion = true;
        actualizarDisplay();
    }
}
