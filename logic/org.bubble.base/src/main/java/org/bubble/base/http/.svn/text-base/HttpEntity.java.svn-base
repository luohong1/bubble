package org.bubble.base.http;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class HttpEntity
{
    public static ResponseEntity ok()
    {
        return new ResponseEntity(HttpStatus.OK);
    }

    public static ResponseEntity ok(Object body)
    {
        return getResponseEntity(body, HttpStatus.OK);
    }

    public static ResponseEntity ok(Object body, MultiValueMap<String, String> headers)
    {
        return getResponseEntity(body, headers, HttpStatus.OK);
    }

    public static ResponseEntity fail()
    {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity fail(Object body)
    {
        return getResponseEntity(body, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity fail(Object body, MultiValueMap<String, String> headers)
    {
        return getResponseEntity(body, headers, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity error()
    {
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity error(Object body)
    {
        return getResponseEntity(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity error(Object body, MultiValueMap<String, String> headers)
    {
        return getResponseEntity(body, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity getResponseEntity(Object body, HttpStatus status)
    {
        if (((body instanceof DataSet)) && ((((DataSet)body).getData() instanceof PageInfo))) {
            return getPageInfoResponseEntity(body, status, null);
        }
        if (((body instanceof DataSet)) && ((((DataSet)body).getData() instanceof Page))) {
            return getPageResponseEntity(body, status, null);
        }
        return new ResponseEntity(body, status);
    }

    private static ResponseEntity getPageResponseEntity(Object body, HttpStatus status, MultiValueMap<String, String> headers)
    {
        DataSet ds = (DataSet)body;
        Page page = (Page)ds.getData();
        if (headers != null)
        {
            MultiValueMap<String, String> hp = getPageMultiValueMap(page.getTotal(), page.getCurrent(), page.getSize());
            headers.putAll(hp);
        }
        else
        {
            headers = getPageMultiValueMap(page.getTotal(), page.getCurrent(), page.getSize());
        }
        ds.setData(page.getRecords());
        return new ResponseEntity(ds, headers, status);
    }

    public static ResponseEntity getResponseEntity(MultiValueMap<String, String> headers, HttpStatus status)
    {
        return new ResponseEntity(headers, status);
    }

    public static ResponseEntity getResponseEntity(Object body, MultiValueMap<String, String> headers, HttpStatus status)
    {
        if (((body instanceof DataSet)) && ((((DataSet)body).getData() instanceof PageInfo))) {
            return getPageInfoResponseEntity(body, status, headers);
        }
        if (((body instanceof DataSet)) && ((((DataSet)body).getData() instanceof Page))) {
            return getPageResponseEntity(body, status, null);
        }
        return new ResponseEntity(body, status);
    }

    public static ResponseEntity getPageInfoResponseEntity(Object body, HttpStatus status, MultiValueMap<String, String> headers)
    {
        DataSet ds = (DataSet)body;
        PageInfo page = (PageInfo)ds.getData();
        if (headers != null)
        {
            MultiValueMap<String, String> hp = getPageMultiValueMap(page);
            headers.putAll(hp);
        }
        else
        {
            headers = getPageMultiValueMap(page);
        }
        ds.setData(page.getList());
        return new ResponseEntity(ds, headers, status);
    }

    public static MultiValueMap<String, String> getPageMultiValueMap(PageInfo pageDate)
    {
        MultiValueMap<String, String> headers = new HttpHeaders();
        if (pageDate != null)
        {
            headers.set("x-page-total", pageDate.getTotal() + "");
            headers.set("x-page-pagination", pageDate.getPrePage() + 1 + "");
            headers.set("x-page-limit", pageDate.getPageSize() + "");
        }
        return headers;
    }

    public static MultiValueMap<String, String> getPageMultiValueMap(int total, int pagination, int limit)
    {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.set("x-page-total", total + "");
        headers.set("x-page-pagination", pagination + "");
        headers.set("x-page-limit", limit + "");
        return headers;
    }

    public static ResponseEntity status(Object body, HttpStatus status)
    {
        return new ResponseEntity(body, status);
    }
}
