package com.bawai.day0321.mvp.model;

/**
 * @Author：不要不要
 * @E-mail： 2930851278@qq.com
 * @Date：2019/3/21 19:16
 * @Description：描述信息
 */
public interface DengModel {

    void denglu(String name,String pwd,CallBack callBack);
    void zhuce(String name,String pwd,CallBack callBack);

    void  getData(CallBack callBack);
    interface CallBack{
        void onSuccess(Object data);
        void onFail();
    }
}
