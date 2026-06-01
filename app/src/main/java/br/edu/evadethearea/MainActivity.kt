package br.edu.evadethearea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Esta linha conecta o código com a tela que fizemos no passo 2
        setContentView(R.layout.activity_main)

        // 1. Encontrando os botões na tela através do ID
        val botaoIniciar = findViewById<Button>(R.id.btnIniciar)
        val botaoConfig = findViewById<Button>(R.id.btnConfiguracoes)
        val botaoCreditos = findViewById<Button>(R.id.btnCreditos)

        // 2. Criando as ações de clique para cada botão
        botaoIniciar.setOnClickListener {
            // Por enquanto, mostra apenas uma mensagem na tela
            Toast.makeText(this, "Iniciando o jogo...", Toast.LENGTH_SHORT).show()
        }

        botaoConfig.setOnClickListener {
            Toast.makeText(this, "Abrindo configurações...", Toast.LENGTH_SHORT).show()
        }

        botaoCreditos.setOnClickListener {
            Toast.makeText(this, "Exibindo os créditos...", Toast.LENGTH_SHORT).show()
        }
        botaoIniciar.setOnClickListener {
            // Cria a Intent informando a tela atual (this) e a tela de destino (CreditsActivity)
            val intent = Intent(this, TelaJogo::class.java)
            // Inicia a nova tela
            startActivity(intent)
        }
    }
}