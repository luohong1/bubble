package org.bubble.base.http;

public enum HttpStatusInfo
{
    CONTINUE(100, "继续"),  SWITCHING_PROTOCOLS(101, "切换协议"),  PROCESSING(102, "继续执行"),  CHECKPOINT(103, "检查"),  OK(200, "成功"),  CREATED(201, "已创建"),  ACCEPTED(202, "已接受"),  NON_AUTHORITATIVE_INFORMATION(203, "非授权信息"),  NO_CONTENT(204, "无内容"),  RESET_CONTENT(205, "重置内容"),  PARTIAL_CONTENT(206, "部分内容"),  MULTI_STATUS(207, "多种状态"),  ALREADY_REPORTED(208, "Already Reported"),  IM_USED(226, "IM Used"),  MULTIPLE_CHOICES(300, "多重选择"),  MOVED_PERMANENTLY(301, "永久迁移"),  FOUND(302, "找到"),  MOVED_TEMPORARILY(302, "Moved Temporarily"),  SEE_OTHER(303, "参见其他信息"),  NOT_MODIFIED(304, "没有修改"),  USE_PROXY(305, "使用代理"),  TEMPORARY_REDIRECT(307, "临时重定向"),  RESUME_INCOMPLETE(308, "Resume Incomplete"),  BAD_REQUEST(400, "错误请求"),  UNAUTHORIZED(401, "未授权"),  PAYMENT_REQUIRED(402, "Payment Required"),  FORBIDDEN(403, "禁止"),  NOT_FOUND(404, "未找到"),  METHOD_NOT_ALLOWED(405, "方法未允许"),  NOT_ACCEPTABLE(406, "无法访问"),  PROXY_AUTHENTICATION_REQUIRED(407, "代理服务器认证要求"),  REQUEST_TIMEOUT(408, "请求超时"),  CONFLICT(409, "冲突"),  GONE(410, "已经不存在"),  LENGTH_REQUIRED(411, "需要数据长度"),  PRECONDITION_FAILED(412, "先决条件错误"),  REQUEST_ENTITY_TOO_LARGE(413, "请求实体过大"),  REQUEST_URI_TOO_LONG(414, "请求URI过长"),  UNSUPPORTED_MEDIA_TYPE(415, "不支持的媒体格式"),  REQUESTED_RANGE_NOT_SATISFIABLE(416, "请求范围无法满足"),  EXPECTATION_FAILED(417, "期望失败"),  I_AM_A_TEAPOT(418, "我是杯具"),  INSUFFICIENT_SPACE_ON_RESOURCE(419, "Insufficient Space On Resource"),  METHOD_FAILURE(420, "Method Failure"),  DESTINATION_LOCKED(421, "该IP发起的链接过多"),  UNPROCESSABLE_ENTITY(422, "错误实体"),  LOCKED(423, "锁定"),  FAILED_DEPENDENCY(424, "错误关联"),  UPGRADE_REQUIRED(426, "升级要求"),  PRECONDITION_REQUIRED(428, "要求先决条件"),  TOO_MANY_REQUESTS(429, "太多请求"),  REQUEST_HEADER_FIELDS_TOO_LARGE(431, "请求头字段太大"),  INTERNAL_SERVER_ERROR(500, "内部服务器错误"),  NOT_IMPLEMENTED(501, "未实现"),  BAD_GATEWAY(502, "错误的网关"),  SERVICE_UNAVAILABLE(503, "服务无法获得"),  GATEWAY_TIMEOUT(504, "网关超时"),  HTTP_VERSION_NOT_SUPPORTED(505, "不支持的 HTTP 版本"),  VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates"),  INSUFFICIENT_STORAGE(507, "Insufficient Storage"),  LOOP_DETECTED(508, "Loop Detected"),  BANDWIDTH_LIMIT_EXCEEDED(509, "Bandwidth Limit Exceeded"),  NOT_EXTENDED(510, "Not Extended"),  NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required");

    private final int value;
    private final String reasonPhrase;

    private HttpStatusInfo(int value, String reasonPhrase)
    {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value()
    {
        return this.value;
    }

    public String getReasonPhrase()
    {
        return this.reasonPhrase;
    }

    public Series series()
    {
        return Series.valueOf(this);
    }

    public String toString()
    {
        return Integer.toString(this.value);
    }

    public static HttpStatusInfo valueOf(int statusCode)
    {
        HttpStatusInfo[] arr$ = values();
        int len$ = arr$.length;
        for (int i$ = 0; i$ < len$; i$++)
        {
            HttpStatusInfo status = arr$[i$];
            if (status.value == statusCode) {
                return status;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
    }

    public static enum Series
    {
        INFORMATIONAL(1),  SUCCESSFUL(2),  REDIRECTION(3),  CLIENT_ERROR(4),  SERVER_ERROR(5);

        private final int value;

        private Series(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }

        public static Series valueOf(int status)
        {
            int seriesCode = status / 100;
            Series[] arr$ = values();
            int len$ = arr$.length;
            for (int i$ = 0; i$ < len$; i$++)
            {
                Series series = arr$[i$];
                if (series.value == seriesCode) {
                    return series;
                }
            }
            throw new IllegalArgumentException("No matching constant for [" + status + "]");
        }

        public static Series valueOf(HttpStatusInfo status)
        {
            return valueOf(status.value);
        }
    }
}
