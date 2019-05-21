package org.bubble.base.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.util.StringUtils;

public class HumpLineUtils
{
    private static Pattern linePattern = Pattern.compile("_(\\w)");

    public static String lineToHump(String str)
    {
        if (StringUtils.hasLength(str))
        {
            str = str.toLowerCase();
            Matcher matcher = linePattern.matcher(str);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
            }
            matcher.appendTail(sb);
            return sb.toString();
        }
        return str;
    }

    public static String humpToLine(String str)
    {
        if (StringUtils.hasLength(str)) {
            return str.replaceAll("[A-Z]", "_$0").toLowerCase();
        }
        return str;
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    public static String humpToLine2(String str)
    {
        if (StringUtils.hasLength(str))
        {
            Matcher matcher = humpPattern.matcher(str);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
            }
            matcher.appendTail(sb);
            return sb.toString();
        }
        return str;
    }
}