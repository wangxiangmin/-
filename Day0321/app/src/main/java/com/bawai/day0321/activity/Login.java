package com.bawai.day0321.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawai.day0321.R;
import com.bawai.day0321.bean.Bean;
import com.bawai.day0321.mvp.presenter.DengPresenterImpl;
import com.bawai.day0321.mvp.view.DengView;

public class Login extends AppCompatActivity implements DengView {

    private EditText edit_shou;
    private EditText edit_mima;
    private Button btn_deng;
    private Button btn_zhu;
    DengPresenterImpl dengPresenter;
    private String mima;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        dengPresenter=new DengPresenterImpl();
       dengPresenter.onAttch(this);
       btn_zhu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mima = edit_mima.getText().toString();
               name = edit_shou.getText().toString();
               dengPresenter.Reg(name,mima);
           }
       });
       btn_deng.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mima = edit_mima.getText().toString();
               name = edit_shou.getText().toString();
               dengPresenter.Log(name, mima);

           }
       });

    }

    private void init() {
        edit_shou = findViewById(R.id.edit_shou);
        edit_mima = findViewById(R.id.edit_mima);
        btn_deng = findViewById(R.id.btn_deng);
        btn_zhu = findViewById(R.id.btn_zhu);
    }

    @Override
    public void getData(Object name) {
        Bean bean= (Bean) name;
        if (bean.getStatus().equals("0000")){
            Toast.makeText(Login.this, "" + bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
        Intent intent=new Intent(this, ShowActivity.class);
        startActivity(intent);
    }

    @Override
    public void getDadd(Object name) {
        Bean bean= (Bean) name;
        if (bean.getStatus().equals("0000")){
            Toast.makeText(Login.this, "" + bean.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }
}
