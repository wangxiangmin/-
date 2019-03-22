package com.bawai.day0321.mvp.presenter;

import com.bawai.day0321.activity.Login;
import com.bawai.day0321.mvp.model.DengModel;
import com.bawai.day0321.mvp.model.DengModelmpl;
import com.bawai.day0321.mvp.view.DengView;

import java.lang.ref.SoftReference;

/**
 * @Author：不要不要
 * @E-mail： 2930851278@qq.com
 * @Date：2019/3/21 19:37
 * @Description：描述信息
 */
public class DengPresenterImpl implements DengPresenter {
    DengModelmpl dengModelmpl;
    DengView login;
    private SoftReference<DengModelmpl> dengModelmplSoftReference;

    @Override
    public void getPre(Object data) {
        login.getData(data);
    }

    @Override
    public void onAttch(DengView dengView) {
        this.login=dengView;
        dengModelmpl=new DengModelmpl();
        dengModelmplSoftReference = new SoftReference<>(dengModelmpl);
    }

    @Override
    public void onDatch(DengView dengView) {
        dengModelmplSoftReference.clear();
    }

    @Override
    public void Log(String userName, String pwd) {
        dengModelmpl.denglu(userName, pwd, new DengModel.CallBack() {
            @Override
            public void onSuccess(Object data) {
                login.getData(data);
            }

            @Override
            public void onFail() {

            }
        });
    }

    @Override
    public void Reg(String userName, String pwd) {
        dengModelmpl.zhuce(userName, pwd, new DengModel.CallBack() {
            @Override
            public void onSuccess(Object data) {
                login.getDadd(data);
            }

            @Override
            public void onFail() {

            }
        });

    }
}
