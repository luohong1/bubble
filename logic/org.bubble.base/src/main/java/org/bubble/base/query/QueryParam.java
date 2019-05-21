package org.bubble.base.query;


import java.io.Serializable;
import org.bubble.base.utils.HumpLineUtils;
import org.springframework.util.StringUtils;

public class QueryParam
        implements Serializable
{
    private String field;
    private Object keyword;
    private String sortField;
    private String sortOrder;

    public String getField()
    {
        return this.field;
    }

    public void setField(String field)
    {
        if (StringUtils.hasText(field)) {
            this.keyword = HumpLineUtils.humpToLine2(field);
        }
    }

    public Object getKeyword()
    {
        return this.keyword;
    }

    public void setKeyword(Object keyword)
    {
        this.keyword = keyword;
    }

    public String getSortField()
    {
        return this.sortField;
    }

    public void setSortField(String sortField)
    {
        if (StringUtils.hasText(sortField)) {
            this.sortField = HumpLineUtils.humpToLine2(sortField);
        }
    }

    public String getSortOrder()
    {
        return this.sortOrder;
    }

    public void setSortOrder(String sortOrder)
    {
        this.sortOrder = sortOrder;
    }
}
