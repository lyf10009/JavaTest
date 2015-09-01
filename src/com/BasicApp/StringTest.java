package com.BasicApp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bean.TreeNode;

class BeanTest{
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}

public class StringTest {

	public static void main(String[] args) throws ParseException {
		// judgeChinese();//判断汉字个数
		// removeStr();
		// timeFormatByString();
		// substringTest();
		// compareToTest();
		// replaceString();
		// match();
		// splitTest();
		// charTest();
		// stringBuildTest();
		// indexOf();
		// equals();
		// removeHtml();
		// escapeHTML();//将html符号转义

		// String
		// str="<p><img alt=\"5.png\" src=\"/management/ueditor/jsp/upload/image/20150709/1436426689959090795.png\" title=\"1436426689959090795.png\"/></p>";
		// int index1 = str.indexOf("ueditor/jsp");
		// int index3 = str.indexOf("\"", index1);
		// String str1 =str.substring(index1,index3);
		// System.out.println(str1);
//		getChinaNumber(11);
		BeanTest beanTest = new BeanTest();
		System.out.println(beanTest.getAge());
		System.out.println(StringUtil.isNullOrEmpty(beanTest.getAge()));
		System.out.println(StringUtil.isNullOrEmpty(beanTest.getName()));
		beanTest.setAge(1);
		beanTest.setName("name");
		System.out.println(StringUtil.isNullOrEmpty(beanTest.getAge()));
		System.out.println(StringUtil.isNullOrEmpty(beanTest.getName()));
		patternMatch();
		
		
		Pattern p = Pattern.compile("c(.*?)a(t)s",Pattern.CASE_INSENSITIVE); //不区分大小写
		Matcher m = p.matcher("one cat,two cbats in the yard"); 
		StringBuffer sb = new StringBuffer(); 
		while(m.find()){
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
		
		System.out.println("JAva".matches("(?i)(java)"));//true
		
	}
	
	public static void patternMatch(){
		String json="{\"result\":[{\"code\":12,\"firstName\":\"Brett\"},{\"code\":13,\"firstName\":\"Brett\"},{\"code\":14,\"firstName\":\"Brett\"}]";
		String regex = "\"code\":(.*?),.*?\"firstName\":\"(.*?)\"";
		Matcher matcher = Pattern.compile(regex).matcher(json);
		while(matcher.find()){
			String value = matcher.group(1);
			String value1 = matcher.group(2);
			System.out.print(value+"    ");
			System.out.println(value1);
		}
		
	} 

	private static String[] str = { "零", "一", "二", "三", "四", "五", "六", "七",
			"八", "九" };
	private static String ss[] = new String[] { "十", "百", "千" };
	public static void getChinaNumber(int d) {
		String s = String.valueOf(d);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			String index = String.valueOf(s.charAt(i));
			sb = sb.append(str[Integer.parseInt(index)]);
		}
		String sss = String.valueOf(sb);
		int i = 0;
		for (int j = sss.length() - 1; j > 0; j--) {
			sb = sb.insert(j, ss[i++]);
		}
		String res = sb.toString();
		if (res.length() < 4) {
			res = res.replace("一十", "十");
		}
		res = res.replace("十零", "十").replace("零十", "零").replace("零百", "零")
				.replace("零零", "零").replaceAll("零$", "")
				+ "、";
		System.out.println(res);
	}

