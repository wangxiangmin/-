package com.bawai.day0321.bean;

/**
 * @Author：余振华
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/16 16:02
 * @Description：描述信息
 */
public class Bean {

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * headPic : http://172.17.8.100/images/small/default/user.jpg
         * nickName : Z8_W413d
         * phone : 18611352750
         * sessionId : 15527232643841540
         * sex : 1
         * userId : 1540
         */

        private String headPic;
        private String nickName;
        private String phone;
        private String sessionId;
        private String sex;
        private String userId;

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
