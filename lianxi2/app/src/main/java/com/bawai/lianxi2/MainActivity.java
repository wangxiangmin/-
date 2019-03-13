package com.bawai.lianxi2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bawai.lianxi2.adapter.Adapter;
import com.bawai.lianxi2.bean.Bean;
import com.bawai.lianxi2.bean.Bean2;
import com.bawai.lianxi2.bean.Bean3;
import com.bawai.lianxi2.bean.Bean4;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshListView list_pull;
    private ArrayList<Bean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_pull = findViewById(R.id.list_pull);

        list_pull.setMode(PullToRefreshBase.Mode.BOTH);
        list_pull.setPullToRefreshOverScrollEnabled(true);


        if (HttpUtil.isNetworkConnected(MainActivity.this)){
            HttpUtil.httpAsynTask("http://172.17.8.100/small/commodity/v1/commodityList", new HttpUtil.CallBackString() {
                @Override
                public void getData(String s) {
                    Gson gson=new Gson();
                    Bean4 bean = gson.fromJson(s, Bean4.class);
                    Bean3 result = bean.getResult();
                    Bean2 mlss = result.getMlss();
                    Bean2 pzsh = result.getPzsh();
                    Bean2 rxxp = result.getRxxp();

                    list = new ArrayList<>();
                    list.addAll(mlss.getCommodityList());
                    list.addAll(rxxp.getCommodityList());
                    list.addAll(pzsh.getCommodityList());

                    Adapter adapter=new Adapter(list,MainActivity.this);
                    list_pull.setAdapter(adapter);

                }
            });
        }

        list_pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

                if (HttpUtil.isNetworkConnected(MainActivity.this)){
                    HttpUtil.httpAsynTask("http://172.17.8.100/small/commodity/v1/commodityList", new HttpUtil.CallBackString() {
                        @Override
                        public void getData(String s) {
                            Gson gson=new Gson();
                            Bean4 bean = gson.fromJson(s, Bean4.class);
                            Bean3 result = bean.getResult();
                            Bean2 mlss = result.getMlss();
                            Bean2 pzsh = result.getPzsh();
                            Bean2 rxxp = result.getRxxp();

                            ArrayList<Bean> list=new ArrayList<>();
                            list.addAll(mlss.getCommodityList());
                            list.addAll(rxxp.getCommodityList());
                            list.addAll(pzsh.getCommodityList());


                            Adapter adapter=new Adapter(list,MainActivity.this);
                            list_pull.setAdapter(adapter);

                            list_pull.onRefreshComplete();
                        }
                    });
                }

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {


                if (HttpUtil.isNetworkConnected(MainActivity.this)){
                    HttpUtil.httpAsynTask("http://172.17.8.100/small/commodity/v1/commodityList", new HttpUtil.CallBackString() {
                        @Override
                        public void getData(String s) {
                            Gson gson=new Gson();
                            Bean4 bean = gson.fromJson(s, Bean4.class);
                            Bean3 result = bean.getResult();
                            Bean2 mlss = result.getMlss();
                            Bean2 pzsh = result.getPzsh();
                            Bean2 rxxp = result.getRxxp();

                            ArrayList<Bean> list1=new ArrayList<>();
                            list.addAll(mlss.getCommodityList());
                            list.addAll(rxxp.getCommodityList());
                            list.addAll(pzsh.getCommodityList());

                            list.addAll(list1);
                            Adapter adapter=new Adapter(list,MainActivity.this);
                            list_pull.setAdapter(adapter);
                            list_pull.onRefreshComplete();

                        }
                    });
                }
            }
        });
    }
}
