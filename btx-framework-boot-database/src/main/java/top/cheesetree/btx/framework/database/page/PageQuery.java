package top.cheesetree.btx.framework.database.page;

import lombok.Getter;
import lombok.Setter;

/**
 * @author van
 */
@Getter
@Setter
public class PageQuery extends Page {
    /**
     * 排序字段
     */
    private String sortField;
    /**
     * 排序方向
     */
    private String sortOrder;

    public PageQuery(long pageSize, long pageIndex, String sortField, String sortOrder) {
        super(pageSize, pageIndex);
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public PageQuery() {
        super();
    }

    public PageQuery(Page page, String sortField, String sortOrder) {
        super(page.getPageSize(), page.getPageIndex());
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
}
