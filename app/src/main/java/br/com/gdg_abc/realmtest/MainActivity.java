package br.com.gdg_abc.realmtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import br.com.gdg_abc.realmtest.model.Pessoa;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtTelefone;
    private EditText edtIdade;
    private Button btnSalvar;
    private Realm realm;

    private String lastInsertedEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = (EditText) findViewById(R.id.textViewNome);
        edtEmail = (EditText) findViewById(R.id.textViewEmail);
        edtTelefone = (EditText) findViewById(R.id.textViewTelefone);
        edtIdade = (EditText) findViewById(R.id.textViewIdade);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        //Criando configuracao
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
        realm = Realm.getInstance(realmConfig);
    }

    public void salvarOnClick(View view) {
        insertDataBase(realm);
    }

    public void recuperarOnClick(View view) {
        List<Pessoa> pessoas = realm.where(Pessoa.class).findAll();
        Pessoa pessoa = pessoas.get(pessoas.size()-1);

        this.edtNome.setText(pessoa.getNome());
        this.edtEmail.setText(pessoa.getEmail());
        this.edtTelefone.setText(pessoa.getTelefone());
        this.edtIdade.setText(pessoa.getIdade());
    }

    public void limparOnClick(View view) {
        this.edtNome.setText("");
        this.edtEmail.setText("");
        this.edtTelefone.setText("");
        this.edtIdade.setText("");
    }

    private void insertDataBase(Realm realm) {

        realm.beginTransaction();

        Pessoa pessoa = realm.createObject(Pessoa.class);
        pessoa.setNome(edtNome.getText().toString());
        pessoa.setEmail(edtEmail.getText().toString());
        pessoa.setTelefone(edtTelefone.getText().toString());
        pessoa.setIdade(edtIdade.getText().toString());

        realm.commitTransaction();

        this.lastInsertedEmail = pessoa.getEmail();

    }
}
