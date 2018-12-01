package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.ncsu.csc326.coffeemaker.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/head.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("<title>CoffeeMaker</title>\n");
      out.write("<style>\n");
      out.write("h1{\n");
      out.write("\tfont-family: sans-serif;\n");
      out.write("}\n");
      out.write("h3{\n");
      out.write("\tfont-family: sans-serif;\n");
      out.write("\tfont-size: 14pt;\n");
      out.write("}\n");
      out.write(".font1{\n");
      out.write("\tfont-family: sans-serif;\n");
      out.write("\tfont-size: 14pt;\n");
      out.write("}\n");
      out.write(".font_success{\n");
      out.write("\tfont-family: sans-serif;\n");
      out.write("\tfont-size: 14pt;\n");
      out.write("\tcolor: green;\n");
      out.write("}\n");
      out.write(".font_failure{\n");
      out.write("\tfont-family: sans-serif;\n");
      out.write("\tfont-size: 14pt;\n");
      out.write("\tcolor: red;\n");
      out.write("}\n");
      out.write("</style>");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div align=center class=\"font1\">\n");

	CoffeeMaker cm = (CoffeeMaker)session.getAttribute("cm");
	if (cm == null) {
		session.setAttribute("cm", new CoffeeMaker());
	}

      out.write("\n");
      out.write("Welcome to the CoffeeMaker.  Please select a menu option below.\n");
      out.write("<ul>\n");
      out.write("<li><a href=\"add_recipe.jsp\">Add a recipe</a></li>\n");
      out.write("<li><a href=\"delete_recipe.jsp\">Delete a recipe</a></li>\n");
      out.write("<li><a href=\"edit_recipe.jsp\">Edit a recipe</a></li>\n");
      out.write("<li><a href=\"add_inventory.jsp\">Add inventory</a></li>\n");
      out.write("<li><a href=\"check_inventory.jsp\">Check inventory</a></li>\n");
      out.write("<li><a href=\"make_coffee.jsp\">Make coffee</a></li>\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
