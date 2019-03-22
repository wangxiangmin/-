package com.bawai.day0321.mvp.presenter;

import com.bawai.day0321.mvp.view.DengView;

/**
 * @Author：不要不要
 * @E-mail： 2930851278@qq.com
 * @Date：2019/3/21 19:16
 * @Description：描述信息
 */
public interface DengPresenter {

    void getPre(Object data);
    void  onAttch(DengView dengView);
    void  onDatch(DengView dengView);
    void Log(String userName, String pwd);
    void Reg(String userName, String pwd);
}
