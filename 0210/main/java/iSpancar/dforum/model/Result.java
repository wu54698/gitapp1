package iSpancar.dforum.model;

import java.io.Serializable;


public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;

	private String msg;

	private Object data;

    public Result() {

    }

	private <T> Result(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static <T> Result<T> ok(T data) {
		return new Result<T>(200, "success", data);
	}

	public static Result fail(String msg) {
		return new Result(401, msg, null);
	}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
