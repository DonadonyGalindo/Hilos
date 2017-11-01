package com.example.donadonydonaji.hilos2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1,button2,button3;
    EditText edt1,edt2,edt3;
    ProgressBar bar1,bar2,bar3;
    int cont1,cont2,cont3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button1 = (Button) findViewById(R.id.buttoncont1);
        button2 = (Button) findViewById(R.id.buttoncont2);
        button3 = (Button) findViewById(R.id.buttoncont3);

        bar1 = (ProgressBar) findViewById(R.id.progressBar1);
        bar2 = (ProgressBar) findViewById(R.id.progressBar2);
        bar3 = (ProgressBar) findViewById(R.id.progressBar3);

        edt1 = (EditText) findViewById(R.id.cont1);

        edt2 = (EditText) findViewById(R.id.cont2);

        edt3 = (EditText) findViewById(R.id.cont3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    private void UnSegundo() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private class  AsyncT01 extends AsyncTask<Void, Integer,Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            bar1.setMax(cont1);
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            for (int i=0; i<=cont1; i++){
                UnSegundo();
                publishProgress(i+1);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //Actualizar la barra de progreso
            bar1.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            //super.onPostExecute(aVoid);
            if (aVoid){
                Toast.makeText(getApplicationContext(),"Tarea 1 finalizada", Toast.LENGTH_SHORT).show();
                bar1.setProgress(0);
            }
        }
    }

    private class  AsyncT02 extends AsyncTask<Void, Integer,Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            bar2.setMax(cont2);
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            for (int i=0; i<=cont2; i++){
                UnSegundo();
                publishProgress(i+1);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //Actualizar la barra de progreso
            bar2.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            //super.onPostExecute(aVoid);
            if (aVoid){
                Toast.makeText(getApplicationContext(),"Tarea 2 finalizada", Toast.LENGTH_SHORT).show();
                bar2.setProgress(0);
            }
        }
    }

    private class  AsyncT03 extends AsyncTask<Void, Integer,Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            bar3.setMax(cont3);
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            for (int i=0; i<=cont3; i++){
                UnSegundo();
                publishProgress(i+1);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //Actualizar la barra de progreso
            bar3.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            //super.onPostExecute(aVoid);
            if (aVoid){
                Toast.makeText(getApplicationContext(),"Tarea  3 finaliza", Toast.LENGTH_SHORT).show();
                bar3.setProgress(0);
            }
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.buttoncont1:
                cont1 = Integer.parseInt(edt1.getText().toString());
                AsyncT01 at1=new AsyncT01();
                at1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                break;
            case R.id.buttoncont2:
                cont2=Integer.parseInt(edt2.getText().toString());
                AsyncT02 at2=new AsyncT02();
                at2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                break;
            case R.id.buttoncont3:
                cont3=Integer.parseInt(edt3.getText().toString());
                AsyncT03 at3=new AsyncT03();
                at3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                break;
            default:
                break;
        }

    }



    }

