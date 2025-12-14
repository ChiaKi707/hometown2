package cyber.hometown2.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private long total; // 总记录数
    private List<T> records; // 当前页数据列表

    public PageResult() {
    }

    public PageResult(long total, List<T> records) {
        this.total = total;
        this.records = records;
    }

    // --- 省略 getter 和 setter ---
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
