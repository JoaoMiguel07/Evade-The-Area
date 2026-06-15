package br.edu.evadethearea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val botaoIniciar = findViewById<Button>(R.id.btnIniciar)
        val botaoConfig = findViewById<Button>(R.id.btnConfiguracoes)
        val botaoCreditos = findViewById<Button>(R.id.btnCreditos)

        botaoIniciar.setOnClickListener {

            Toast.makeText(
                this,
                "Iniciando o jogo...",
                Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this, TelaJogo::class.java)
            startActivity(intent)
        }

        botaoConfig.setOnClickListener {
            Toast.makeText(
                this,
                "Abrindo configurações...",
                Toast.LENGTH_SHORT
            ).show()
        }

        botaoCreditos.setOnClickListener {
            Toast.makeText(
                this,
                "Exibindo os créditos...",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}