	public static void escapeHTML() {
		String htmlStr = "<div style='text-align:center;'> 整治“四风”   清&nbsp;&nbsp;弊除垢<br/>"
				+ "<span style='font-size:14px;'> </span><span style='font-size:18px;'>"
				+ "公司召开党的群众路线教育实践活动动员大会</span><br/></div>";
		int length = htmlStr.length();
		int newLength = length;
		boolean someCharacterEscaped = false;
		for (int i = 0; i < length; i++) {
			char c = htmlStr.charAt(i);
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
			System.out.println(htmlStr);

		StringBuffer sb = new StringBuffer(newLength);
		for (int i = 0; i < length; i++) {
			char c = htmlStr.charAt(i);
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
		System.out.println(sb.toString());
	}

	public static void removeHtml() {
		String str1 = "<p><br/></p>";
		String str2 = "<p><br/></p><p>了敬爱分了就拉开所肩负的<p><p><br/></p><p><br/></p>";
		if (str2.contains(str1)) {
			str2 = str2.replaceAll(str1, "");
		}
		System.out.println(str2);

		String htmlStr = "<div style='text-align:center;'> 整治“四风”   清&nbsp;&nbsp;弊除垢<br/>"
				+ "<span style='font-size:14px;'> </span><span style='font-size:18px;'>"
				+ "公司召开党的群众路线教育实践活动动员大会</span><br/></div>";
		String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
		htmlStr = htmlStr.replaceAll("&nbsp;", " ");
		htmlStr = htmlStr.replaceAll(regEx_html, "");
		System.out.println(htmlStr);

	}

	public static void indexOf() {
		String string = "2014-08-01";
		String string1 = "2014-06-01";
		System.out.println(string.indexOf("-08-"));
		System.out.println(string1.indexOf("-08-"));// 不存在时，返回-1
	}

	/*
	 * ==比较的是对象的地址或者是引用，equals比较的是对象的内容
	 */
	public static void equals() {
		String a = "2";
		String b = "2";
		String c = new String("2");
		System.out.println("a==b:" + a == b);
		System.out.println("a.equals(b):" + a.equals(b));
		System.out.println("a==c" + a == c);
		System.out.println("a.equals(c):" + a.equals(c));
	}

	public static void charTest() {
		char a = '1';
		char b = '2';
		System.out.println(b++);
		System.out.println(b - a);
	}

	public static void stringBuildTest() {
		StringBuilder sb = new StringBuilder();
		sb.append("1234").append("56789");
		System.out.println(sb.toString());
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

	public static void splitTest() {
		String str1 = "123,1231";
		String str2 = "12313";
		String[] arr1 = str1.split("=");
		String[] arr2 = str2.split("");
		for (String he : arr1) {
			System.out.println(he);
		}
		System.out.println("-------------------------" + arr1.length);
		for (String he : arr2) {
			System.out.println(he);
		}
		System.out.println("-------------------------" + arr2.length);

	}

	public static void match() {
		String string = "static_shortest_time_night-0-1";
		if (string.endsWith("-1"))
			System.out.println("字符串以'-1'结尾");
		if (string.startsWith("static"))
			System.out.println("字符串以'static'开头");

		if (string.indexOf("night") >= 0) {
			System.out.println("字符串包含'night'");
		} else {
			System.out.println("字符串不包含'night'");
		}
	}

	public static void replaceString() {
		String str1 = "luo123luo456fei789";
		String str2 = str1.replaceAll("ren", "");
		String str3 = str1.replaceAll("luo", "");
		System.out.println(str2);
		System.out.println(str3);
	}

	public static void compareToTest() {
		String str1 = "2014-04-15";
		String str2 = "2014-05-13";
		String str3 = "2014-06-12";
		System.out.println(str1.compareTo(str2));// -1
		System.out.println(str2.compareTo(str1));// 1
		System.out.println(str1.compareTo("2014-08-16"));// 0
	}

	public static void charAtTest() {
		String str = "0123456789";
		System.out.println("charAt函数：" + str.charAt(8)); // index从0开始
	}

	public static void substringTest() {
		String str = "123456789";
		// substring(int index[,int toIndex]),index从0开始,默认到字符串末尾
		System.out.println(str.substring(1, str.length()));
		System.out.println(str.substring(2, 2 + 1));
		System.out.println(str.substring(str.length() - 1, str.length()));
		System.out.println(str.substring(5));
		System.out.println(str.substring(7, 8));
	}

	// 通过字符型时间 计算时间差 秒
	public static void timeFormatByString() throws ParseException {
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		DateFormat df1 = new SimpleDateFormat("HH:mm");
		DateFormat dfAll = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat dfMonthDay = new SimpleDateFormat("MM-dd");
		DateFormat dfYear = new SimpleDateFormat("yyyy-MM-dd");

		String str1 = "2013-4-01 17:30:42.0";
		String str11 = "2013-4-01 17:30:43.0";
		Date as1 = new Date();
		System.out.println(dfYear.format(as1));
		as1 = dfAll.parse(str1);
		String str2 = "7:55";
		System.out.println(dfYear.parse(dfYear.format(dfAll.parse(str1))));
		System.out.println(df.format(df1.parse(str2).getTime()));
		System.out.println(df1.format(df1.parse(str2).getTime()));
//		 System.out.println(df1.format(df.parse(str1).getTime()));
//		 System.out.println(df.format(df.parse(str1).getTime()));
	}

	// 判断汉字个数
	public static void judgeChinese() {
		int count = 0;
		String str = "中文fd我是中国人as文德路站asdsa";
		String regEx = "[\\u4e00-\\u9fa5]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		while (m.find()) {
			count = count + 1;
		}
		System.out.println("共有 " + count + "个 ");
		System.out.println();
	}

	// 删除特定字符
	public static void removeStr() {
		String str = "中文fb9da我是中国人9bsasb9dsa";
		System.out.println(str + "  " + str.length());
		String str1 = new String();
		String[] arrStrings = str.split("b");// split(string)：根据特定字符将字符串划分为字符型数组，若有多个字符可用与("|")隔开，例如split(",|-")
		for (String a : arrStrings) {
			System.out.print(a);
			str1 += a;
		}
		System.out.println(str1.length());
	}
}
