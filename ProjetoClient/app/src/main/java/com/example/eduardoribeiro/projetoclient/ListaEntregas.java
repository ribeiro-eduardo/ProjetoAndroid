package com.example.eduardoribeiro.projetoclient;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaEntregas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_entregas);
        Intent it = getIntent();
        if (it != null){
            Bundle params = it.getExtras();
            if (params != null){
                String id = params.getString("id");
                System.out.println("lista de entregas com o id: " + id);
                MakeRequest request = new MakeRequest(handler,id);
                request.start();
            }
        }
    }

    public Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            int id = msg.getData().getInt("id");
            if(id == 0){
                String mensagem = "Login e/ou senha incorretos!";
                Toast.makeText(ListaEntregas.this, mensagem, Toast.LENGTH_LONG).show();
            }else{
                Bundle bundle = new Bundle();
                bundle.putInt("id", id);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent = new Intent(getApplicationContext(), ListaEntregas.class);
                startActivity(intent);
            }
        };
    };

    public class MakeRequest extends Thread{
        private Handler handler;
        String id;

        public MakeRequest(Handler handler, String id){
            this.handler = handler;
            this.id = id;
        }

        public void run(){
            super.run();
            String url = "http://10.0.2.2:8088/ProjetoServer/ServletEntrega";
            WebService webService = new WebService(url);

            Map params = new HashMap();
            params.put("id", id);
            params.put("action", "listaEntregador");

            //pega a resposta do servidor no eclipse
            String response = webService.webGet("", params);

            try{
                JSONObject jsonObject = new JSONObject(response);
                List<String> list = new ArrayList<String>();
//                JSONArray array = jsonObject.getJSONArray("jsArray");
//                for(int i = 0 ; i < array.length() ; i++){
//
//                }
                JSONArray jsonarray = new JSONArray(jsonObject);
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    String endereco = jsonobject.getString("endereco");
                    String descricao = jsonobject.getString("descricao");
                }
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
        getMenuInflater().inflate(R.menu.menu_lista_entregas, menu);
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
