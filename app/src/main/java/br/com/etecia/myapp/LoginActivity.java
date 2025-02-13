package br.com.etecia.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button btn_entrar, btn_criar_conta, btn_esqueceu_senha;
    TextInputEditText txt_usuario, txt_senha;

    String bd_usuario, bd_senha;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_entrar = findViewById(R.id.btnEntrar);
        btn_criar_conta = findViewById(R.id.btnCriarConta);
        btn_esqueceu_senha = findViewById(R.id.btnEsqueceuSenha);

        txt_usuario = findViewById(R.id.txtUsuario);
        txt_senha = findViewById(R.id.txtSenha);

        bd_usuario = "aaaa";
        bd_senha = "1234";

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String usuario, senha;
                usuario = txt_usuario.getText().toString();
                senha = txt_senha.getText().toString();

                if(usuario.equals(bd_usuario) && senha.equals(bd_senha)){
                    startActivity(new Intent(getApplicationContext(),MenuPrincipalActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Senha ou usuário inválidos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}