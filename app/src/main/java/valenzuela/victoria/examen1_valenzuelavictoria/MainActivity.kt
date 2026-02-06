package valenzuela.victoria.examen1_valenzuelavictoria

import android.content.Intent // Necesario para el botón de propina
import android.os.Bundle
import android.widget.Button   // IMPORTANTE: Para que reconozca los botones
import android.widget.EditText // IMPORTANTE: Para que reconozca las entradas de texto
import android.widget.TextView // Para el texto
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val ttTotal = findViewById<EditText>(R.id.ttTotal)
        val ttPersonas = findViewById<EditText>(R.id.ttPersonas)
        val btnSinPropina = findViewById<Button>(R.id.btnSinPropina)
        val btnConPropina = findViewById<Button>(R.id.btnConPropina)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnSinPropina.setOnClickListener {
            val total = ttTotal.text.toString().toDoubleOrNull() ?: 0.0
            val personas = ttPersonas.text.toString().toDoubleOrNull() ?: 1.0

            if (personas > 0) {
                val calculo = total / personas
                tvResultado.text = "$" + String.format("%.2f", calculo)
            } else {
                tvResultado.text = "Error: Personas debe ser mas de 1"
            }
        }

        btnConPropina.setOnClickListener {
            val intent = Intent(this, PropinaActivity::class.java)
            intent.putExtra("TOTAL", ttTotal.text.toString())
            startActivity(intent)
        }
    }
}




























