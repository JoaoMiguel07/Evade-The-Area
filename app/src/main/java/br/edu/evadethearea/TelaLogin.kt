package br.edu.evadethearea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class TelaLogin : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)

        // 1. INICIALIZAR O FIREBASE AUTH (Faltava isso aqui!)
        auth = FirebaseAuth.getInstance()

        val edtUsuario = findViewById<EditText>(R.id.edtUsuario)
        val edtSenha = findViewById<EditText>(R.id.edtSenha)
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        // Clique do botão Entrar
        btnEntrar.setOnClickListener {
            val usuario = edtUsuario.text.toString().trim()
            val senha = edtSenha.text.toString().trim()

            if (usuario.isEmpty()) {
                edtUsuario.error = "Digite o e-mail"
                edtUsuario.requestFocus()
                return@setOnClickListener
            }

            if (senha.isEmpty()) {
                edtSenha.error = "Digite a senha"
                edtSenha.requestFocus()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(usuario, senha)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this,
                            "Login realizado com sucesso!",
                            Toast.LENGTH_SHORT
                        ).show()

                        // Teste de navegação
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        val erro = task.exception?.message ?: "Erro desconhecido"
                        Toast.makeText(
                            this,
                            "Falha no login: $erro",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        } // Fim do btnEntrar

        // Clique do botão Voltar (Agora fora do btnEntrar)
        btnVoltar.setOnClickListener {
            finish()
        }
    }
}