<%@page import="java.lang.*"%>
<%@page import="java.io.*"%>
<%@page import="understanding.the.jvm.second.edition.chapter09.practice.*"%>
<%
	InputStream is=new FileInputStream("c:/TestClass.class"); //需要修改class文件路径，并且该class文件里面要有main函数
	byte[]b=new byte[is.available()];
	is.read(b);
	is.close();
	out.println("<textarea style='width:1000; height=800'>");
	out.println(JavaClassExecuter.execute(b));
	out.println("</textarea>");
%>