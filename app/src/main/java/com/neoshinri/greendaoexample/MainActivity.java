package com.neoshinri.greendaoexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.neoshinri.greendaoexample.entity.Client;
import com.neoshinri.greendaoexample.entity.ClientDao;

import org.greenrobot.greendao.query.Query;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ClientDao clientDao;

    protected TextView textView;
    protected Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientDao = ((App) getApplication()).getDaoSession().getClientDao();

        Client client = new Client();
        client.setName("Algo");
        client.setSex("Desconocido");
        client.setBirthDate(new Date());

        clientDao.insert(client);

        textView = (TextView) findViewById(R.id.name);
        buttonView = (Button) findViewById(R.id.change_button);

        buttonView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Query<Client> query = clientDao.queryBuilder().build();
        Client client = query.unique();

        textView.setText(client.getName());
    }

}
