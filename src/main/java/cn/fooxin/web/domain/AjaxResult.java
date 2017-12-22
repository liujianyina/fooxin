package cn.fooxin.web.domain;

/**
 * Ajax请求返回的封装
 * Created by liujianyin on 2017/11/18.
 */

public class AjaxResult {

    /**
     * 状态码
     */
    private Long code;

    /**
     * 消息
     */
    private String msg;

    /**
     * layui分页插件的总数据
     */
    private Long count;

    /**
     * 数据
     */
    private Object data;

    public AjaxResult(Long code, String msg, Long count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    private AjaxResult(AjaxResult_TYPE type, Long count, Object data) {
        this.code = type.code;
        this.msg = type.msg;
        this.count = count;
        this.data = data;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public enum AjaxResult_TYPE {

        SUCCESS(0L, "成功"),

        FAIL(500L, "失败");

        /**
         * 状态码
         */
        private Long code;

        /**
         * 消息
         */
        private String msg;

        AjaxResult_TYPE(Long code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Long getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    public static AjaxResult success(Long count, Object obj) {
        return new AjaxResult(AjaxResult_TYPE.SUCCESS, count, obj);
    }

    public static AjaxResult success(Object obj) {
        return success(0L, obj);
    }

    public static AjaxResult success() {
        return success(0L, null);
    }

    public static AjaxResult error() {
        return new AjaxResult(AjaxResult_TYPE.FAIL, 0L, null);
    }

    public static AjaxResult customize(Long code, String msg, Long count, Object data) {
        return new AjaxResult(code, msg, count, data);
    }


}
