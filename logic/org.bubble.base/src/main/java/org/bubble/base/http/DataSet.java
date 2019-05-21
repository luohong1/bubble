package org.bubble.base.http;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

public class DataSet
        implements Serializable
{
    private static Log logger = LogFactory.getLog(DataSet.class);
    private Integer code;
    private Object data;
    @JsonIgnore
    public static final int success = 1;
    @JsonIgnore
    public static final int fail = 0;
    @JsonIgnore
    public static final int error = -1;
    @JsonIgnore
    public static final int authentication = 401;

    public DataSet(Integer code)
    {
        this.code = code;
    }

    public DataSet(Integer code, Object data)
    {
        this.code = code;
        this.data = data;
    }

    public Integer getCode()
    {
        return this.code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public Object getData()
    {
        return this.data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    @JsonIgnore
    public static ResponseEntity ok()
    {
        return HttpEntity.ok(new DataSet(Integer.valueOf(1)));
    }

    @JsonIgnore
    public static ResponseEntity ok(Object body)
    {
        return HttpEntity.ok(new DataSet(Integer.valueOf(1), body));
    }

    @JsonIgnore
    public static ResponseEntity ok(Object body, MultiValueMap<String, String> headers)
    {
        return HttpEntity.ok(new DataSet(Integer.valueOf(1), body), headers);
    }

    @JsonIgnore
    public static ResponseEntity fail()
    {
        return HttpEntity.ok(new DataSet(Integer.valueOf(0)));
    }

    @JsonIgnore
    public static ResponseEntity fail(Object body)
    {
        return HttpEntity.ok(new DataSet(Integer.valueOf(0), body));
    }

    @JsonIgnore
    public static ResponseEntity fail(Object body, MultiValueMap<String, String> headers)
    {
        return HttpEntity.ok(new DataSet(Integer.valueOf(0), body), headers);
    }

    @JsonIgnore
    public static ResponseEntity error()
    {
        return HttpEntity.error(new DataSet(Integer.valueOf(-1)));
    }

    @JsonIgnore
    public static ResponseEntity error(Object body)
    {
        return HttpEntity.error(new DataSet(Integer.valueOf(-1), body));
    }

    @JsonIgnore
    public static ResponseEntity error(Object body, MultiValueMap<String, String> headers)
    {
        return HttpEntity.error(new DataSet(Integer.valueOf(-1), body), headers);
    }

    public static ResponseEntity status(HttpStatus status)
    {
        return HttpEntity.status(new DataSet(Integer.valueOf(status.value())), status);
    }

    public static ResponseEntity status(Object body, HttpStatus status)
    {
        return HttpEntity.status(new DataSet(Integer.valueOf(status.value()), body), status);
    }

    public static void ajaxWrite(ServletRequest request, ServletResponse response, Integer code, Object msg)
    {
        HttpServletRequest r = (HttpServletRequest)request;
        String callback = null;
        if (r.getParameterMap().containsKey("callback")) {
            callback = r.getParameter("callback");
        }
        response.setCharacterEncoding("UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        String result = null;
        try
        {
            result = objectMapper.writeValueAsString(new DataSet(code, msg));
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        try
        {
            PrintWriter writer = response.getWriter();
            if (StringUtils.hasText(callback)) {
                writer.write(callback + "(" + result + ");");
            } else {
                writer.write(result);
            }
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
