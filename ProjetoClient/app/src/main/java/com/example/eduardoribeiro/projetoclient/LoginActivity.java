package com.example.eduardoribeiro.projetoclient;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view){
        EditText inLogin = (EditText)findViewById(R.id.login);
        EditText inPassword = (EditText)findViewById(R.id.password);

        String login = inLogin.getText().toString();
        String password = inPassword.getText().toString();
        MakeRequest request = new MakeRequest(handler, login, password);
        request.start();
    }

    public Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            String id = msg.getData().getString("id");
            if(id.equals("0")){
                String mensagem = "Login e/ou senha incorretos!";
                Toast.makeText(LoginActivity.this, mensagem, Toast.LENGTH_LONG).show();
            }else{
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                intent.putExtras(bundle);
                intent = new Intent(getApplicationContext(), ListaEntregas.class);
                startActivity(intent);
                Toast.makeText(LoginActivity.this, id, Toast.LENGTH_LONG).show();
            }
        };
    };

    public class MakeRequest extends Thread{
        private Handler handler;
        String login;
        String password;

        public MakeRequest(Handler handler, String login, String password){
            this.handler = handler;
            this.login = login;
            this.password = password;
        }

        public void run(){
            super.run();
            String url = "http://192.168.1.139:8088/ProjetoServer/Login";
            WebService webService = new WebService(url);

            Map params = new HashMap();
            params.put("login", login);
            params.put("password", password);
            System.out.println(login);
            System.out.println(password);

            //pega a resposta do servidor no eclipse
            String response = webService.webGet("", params);

            try{
                JSONObject jsonObject = new JSONObject(response);
                String id = jsonObject.getString("id").toString();
                Bundle b = new Bundle();
                b.putString("id", id);

                Message msg = new Message();
                msg.setData(b);
                handler.sendMessage(msg);
            }catch(JSONException e1){
                e1.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
