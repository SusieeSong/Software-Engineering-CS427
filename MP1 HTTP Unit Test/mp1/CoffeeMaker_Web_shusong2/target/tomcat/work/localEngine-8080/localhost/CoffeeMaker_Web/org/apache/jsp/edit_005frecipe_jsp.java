package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.ncsu.csc326.coffeemaker.*;
import edu.ncsu.csc326.coffeemaker.exceptions.*;

public final class edit_005frecipe_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("\t<title>CoffeeMaker - Edit Recipe</title>\n");
      out.write("\t");
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
      out.write("\t<h1>CoffeeMaker</h1>\n");
      out.write("\t<h3>Edit a Recipe</h3>\n");
      out.write("\t");

		CoffeeMaker cm = (CoffeeMaker)session.getAttribute("cm");
		String value = request.getParameter("recipe");
		String price = request.getParameter("price");
		String amtCoffee = request.getParameter("amtCoffee");
		String amtMilk = request.getParameter("amtMilk");
		String amtSugar = request.getParameter("amtSugar");
		String amtChocolate = request.getParameter("amtChocolate");

		//MP1
		String coffee;
		String milk;
		String sugar;
		String chocolate;
		String printPrice;
		// MP1 end
		if (price != null && !"null".equals(value)) {
			Recipe r = new Recipe();
			try {
				r.setPrice(price);
				r.setAmtCoffee(amtCoffee);
				r.setAmtMilk(amtMilk);
				r.setAmtSugar(amtSugar);
				r.setAmtChocolate(amtChocolate);

				Integer recipeNum = (Integer)session.getAttribute("recipeNum");

				String recipeEdited = cm.editRecipe(recipeNum.intValue(), r);

				if (recipeEdited != null) {
					out.println("<span class=\"font_success\">" + recipeEdited + " successfully edited.</span><br>");
				} else {
					out.println("<span class=\"font_failure\">" + recipeEdited + " could not be edited.</span><br>");
				}
			} catch (RecipeException e) {
				out.println(e.getMessage());
			}
		} else if (value != null && !"null".equals(value)) {
			Integer recipeNum = Integer.parseInt(value);
			session.setAttribute("recipeNum", recipeNum);
			String name = cm.getRecipes()[recipeNum].getName();
			if (cm.getRecipes()[recipeNum] != null) {
				out.println("<span class=\"font_success\">Editing recipe: " + name + "</span><br>");

				//MP1
				coffee = Integer.toString(cm.getRecipes()[recipeNum].getAmtCoffee());
				milk = Integer.toString(cm.getRecipes()[recipeNum].getAmtMilk());
				sugar = Integer.toString(cm.getRecipes()[recipeNum].getAmtSugar());
				chocolate = Integer.toString(cm.getRecipes()[recipeNum].getAmtChocolate());
				printPrice = Integer.toString(cm.getRecipes()[recipeNum].getPrice());
				//MP1 end
	
      out.write("\n");
      out.write("\t<form method=\"post\" action=\"edit_recipe.jsp\">\n");
      out.write("\t\t<table>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"price\" value=");
      out.print(printPrice );
      out.write(" ></td><td><span class=\"font1\">Recipe Price (integer)</span></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"amtCoffee\" value=");
      out.print(coffee );
      out.write(" ></td><td><span class=\"font1\">Units Coffee</span></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"amtMilk\" value=");
      out.print(milk );
      out.write(" ></td><td><span class=\"font1\">Units Milk</span></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"amtSugar\" value=");
      out.print(sugar );
      out.write(" ></td><td><span class=\"font1\">Units Sugar</span></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"amtChocolate\" value=");
      out.print(chocolate );
      out.write(" ></td><td><span class=\"font1\">Units Chocolate</span></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t\t<input type=\"submit\" value=\"Edit Recipe!\">\n");
      out.write("\t</form>\n");
      out.write("\t");

		} else {
			out.println("<span class=\"font_failure\">" + name + " could not be selected.</span><br>");
		}
	} else {
		Recipe [] recipes = cm.getRecipes();
	
      out.write("\n");
      out.write("\t<br>\n");
      out.write("\t<form method=\"post\" action=\"edit_recipe.jsp\">\n");
      out.write("\t\t<table>\n");
      out.write("\t\t\t");

				for (int i = 0; i < recipes.length; i++) {
					if (recipes[i] != null) {
			
      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><input type=\"radio\" name=\"recipe\" value=");
      out.print(i );
      out.write("></td><td><span class=\"font1\">");
      out.print(recipes[i].getName() );
      out.write("</span></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t");

					}
				}
			
      out.write("\n");
      out.write("\t\t</table>\n");
      out.write("\t\t<input type=\"submit\" name=\"submit\" value=\"Select Recipe!\">\n");
      out.write("\t</form>\n");
      out.write("\t");

		}
	
      out.write("\n");
      out.write("\t<br>\n");
      out.write("\t<br>\n");
      out.write("\t<a href=\"index.jsp\"><span class=\"font1\">Back to CoffeeMaker Menu</span></a>\n");
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
