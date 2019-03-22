package com.bawai.day0321.mvp.model;

import com.bawai.day0321.bean.Bean;
import com.bawai.day0321.http.OkHttp;

/**
 * @Author：不要不要
 * @E-mail： 2930851278@qq.com
 * @Date：2019/3/21 19:31
 * @Description：描述信息
 */
public class DengModelmpl implements DengModel {

    String BaseUrl="http://172.17.8.100/small/user/v1/login";
    String Baseee="http://172.17.8.100/small/user/v1/register";
    @Override
    //登录
    public void denglu(String name, String pwd, final CallBack callBack) {
        OkHttp.getInstance().doPost(BaseUrl, Bean.class, name, pwd, new OkHttp.NetCallBack() {
            @Override
            public void LoadSuccess(Object obj) {
                callBack.onSuccess(obj);
            }
            @Override
            public void LoadFail() {

            }
        });

    }

    //注册
    @Override
    public void zhuce(String name, String pwd, final CallBack callBack) {

        OkHttp.getInstance().doPost(Baseee, Bean.class, name, pwd, new OkHttp.NetCallBack() {
            @Override
            public void LoadSuccess(Object obj) {
                callBack.onSuccess(obj);
            }
            @Override
            public void LoadFail() {

            }
        });
    }

    @Override
    public void getData(CallBack callBack) {

    }
}
