package com.BasicApp;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	    /**
	     * ȥ���ַ�����β�Ŀո� �ж��ַ����Ƿ�Ϊ�գ�Ϊ��ֱ�ӷ��أ���Ϊ��ȥ���ո�󷵻�
	     * <p/>
	     * Written Date: 2007-8-13
	     * 
	     * @param str
	     * @return
	     * @author xulc
	     */
	    public static String trim(String str) {
	        if (isNullOrEmpty(str))
	            return str;
	        return str.trim();
	    }

	    /**
	     * ȥ���ַ�����β�Ŀո�ȫ�ǿո� �ж��ַ����Ƿ�Ϊ�գ�Ϊ��ֱ�ӷ��أ���Ϊ��ȥ���ո�󷵻�
	     * <p/>
	     * Written Date: 2007-8-13
	     * 
	     * @param str
	     * @return
	     * @author xulc
	     */
	    public static String trim2(String str) {
	        if (isNullOrEmpty(str))
	            return str;
	        return trimFilling(trimFilling(str.trim(), '��', false), '��', true);
	    }

	    /**
	     * ȥ���ִ��е�����ַ�
	     * 
	     * @param str
	     *            �ִ�
	     * @param filling
	     *            ����ַ�
	     * @param leftJustified
	     *            true���ִ�����룻false���ִ��Ҷ���
	     * @return ȥ������ַ�����ִ�
	     */
	    public static String trimFilling(String str, char filling, boolean leftJustified) {
	        if (str == null || str.length() == 0)
	            return str;
	        if (leftJustified) {
	            int pos = str.length() - 1;
	            for (; pos >= 0; pos--) {
	                if (str.charAt(pos) != filling)
	                    break;
	            }
	            return str.substring(0, pos + 1);
	        }
	        int pos = 0;
	        for (; pos < str.length(); pos++) {
	            if (str.charAt(pos) != filling)
	                break;
	        }
	        return str.substring(pos);
	    }

	    /**
	     * ȥ��HTML�ִ��еĿ����ַ����������ַ�
	     * 
	     * @param str
	     *            HTML�ִ�
	     * @return ���ص��ִ�
	     */
	    public static String escapeHTML(String str) {
	        int length = str.length();
	        int newLength = length;
	        boolean someCharacterEscaped = false;
	        for (int i = 0; i < length; i++) {
	            char c = str.charAt(i);
	            int cint = 0xffff & c;
	            if (cint < 32)
	                switch (c) {
	                case 11:
	                default:
	                    newLength--;
	                    someCharacterEscaped = true;
	                    break;

	                case '\t':
	                case '\n':
	                case '\f':
	                case '\r':
	                    break;
	                }
	            else
	                switch (c) {
	                case '"':
	                    newLength += 5;
	                    someCharacterEscaped = true;
	                    break;

	                case '&':
	                case '\'':
	                    newLength += 4;
	                    someCharacterEscaped = true;
	                    break;

	                case '<':
	                case '>':
	                    newLength += 3;
	                    someCharacterEscaped = true;
	                    break;
	                }
	        }
	        if (!someCharacterEscaped)
	            return str;

	        StringBuffer sb = new StringBuffer(newLength);
	        for (int i = 0; i < length; i++) {
	            char c = str.charAt(i);
	            int cint = 0xffff & c;
	            if (cint < 32)
	                switch (c) {
	                case '\t':
	                case '\n':
	                case '\f':
	                case '\r':
	                    sb.append(c);
	                    break;
	                }
	            else
	                switch (c) {
	                case '"':
	                    sb.append("&quot;");
	                    break;

	                case '\'':
	                    sb.append("&apos;");
	                    break;

	                case '&':
	                    sb.append("&amp;");
	                    break;

	                case '<':
	                    sb.append("&lt;");
	                    break;

	                case '>':
	                    sb.append("&gt;");
	                    break;

	                default:
	                    sb.append(c);
	                    break;
	                }
	        }
	        return sb.toString();
	    }

	    /**
	     * ȥ��SQL�ִ��еĿ����ַ�
	     * 
	     * @param str
	     *            SQL�ִ�
	     * @return ���ص��ִ�
	     */
	    public static String escapeSQL(String str) {
	        int length = str.length();
	        int newLength = length;
	        for (int i = 0; i < length;) {
	            char c = str.charAt(i);
	            switch (c) {
	            case 0:
	            case '"':
	            case '\'':
	            case '\\':
	                newLength++;
	            default:
	                i++;
	                break;
	            }
	        }
	        if (length == newLength)
	            return str;

	        StringBuffer sb = new StringBuffer(newLength);
	        for (int i = 0; i < length; i++) {
	            char c = str.charAt(i);
	            switch (c) {
	            case '\\':
	                sb.append("\\\\");
	                break;

	            case '"':
	                sb.append("\\\"");
	                break;

	            case '\'':
	                sb.append("\\'");
	                break;

	            case 0:
	                sb.append("\\0");
	                break;

	            default:
	                sb.append(c);
	                break;
	            }
	        }
	        return sb.toString();
	    }

	    /**
	     * ��һ���ַ����ֽ�ɼ�����
	     * 
	     * @param str
	     *            �ַ���
	     * @param segLen
	     *            ÿ���޳�
	     * @param segNum
	     *            �ֽ����
	     * @return �ֽ����ִ���
	     */
	    public static String[] split(String str, int segLen, int segNum) {
	        String[] result = new String[segNum];
	        if (str == null || str.length() == 0)
	            return result;

	        byte[] strByte;
	        try {
	            strByte = str.getBytes("GBK");
	        } catch (UnsupportedEncodingException ex) {
	            strByte = str.getBytes();
	        }
	        int pos = 0;
	        for (int i = 0; i < segNum; i++) {
	            int actLen = ((strByte.length - pos) < segLen) ? (strByte.length - pos) : segLen;
	            byte[] b = new byte[actLen];
	            System.arraycopy(strByte, pos, b, 0, actLen);
	            result[i] = new String(b);
	            pos += actLen;
	            if (pos >= strByte.length)
	                break;
	        }
	        return result;
	    }

	    /**
	     * ��һ���ַ����ֽ�ɼ����Σ�ÿ�ζ�������ת��ΪIBM935�ַ���
	     * 
	     * @param str
	     *            �ַ���
	     * @param segLen
	     *            ÿ���޳�
	     * @param segNum
	     *            �ֽ����
	     * @return �ֽ����ִ���
	     */
	    public static String[] split4Cp935(String str, int segLen, int segNum) {

	        String[] result = new String[segNum];

	        byte[] strByte;
	        try {
	            strByte = str.getBytes("GBK");
	        } catch (UnsupportedEncodingException ex) {
	            strByte = str.getBytes();
	        }
	        int strLen = strByte.length;
	        byte[] tmpByte = new byte[2 * strLen + segLen];

	        int head;
	        int flag;
	        int count;

	        int strCount = 0;
	        int segCount = 0;
	        int lastStrCount = 0;

	        for (flag = 0, head = 0, count = 0; strCount < strLen && segCount < segNum; count++) {
	            if ((strByte[strCount] & 0x80) != 0) {
	                head = head == 1 ? 0 : 1;
	                if (flag == 0) {
	                    tmpByte[count] = (byte) ' ';
	                    flag = 1;
	                    count++;
	                }

	                if ((count == ((count / segLen) + 1) * segLen - 2) && (head == 1)) {
	                    tmpByte[count] = (byte) ' ';
	                    tmpByte[count + 1] = (byte) ' ';
	                    result[segCount] = str.substring(lastStrCount, strCount);
	                    lastStrCount = strCount;
	                    segCount++;
	                    tmpByte[count + 2] = (byte) ' ';
	                    flag = 1;
	                    count = count + 3;
	                } else if (((segLen * ((count + 1) / segLen) - 1) == count) && (head == 1)) {
	                    tmpByte[count] = (byte) ' ';
	                    byte[] tmp = new byte[strCount - lastStrCount];
	                    System.arraycopy(strByte, lastStrCount, tmp, 0, tmp.length);
	                    result[segCount] = new String(tmp);
	                    lastStrCount = strCount;
	                    segCount++;
	                    tmpByte[count + 1] = (byte) ' ';
	                    count = count + 2;
	                    flag = 1;
	                } else if (((segLen * (count / segLen)) == count) && (head == 1)) {
	                    byte[] tmp = new byte[strCount - lastStrCount];
	                    System.arraycopy(strByte, lastStrCount, tmp, 0, tmp.length);
	                    result[segCount] = new String(tmp);
	                    lastStrCount = strCount;
	                    segCount++;
	                    tmpByte[count] = (byte) ' ';
	                    count++;
	                    flag = 1;
	                }
	            } else {
	                if (flag == 1) {
	                    tmpByte[count] = (byte) ' ';
	                    count++;
	                    flag = 0;
	                    if (count == (count / segLen) * segLen) {
	                        byte[] tmp = new byte[strCount - lastStrCount];
	                        System.arraycopy(strByte, lastStrCount, tmp, 0, tmp.length);
	                        result[segCount] = new String(tmp);
	                        lastStrCount = strCount;
	                        segCount++;
	                    } else {
	                        if ((segLen * ((count + 1) / segLen) - 1) == count) {
	                            byte[] tmp = new byte[strCount - lastStrCount + 1];
	                            System.arraycopy(strByte, lastStrCount, tmp, 0, tmp.length);
	                            result[segCount] = new String(tmp);
	                            lastStrCount = strCount + 1;
	                            segCount++;
	                        }
	                    }
	                } else {
	                    if ((segLen * ((count + 1) / segLen) - 1) == count) {
	                        byte[] tmp = new byte[strCount - lastStrCount + 1];
	                        System.arraycopy(strByte, lastStrCount, tmp, 0, tmp.length);
	                        result[segCount] = new String(tmp);
	                        lastStrCount = strCount + 1;
	                        segCount++;
	                    }
	                }

	            }
	            tmpByte[count] = strByte[strCount];
	            strCount++;
	            if (strCount >= strLen && segCount < segNum) {
	                byte[] tmp = new byte[strCount - lastStrCount];
	                System.arraycopy(strByte, lastStrCount, tmp, 0, tmp.length);
	                result[segCount] = new String(tmp);
	                lastStrCount = strCount;
	                segCount++;
	            }

	            if ((count + 1) % segLen == 0) {
	                flag = 0;
	            }
	        }

	        return result;
	    }

	    /**
	     * ȡ���ַ����ֽڳ���,ʹ��ȱʡ�ַ���
	     * 
	     * @param str
	     * @return length
	     */
	    public static int getByteLength(String str) {
	        return str.getBytes().length;
	    }

	    /**
	     * ��ȡ�Ϊlength�ֽڵ��ַ���
	     * 
	     * @param str
	     * @param length
	     * @return str
	     */
	    public static String subString(String str, String encode, int length) {
	        if (str == null || length < 0)
	            return null;
	        int zhl = 0, enl = 0;
	        if (zhLen.containsKey(encode)) {
	            zhl = ((Integer) zhLen.get(encode)).intValue();
	            enl = ((Integer) enLen.get(encode)).intValue();
	        } else {
	            try {
	                zhl = zh.getBytes(encode).length;
	            } catch (UnsupportedEncodingException e) {
	                zhl = zh.getBytes().length;
	            }
	            try {
	                enl = en.getBytes(encode).length;
	            } catch (UnsupportedEncodingException e) {
	                enl = en.getBytes().length;
	            }
	            zhLen.put(encode, new Integer(zhl));
	            enLen.put(encode, new Integer(enl));
	        }

	        int len = 0;
	        int strlen = str.length();
	        int i;
	        for (i = 0; i < strlen; i++) {
	            if (str.charAt(i) < 0x80)
	                len += enl;
	            else
	                len += zhl;
	            if (len > length)
	                break;

	        }

	        return str.substring(0, i);
	    }

	    /**
	     * �����ָ������ַ���ת����list
	     */
	    public static List<String> splitString(String str, String separator) {
	        return new ArrayList<String>(Arrays.asList(str.split(separator)));
	    }

	    public static String xml2String(byte[] xml) {
	        if (xml == null)
	            return null;
	        if (xml.length == 0)
	            return "";
	        try {
	            if (xml.length > 20) {
	                int max = Math.min(100, xml.length);
	                int i = 0;
	                while (i < max && xml[i] != '<')
	                    i++;
	                int j = i;
	                while (j < max && xml[j] != '>')
	                    j++;
	                if (j - i > 15) {
	                    String head = new String(xml, i, j - i + 1, "ISO-8859-1");
	                    i = head.indexOf("encoding=");
	                    if (i != -1) {
	                        i += "encoding=".length();
	                        char q = head.charAt(i);
	                        j = head.indexOf(q, i + 1);
	                        if (j != -1) {
	                            head = head.substring(i + 1, j);
	                            return new String(xml, head);
	                        }
	                    }
	                }
	            }
	        } catch (Throwable t) {
	        }
	        return new String(xml);
	    }

	    /**
	     * �õ���head��ͷ,tail��β���Ӵ�
	     * 
	     * @param buffer
	     *            String
	     * @return String
	     */
	    public static String subString(String buffer, String head, String tail) {
	        if (buffer == null || head == null || tail == null)
	            return buffer;
	        int startNum = buffer.indexOf(head);
	        int endNum = buffer.lastIndexOf(tail);

	        startNum = startNum >= 0 ? startNum : 0;
	        endNum = endNum >= 0 ? endNum + tail.length() : buffer.length();
	        return buffer.substring(startNum, endNum);
	    }

	    /**
	     * ��List���ڵ�MAP�ִ�ת��ΪMAP����
	     * 
	     * @param listMapInner
	     * @return
	     * @author caoke
	     */
	    public static List listString2Map(List listMapInner) {
	        List list = new ArrayList();
	        for (int i = 0; i < listMapInner.size(); i++) {
	            Object map = listMapInner.get(i);
	            if (map != null) {
	                list.add(string2Map(map.toString()));
	            }
	        }
	        return list;
	    }

	    /**
	     * ��MAP����ת��Ϊ�ִ�
	     * 
	     * @param map
	     * @return
	     * @author caoke
	     */
	    public static String map2String(Map map) {
	        StringBuffer sb = new StringBuffer();
	        boolean isFirst = true;
	        for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
	            Entry entry = (Entry) it.next();
	            Object key = entry.getKey();
	            Object value = entry.getValue();
	            if (key != null && value != null) {
	                if (!isFirst) {
	                    sb.append(",");
	                } else {
	                    isFirst = false;
	                }
	                sb.append(normalizeMapString(key.toString().trim()));
	                sb.append("=");
	                sb.append(normalizeMapString(value.toString().trim()));
	            }
	        }
	        return sb.toString();
	    }

	    /**
	     * ���ִ�����ת��ΪMAP
	     * 
	     * @param str
	     * @return
	     * @author caoke
	     */
	    public static Map string2Map(String str) {
	        Map map = new HashMap();
	        String[] entrys = tokenizeToStringArray(str, ",");
	        for (int i = 0; i < entrys.length; i++) {
	            String[] entry = tokenizeToStringArray(entrys[i], "=");
	            if (entry.length == 2) {
	                map.put(specializeMapString(entry[0]), specializeMapString(entry[1]));
	            }
	        }
	        return map;
	    }

	    private static final String[] ESC_TABLE = new String[] { "&cma&", "&equ&" };

	    private static final String[] TALBLE = new String[] { ",", "=" };

	    public static String[] tokenizeToStringArray(String str, String delimiters) {
	        return tokenizeToStringArray(str, delimiters, true, true);
	    }

	    public static String[] tokenizeToStringArray(String str, String delimiters, boolean trimTokens,
	            boolean ignoreEmptyTokens) {

	        if (str == null) {
	            return null;
	        }
	        StringTokenizer st = new StringTokenizer(str, delimiters);
	        List<String> tokens = new ArrayList<String>();
	        while (st.hasMoreTokens()) {
	            String token = st.nextToken();
	            if (trimTokens) {
	                token = token.trim();
	            }
	            if (!ignoreEmptyTokens || token.length() > 0) {
	                tokens.add(token);
	            }
	        }
	        return toStringArray(tokens);
	    }

	    public static String[] toStringArray(Collection<String> collection) {
	        if (collection == null) {
	            return null;
	        }
	        return collection.toArray(new String[collection.size()]);
	    }

	    public static String replace(String inString, String oldPattern, String newPattern) {
	        if (!hasLength(inString) || !hasLength(oldPattern) || newPattern == null) {
	            return inString;
	        }
	        StringBuilder sb = new StringBuilder();
	        int pos = 0; // our position in the old string
	        int index = inString.indexOf(oldPattern);
	        // the index of an occurrence we've found, or -1
	        int patLen = oldPattern.length();
	        while (index >= 0) {
	            sb.append(inString.substring(pos, index));
	            sb.append(newPattern);
	            pos = index + patLen;
	            index = inString.indexOf(oldPattern, pos);
	        }
	        sb.append(inString.substring(pos));
	        // remember to append any characters to the right of a match
	        return sb.toString();
	    }

	    public static boolean hasLength(CharSequence str) {
	        return (str != null && str.length() > 0);
	    }

	    public static boolean hasLength(String str) {
	        return hasLength((CharSequence) str);
	    }

	    private static String normalizeMapString(String str) {
	        if (str == null) {
	            return null;
	        }
	        String result = str;
	        for (int i = 0; i < TALBLE.length; i++) {
	            result = replace(result, TALBLE[i], ESC_TABLE[i]);
	        }
	        return result;
	    }

	    private static String specializeMapString(String str) {
	        if (str == null) {
	            return null;
	        }
	        String result = str;
	        for (int i = 0; i < TALBLE.length; i++) {
	            result = replace(result, ESC_TABLE[i], TALBLE[i]);
	        }
	        return result;
	    }

	    /**
	     * ת��Ϊʮ�����Ƹ�ʽ��Сд��
	     * 
	     * @param abyte0
	     * @return
	     */
	    private static final char hexchars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e','f' };
	    public static final String bytes2HexStr(byte abyte0[]) {
	        if (abyte0 == null)
	            return null;
	        int len = abyte0.length * 2;
	        if (len == 0)
	            return "";
	        StringBuffer stringbuffer = new StringBuffer(len);
	        for (int i = 0; i < abyte0.length; i++) {
	            stringbuffer.append(hexchars[abyte0[i] >>> 4 & 0xf]);
	            stringbuffer.append(hexchars[abyte0[i] & 0xf]);
	        }

	        return stringbuffer.toString();
	    }

	    /**
	     * �ж϶�������������ÿһ�������Ƿ�Ϊ��: ����Ϊnull���ַ����г���Ϊ0�������ࡢMapΪempty
	     * 
	     * @param obj
	     * @return
	     */
	    public static boolean isNullOrEmpty(Object obj) {
	        if (obj == null)
	            return true;

	        if (obj instanceof CharSequence)
	            return ((CharSequence) obj).length() == 0;

	        if (obj instanceof Collection)
	            return ((Collection<?>) obj).isEmpty();

	        if (obj instanceof Map)
	            return ((Map<?, ?>) obj).isEmpty();

	        if (obj instanceof Object[]) {
	            Object[] object = (Object[]) obj;
	            boolean empty = true;
	            for (int i = 0; i < object.length; i++)
	                if (!isNullOrEmpty(object[i])) {
	                    empty = false;
	                    break;
	                }
	            return empty;
	        }
	        return false;
	    }

	    /**
	     * ����separator�ָ���Stringת��ΪList�����str��û��separator�򷵻ص�List��ֻ�� strһ��
	     * 
	     * @param str
	     * @param separator
	     * @return
	     */
	    public static List<String> str2List(String str, String separator) {
	        List<String> result = new ArrayList<String>();
	        if (str.indexOf(separator) < 0) {
	            result.add(str);
	        } else {
	            String[] strArray = str.split(separator);

	            for (int i = 0; i < strArray.length; i++) {
	                result.add(strArray[i]);
	            }
	        }

	        return result;
	    }

	    /**
	     * ȥ���ַ����пհ��ַ�
	     * 
	     * @param str
	     * @return
	     */
	    public static String filterSBCCase(String str) {
	        char[] ch = str.toCharArray();
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < ch.length; i++) {
	            if (!Character.isWhitespace(ch[i])) {
	                sb.append(String.valueOf(ch[i]));
	            }
	        }
	        return sb.toString();
	    }

	    /**
	     * �ַ����Ƿ�ȫ���֣��޷��š�С���㣩
	     * 
	     * @param str
	     * @return
	     */
	    public static boolean isDigit(String str) {
	        char c;
	        for (int i = 0; i < str.length(); i++) {
	            c = str.charAt(i);
	            if (c < '0' || c > '9')
	                return false;
	        }
	        return true;
	    }

	    /**
	     * �ַ����Ƿ�ȫ���ֻ�Ӣ����ĸ���޷��š�С���㣩
	     * 
	     * @param str
	     * @return
	     */
	    public static boolean isAlphaDigit(String str) {
	        char c;
	        for (int i = 0; i < str.length(); i++) {
	            c = str.charAt(i);
	            if (c < '0' || c > '9' && c < 'A' || c > 'Z' && c < 'a' || c > 'z')
	                return false;
	        }
	        return true;
	    }

	    /**
	     * get substring in bytes length
	     * 
	     * @param orgString
	     *            original string
	     * @param lengthInBytes
	     *            bytes length
	     * @return substring
	     */
	    public static final String subStringInBytes(String orgString, int startPos, int lengthInBytes) {

	        if (orgString == null)
	            return null;

	        byte[] orgBytes;
	        try {
	            orgBytes = orgString.getBytes("GBK");
	        } catch (UnsupportedEncodingException ex) {
	            orgBytes = orgString.getBytes();
	        }
	        if (startPos < 0 || startPos > orgBytes.length)
	            return null;
	        else if (lengthInBytes < startPos)
	            return null;

	        byte[] newBytes;
	        int newLength = orgBytes.length - startPos;
	        if (lengthInBytes < newLength)
	            newLength = lengthInBytes;

	        newBytes = new byte[newLength];
	        System.arraycopy(orgBytes, startPos, newBytes, 0, newLength);

	        return new String(newBytes);
	    }

	    /**
	     * ��ǧλ�ָ��ʽ��ʽ������
	     * 
	     * @param v
	     * @param scale
	     * @return
	     */
	    public static String parseStringPattern(Object v, int scale) {
	        String temp = "###,###,###,###,###,###,###,##0";
	        if (scale > 0)
	            temp += ".";
	        for (int i = 0; i < scale; i++)
	            temp += "0";
	        DecimalFormat format = new DecimalFormat(temp);
	        return format.format(v).toString();
	    }

	    /**
	     * תΪString[]
	     * 
	     * @param object
	     * @return
	     */
	    public static String[] getStringArray(Object object) {
	        if (object instanceof String[])
	            return (String[]) object;
	        if (object instanceof String) {
	            String tmpStrs[] = new String[1];
	            tmpStrs[0] = (String) object;
	            return tmpStrs;
	        }
	        return null;
	    }

	    /**
	     * ������ַ�����ʾ
	     * 
	     * @param obj
	     * @return
	     */
	    public static final String objectToString(Object obj) {
	        if (obj == null) {
	            return "null";
	        }
	        StringBuffer buf = new StringBuffer();

	        try {
	            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
	            PropertyDescriptor[] propertyDescs = beanInfo.getPropertyDescriptors();
	            for (int i = 0; i < propertyDescs.length; i++) {
	                String name = propertyDescs[i].getName();
	                Method getter = propertyDescs[i].getReadMethod();
	                if (getter != null && !name.equals("class")) {
	                    Object value = getter.invoke(obj, null);
	                    buf.append(name).append("=").append(value).append(" ");
	                }
	            }
	        } catch (IllegalArgumentException e) {

	        } catch (IntrospectionException e) {

	        } catch (IllegalAccessException e) {

	        } catch (InvocationTargetException e) {

	        }
	        if (buf.length() > 0) {
	            buf.deleteCharAt(buf.length() - 1);
	        }
	        return buf.toString();
	    }

	    public static String ADEncoding(String str) {
	        if (str == null || str.length() == 0 || isDigit(str) && !str.startsWith("99"))
	            return str;
	        StringBuffer buf = new StringBuffer("99");
	        char c;
	        for (int i = 0; i < str.length(); i++) {
	            c = str.charAt(i);
	            if (c > '\u00ff')
	                buf.append("99");
	            else if (c > '~')
	                buf.append("98");
	            else if (c == '\t')
	                buf.append("95");
	            else if (c == '\r' || c == '\n')
	                buf.append("96");
	            else if (c < ' ')
	                buf.append("97");
	            else if (c >= '0' && c <= '9')
	                buf.append('0').append(c);
	            else if (c >= 'A' && c <= 'Z')
	                buf.append((char) ((c - 'A' + 10) / 10 + '0')).append((char) ((c - 'A' + 10) % 10 + '0'));
	            else if (c >= 'a' && c <= 'z')
	                buf.append((char) ((c - 'a' + 40) / 10 + '0')).append((char) ((c - 'a' + 40) % 10 + '0'));
	            else if (c < '0')
	                buf.append((char) ((c - ' ' + 66) / 10 + '0')).append((char) ((c - ' ' + 66) % 10 + '0'));
	            else if (c < 'A')
	                buf.append((char) ((c - ':' + 82) / 10 + '0')).append((char) ((c - ':' + 82) % 10 + '0'));
	            else if (c < 'a')
	                buf.append((char) ((c - '[' + 89) / 10 + '0')).append((char) ((c - '[' + 89) % 10 + '0'));
	            else
	                // if (c >= '{')
	                buf.append((char) ((c - '{' + 36) / 10 + '0')).append((char) ((c - '{' + 36) % 10 + '0'));
	        }
	        return buf.toString();
	    }

	    public static String ADDecoding(String str) {
	        if (str == null || str.length() < 4 || !str.startsWith("99") || (str.length() & 1) == 1)
	            return str;
	        StringBuffer buf = new StringBuffer();
	        for (int i = 2; i < str.length(); i += 2) {
	            int n = (str.charAt(i) - '0') * 10 + str.charAt(i + 1) - '0';
	            if (n < 10)
	                buf.append(n);
	            else if (n < 36)
	                buf.append((char) (n - 10 + 'A'));
	            else if (n < 40)
	                buf.append((char) (n - 36 + '{'));
	            else if (n < 66)
	                buf.append((char) (n - 40 + 'a'));
	            else if (n < 82)
	                buf.append((char) (n - 66 + ' '));
	            else if (n < 89)
	                buf.append((char) (n - 82 + ':'));
	            else if (n < 95)
	                buf.append((char) (n - 89 + '['));
	            else if (n == 95)
	                buf.append('\t');
	            else if (n == 96)
	                buf.append('\n');
	            else if (n == 97)
	                buf.append('\u00a9');
	            else if (n == 98)
	                buf.append('\u00c5');
	            else
	                // if (n == 99)
	                buf.append('\u2592');
	        }
	        return buf.toString();
	    }

	    private static Map<String, Integer> zhLen = new HashMap<String, Integer>(), enLen = new HashMap<String, Integer>();

	    private static final String zh = "��";

	    private static final String en = "A";

	    /**
	     * ȡ����ļ���
	     * 
	     * @param obj
	     * @return ��ļ���
	     */
	    public static String getSimpleName(Object obj) {
	        if (obj == null)
	            return null;
	        String name = obj.getClass().getName();
	        if (name.toLowerCase().indexOf("$proxy") >= 0) {
	            name = obj.toString();
	            int idx = name.lastIndexOf("@");
	            if (idx > 0)
	                name = name.substring(0, idx);
	        }
	        return name.substring(name.lastIndexOf(".") + 1);
	    }

	    /**
	     * ���ִ�
	     * 
	     * @param str
	     * @param length
	     * @return
	     */
	    public static String subString(String str, int length) {
	        if (str == null) {
	            return "";
	        }
	        int end = str.length();
	        if (length > end) {
	            end = length;
	        }
	        return str.substring(0, end);
	    }

	    /**
	     * ��ȡ�ַ����ĳ���, ���Ϊnull�򳤶�Ϊ0
	     * 
	     * @param str
	     * @return
	     */
	    public static int length(String str) {
	        if (isNullOrEmpty(str))
	            return 0;
	        else
	            return str.trim().length();

	    }

	    /**
	     * ����Թ����ײ�ѯ���ܹ��÷��� ���ܽ��ձ��ַ��࣬����ַ���
	     * 
	     * @param list
	     * @return String
	     */
	    public static String ListToString(List<?> list) {
	        String listString = "";
	        if (list != null && list.size() != 0) {
	            for (int i = 0; i < list.size(); i++) {
	                String curr = (String) (((Map<?, ?>) (list.get(i))).get("currency"));
	                String amout = ((Map<?, ?>) (list.get(i))).get("amount").toString();
	                listString = listString + curr + "|" + amout + "@";
	            }
	            return listString;
	        } else {
	            return null;
	        }
	    }

	    /**
	     * <p>
	     * ����shortClassName()��
	     * </p>
	     * 
	     * @param obj
	     * @return
	     * @author manbaum
	     * @since Aug 20, 2008
	     */
	    public static String shortClassName(Object obj) {
	        if (obj == null) {
	            return "null";
	        }

	        Class<?> clazz = obj instanceof Class ? (Class<?>) obj : obj.getClass();
	        String fullname = clazz.getName();
	        int packageNameLength = clazz.getPackage().getName().length();
	        return packageNameLength > 0 ? fullname.substring(packageNameLength + 1) : fullname;
	    }

	    public static String CRLF = System.getProperty("line.separator");

	    public static String ellipsisText(String longText, int maxLength) {
	        if (longText == null)
	            return "null";
	        int index = longText.indexOf(CRLF);
	        String firstLine = index >= 0 ? longText.substring(0, index) : longText;
	        return firstLine.length() > maxLength ? firstLine.substring(0, maxLength) + "..." : firstLine;
	    }

	    public static String stringOf(Exception ex) {
	        if (ex != null) {
	            StringBuffer sb = new StringBuffer();
	            sb.append("Class: " + shortClassName(ex));
	            sb.append("Message: " + ellipsisText(ex.getMessage(), 32));
	            return sb.toString();
	        } else {
	            return "null";
	        }
	    }

	    public static String stringOf(Date date) {
	        return stringOf(TimeZone.getDefault(), date);
	    }

	    public static String stringOf(TimeZone timeZone, Date date) {
	        if (date == null) {
	            return "null";
	        }
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	        if (timeZone != null) {
	            formatter.setTimeZone(timeZone);
	        }
	        return formatter.format(date);
	    }

	    /**
	     * ����srcStr�ַ�����ǰtruncByteLen�ֽڳ��ȵ��Ӵ���<br>
	     * <p/>
	     * �����ȡ��ĩ�ֽ��ǰ�����֣�����ȥ���ֽڣ�Ҫ�󷵻������ĺ��֡�<br>
	     * <p/>
	     * (1)srcStr == null || truncByteLen < 0 ����""<br>
	     * (2)truncByteLen > srcStr��ʵ���ֽڳ��ȣ���ԭ������srcStr
	     * 
	     * @param srcStr
	     *            ����ȡ�ַ���
	     * @param charsetName
	     *            ���뷽ʽ
	     * @param truncByteLen
	     *            ��ȡ�ֽ���
	     * @return ��ȡ����ַ���
	     *         <p/>
	     *         e.g. srcStr="ab���", truncByteLen=3, ����"ab"; truncByteLen=4,
	     *         ����"ab��"
	     *         <p/>
	     *         Written Date: 2008-9��17
	     * @author chenyx
	     */
	    public static String truncate(String srcStr, String charsetName, int truncByteLen) {
	        if (srcStr == null || truncByteLen < 0)
	            return "";

	        int strLen = srcStr.length();
	        String tempStr = "";

	        try {
	            if (truncByteLen <= strLen)
	                tempStr = srcStr.substring(0, truncByteLen);// truncByteLen=0,�򷵻�""
	            else
	                tempStr = srcStr;
	        } catch (IndexOutOfBoundsException iobe) {
	            return "";
	        }

	        int tempByteLen;
	        try {
	            tempByteLen = tempStr.getBytes(charsetName).length;
	        } catch (UnsupportedEncodingException e) {
	            tempByteLen = tempStr.getBytes().length;
	        }

	        while (tempByteLen > truncByteLen) {
	            tempStr = tempStr.substring(0, tempStr.length() - 1);
	            try {
	                tempByteLen = tempStr.getBytes(charsetName).length;
	            } catch (UnsupportedEncodingException e) {
	                tempByteLen = tempStr.getBytes().length;
	            }
	        }
	        return tempStr;
	    }

	    public static Locale toLocale(String localeStr) {
	        if (localeStr == null)
	            return null;
	        String[] part = localeStr.split("_");
	        if (part.length == 1)
	            return new Locale(part[0].toLowerCase());
	        if (part.length == 2)
	            return new Locale(part[0].toLowerCase(), part[1].toUpperCase());
	        if (part.length == 3)
	            return new Locale(part[0].toLowerCase(), part[1].toUpperCase(), part[2].toUpperCase());
	        return new Locale(localeStr);
	    }

	    /**
	     * ʹ�á�,����ԭ���������зָ���������Ϊ�յ������滻Ϊ��-����������Ϻ󷵻�
	     * <p/>
	     * ����ע�⣺������ֵΪnullʱ�����ء��� ������ֵΪ����ʱ�����ء�-�� ������ֵֻ������,��ʱ�����ء�-,-��
	     * 
	     * @param args
	     * @return fillStr
	     */
	    public static String fillNullArgs(String args) {

	        String fillStr = "";

	        // ����Ϊ��ָ�뷵�ؿմ�
	        if (args == null) {
	            return fillStr;
	        }

	        // ���޴�ƥ�䣬����ĩβ������
	        String[] strArgs = args.split(",", -1);

	        // �滻��Ԫ��
	        for (int i = 0; i < strArgs.length; i++) {
	            if (StringUtil.isNullOrEmpty(strArgs[i])) {
	                strArgs[i] = "-";
	            }
	            fillStr = fillStr + strArgs[i] + ",";
	        }

	        // ȥ�����ġ�,��
	        if (!StringUtil.isNullOrEmpty(fillStr)
	                && (fillStr.substring(fillStr.length() - 1, fillStr.length()).equals(","))) {
	            fillStr = fillStr.substring(0, fillStr.length() - 1);
	        }

	        return fillStr;
	    }

	    /**
	     * ��֤ʱ�䣨Сʱ���ӣ��Ƿ�Ϸ� 0000-2359
	     * 
	     * @param time
	     * @return
	     */
	    public static boolean checkTime(String time) {
	        boolean flag = true;

	        if (null == time || "".equals(time))
	            flag = false;
	        /** ����Ϊ4λ���� **/
	        if (4 != time.length())
	            flag = false;
	        /** ���������� **/
	        if (!isDigit(time))
	            flag = false;

	        if (flag) {
	            int num1 = Integer.parseInt(time.substring(0, 2));
	            int num2 = Integer.parseInt(time.substring(2, 4));
	            if (num1 > 23)
	                flag = false;
	            if (num2 > 59)
	                flag = false;
	        }
	        return flag;
	    }

	    /**
	     * ��Դ�ַ�����һ�ֱ���תΪ��һ�ֱ���
	     * 
	     * @param src
	     *            ԭʼ�ַ���
	     * @param charset1
	     *            ԭ��������
	     * @param charset2
	     *            �±�������
	     * @return ת����ı��� String
	     */
	    public static String encoding(String src, String charset1, String charset2) throws UnsupportedEncodingException {
	        String target = null;
	        if (src != null) {
	            target = new String(src.getBytes(charset1), charset2);
	        }
	        return target;
	    }

	    /**
	     * @param bytes
	     * @param charsetName
	     * @return
	     * @throws UnsupportedEncodingException
	     */
	    public static String encoding(byte[] bytes, String charsetName) throws UnsupportedEncodingException {
	        return new String(bytes, charsetName);
	    }

	    /**
	     * @param c
	     * @param length
	     * @return
	     */
	    public static String padding(char c, int length) {
	        StringBuffer buffer = new StringBuffer();
	        while (buffer.length() < length) {
	            buffer.append(c);
	        }
	        return buffer.toString();
	    }

	    /**
	     * checkEmailValid
	     * 
	     * @param email
	     * @return boolean
	     */
	    public static boolean checkEmailValid(String email) {

	        Pattern pattern = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");
	        Matcher matcher = pattern.matcher(email);

	        if (matcher.matches()) {
	            return true;
	        } else {
	            return false;
	        }

	    }

}
