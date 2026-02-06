package valenzuela.victoria.examen1_valenzuelavictoria

import android.os.Bundle
import android.widget.Button   // Necesario
import android.widget.EditText // Necesario
import android.widget.TextView // Necesario
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PropinaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_propina)
        val totalRecibido = intent.getStringExtra("TOTAL")?.toDoubleOrNull() ?: 0.0
        val personasRecibidas = intent.getStringExtra("PERSONAS")?.toDoubleOrNull() ?: 1.0
        val etPorcentaje = findViewById<EditText>(R.id.ttPorcentaje)
        val btnCalcularFinal = findViewById<Button>(R.id.btnCalcularFinal)
        val tvResultadoFinal = findViewById<TextView>(R.id.tvResultadoFinal)

        btnCalcularFinal.setOnClickListener {
            val porcentaje = etPorcentaje.text.toString().toDoubleOrNull() ?: 0.0
            val propina = totalRecibido * (porcentaje / 100)
            val totalConPropina = (totalRecibido + propina) / personasRecibidas
            tvResultadoFinal.text = "$" + String.format("%.2f", totalConPropina)
        }
    }
}