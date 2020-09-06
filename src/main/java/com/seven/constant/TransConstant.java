package com.seven.constant;


public class TransConstant {

    public enum TransType {

        TRANSTYPE_01("", ""),
        ;

        TransType(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        private String code;
        private String desc;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public enum TransCode {

        RECEVIVE_NOTIFY("", ""),
        ;

        TransCode(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        private String code;
        private String desc;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public enum ReplyCode {

        RESP_0000("0000", "操作成功"),
        SUCCESS("0000", "操作成功");



        private String code;
        private String message;

        private ReplyCode(String respCode, String respMsg) {
            this.code = respCode;
            this.message = respMsg;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
