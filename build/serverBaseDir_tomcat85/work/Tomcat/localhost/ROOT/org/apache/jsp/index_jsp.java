/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.70
 * Generated at: 2022-06-11 17:48:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import ru.myOnlineShop.model.customer.ClientAccount;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("javax.servlet.http.HttpSession");
    _jspx_imports_classes.add("javax.servlet.http.HttpServletRequest");
    _jspx_imports_classes.add("javax.servlet.http.HttpServlet");
    _jspx_imports_classes.add("javax.servlet.http.HttpServletResponse");
    _jspx_imports_classes.add("ru.myOnlineShop.model.customer.ClientAccount");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <form action=\"/onlineShop\" method=\"get\">\r\n");
      out.write("        <h1 style=\"text-align:center\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/images/Shop.jpg\" width=300\"></h1>\r\n");
      out.write("        <h2 style=\"text-align:center\">Интернет - магазин</h2>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            function getDate() {\r\n");
      out.write("                var date = new Date();\r\n");
      out.write("                var hours = date.getHours();\r\n");
      out.write("                var minutes = date.getMinutes();\r\n");
      out.write("                var seconds = date.getSeconds();\r\n");
      out.write("                if (hours < 10) {\r\n");
      out.write("                    hours = '0' + hours;\r\n");
      out.write("                }\r\n");
      out.write("                if (minutes < 10) {\r\n");
      out.write("                    minutes = '0' + minutes;\r\n");
      out.write("                }\r\n");
      out.write("                if (seconds < 10) {\r\n");
      out.write("                    seconds = '0' + seconds;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                document.getElementById('timedisplay').innerHTML = hours + ':' + minutes + ':' + seconds;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            setInterval(getDate, 0);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("        <h3 style=\"text-align:center\">Время:\r\n");
      out.write("            <em id=\"timedisplay\"></em>\r\n");
      out.write("        </h3>\r\n");
      out.write("\r\n");
      out.write("        ");

            String s;
            HttpSession session1 = request.getSession();
            ClientAccount clientAccount = (ClientAccount) session1.getAttribute("clientAccount");
            if ((session1.getAttribute("login")) != null && (session1.getAttribute("password")) != null) {
                s = ("Аккаунт клиента: " + clientAccount.getLogin());
            } else s = "Войти в аккаунт";
        
      out.write("\r\n");
      out.write("        <style>div {\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            width: 19.8%;\r\n");
      out.write("        }</style>\r\n");
      out.write("        <div class = block><a href=\"./onlineShop?command=info\"> <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/images/info.jpg\" width=100\"></a><br>Информация о магазине</div>\r\n");
      out.write("        <div class = block><a href=\"./onlineShop?command=authentification\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/images/account.png\" width=80\"></a><br>");
out.print(s);
      out.write("</div>\r\n");
      out.write("        <div class = block><a href=\"./onlineShop?command=catalog\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/images/catalog.jpg\" width=100\"></a><br>Каталог товаров</div>\r\n");
      out.write("        <div class = block><a href=\"./onlineShop?command=searchProduct\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/images/search.jpg\" width=120\"></a><br>Поиск товара</div>\r\n");
      out.write("        <div class = block><a href=\"./onlineShop?command=viewBasket\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/images/Basket.jpg\" width=100\"></a><br>Корзина товаров</div>\r\n");
      out.write("\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
