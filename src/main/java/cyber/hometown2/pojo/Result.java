package cyber.hometown2.pojo;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;

    private Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 成功，并返回数据
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    // 成功，不返回数据
    public static <T> Result<T> success() {
        return success(null);
    }

    // 失败，自定义错误码和信息
    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, message, null);
    }

    // 失败，使用默认错误信息
    public static <T> Result<T> error(String message) {
        return error(500, message); // 默认500为服务器内部错误
    }

    // --- Getter and Setter ---
    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
