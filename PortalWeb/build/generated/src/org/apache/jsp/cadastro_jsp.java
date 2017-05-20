package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cadastro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt-br\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Cadastro</title>\n");
      out.write("    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/materialize.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/main.css\" type=\"text/css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <section id=\"cadastro-section\">\n");
      out.write("        <nav class=\"transparent\" id=\"main-menu\">\n");
      out.write("            <div class=\"nav-wrapper\">\n");
      out.write("                <a href=\"#\" class=\"brand-logo\" id=\"logo-menu\">Logo</a>\n");
      out.write("                <a href=\"#\" data-activates=\"mobile-demo\" class=\"button-collapse\"><i class=\"material-icons\">menu</i></a>\n");
      out.write("                <ul id=\"nav-mobile\" class=\"right hide-on-med-and-down\">\n");
      out.write("                    <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"login.jsp\">Login</a></li>\n");
      out.write("                </ul>\n");
      out.write("                <ul class=\"side-nav\" id=\"mobile-demo\">\n");
      out.write("                    <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"login.jsp\">Login</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col s10 offset-s1 m8 offset-m2\" id=\"div-cadastro\">\n");
      out.write("                <ul class=\"collapsible\" data-collapsible=\"accordion\" id=\"ul-form-cadastro\">\n");
      out.write("                    <li>\n");
      out.write("                        <div class=\"collapsible-header active\"><i class=\"material-icons\">filter_drama</i>Cadastro</div>\n");
      out.write("                        <div class=\"collapsible-body\" id=\"cadastro-form\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <form class=\"col s12\" action=\"return getURL();\" id=\"form-cadastro\" method=\"post\">\n");
      out.write("                                    <div class=\"input-field col s12 m10 offset-m1 black-text\">\n");
      out.write("                                        <input id=\"nome\" name=\"nome\" type=\"text\" class=\"\">\n");
      out.write("                                        <label for=\"nome\" class=\"black-text\">Nome completo</label>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <!--Endereco inicio-->\n");
      out.write("                                    <div id='enderecos' class=\"col s8 m6 offset-m1 black-text\">\n");
      out.write("                                        \n");
      out.write("                                    </div>\n");
      out.write("                                    <a class=\"waves-effect waves-light btn col s8 m6 offset-s2 offset-m3\" id=\"btnEndereco\">Adicionar Endereço</a>\n");
      out.write("                                    \n");
      out.write("                                    <!--Endereco fim-->\n");
      out.write("                                    \n");
      out.write("                                    <!--Especialidade inicio-->\n");
      out.write("                                    <div class=\"input-field col s12 m10 offset-m1 black-text\">\n");
      out.write("                                        <input id=\"especialidade\" name=\"especialidade\" type=\"text\" class=\"\">\n");
      out.write("                                        <label for=\"especialidade\" class=\"black-text\">Especialidade</label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!--Especialidade fim-->\n");
      out.write("\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"input-field col s12 m10 offset-m1 black-text\">\n");
      out.write("                                            <textarea id=\"habilidades\" name=\"habilidades\" class=\"materialize-textarea\" maxlength=\"2000\"></textarea>\n");
      out.write("                                            <label for=\"habilidades\" class=\"black-text\">Habilidades</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <!--Telefone inicio-->\n");
      out.write("                                    <div id='telefones' class=\"col s8 m6 offset-m1 black-text\">\n");
      out.write("                                        \n");
      out.write("                                    </div>\n");
      out.write("                                    \n");
      out.write("                                    <a class=\"waves-effect waves-light btn col s8 m6 offset-s2 offset-m3\" id=\"btnTelefone\">Adicionar Telefone</a>\n");
      out.write("                                    <!--Telefone fim-->\n");
      out.write("                                    \n");
      out.write("                                    <div class=\"row\"></div>\n");
      out.write("                                    \n");
      out.write("                                    <!--Telefone inicio-->\n");
      out.write("                                    <div id='especialidades' class=\"col s8 m6 offset-m1 black-text\">\n");
      out.write("                                        \n");
      out.write("                                    </div>\n");
      out.write("                                    \n");
      out.write("                                    <a class=\"waves-effect waves-light btn col s8 m6 offset-s2 offset-m3\" id=\"btnEspecialidade\">Adicionar Especialidade</a>\n");
      out.write("                                    <!--Telefone fim-->\n");
      out.write("                                    \n");
      out.write("                                    <div class=\"row\"></div>\n");
      out.write("                                    \n");
      out.write("                                    <!--Servico inicio-->\n");
      out.write("                                    <div id='servicos' class=\"col s8 m6 offset-m1 black-text\">\n");
      out.write("                                        \n");
      out.write("                                    </div>\n");
      out.write("                                    \n");
      out.write("                                    <a class=\"waves-effect waves-light btn col s8 m6 offset-s2 offset-m3\" id=\"btnServico\">Adicionar Servico</a>\n");
      out.write("                                    <!--Servico fim-->\n");
      out.write("                                    \n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"input-field col s12 m10 offset-m1 black-text\">\n");
      out.write("                                            <input id=\"email\" type=\"email\" class=\"\">\n");
      out.write("                                            <label for=\"email\" class=\"black-text\">E-mail</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"input-field col s12 m10 offset-m1 black-text\">\n");
      out.write("                                            <input id=\"senha1\" type=\"password\" class=\"\">\n");
      out.write("                                            <label for=\"senha1\" class=\"black-text\">Senha</label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"input-field col s12 m10 offset-m1 black-text\">\n");
      out.write("                                                <input id=\"senha2\" type=\"password\" class=\"\">\n");
      out.write("                                                <label for=\"senha2\" class=\"black-text\">Digite a senha novamente</label>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col s12 m10 offset-m1 black-text\">\n");
      out.write("                                            <input class=\"with-gap\" name=\"tipoEntidade\" type=\"radio\" id=\"fisica\" checked/>\n");
      out.write("                                            <label for=\"fisica\" class=\"black-text\">Pessoa Física</label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col s12 m10 offset-m1 black-text\">\n");
      out.write("                                            <input class=\"with-gap\" name=\"tipoEntidade\" type=\"radio\" id=\"juridica\" />\n");
      out.write("                                            <label for=\"juridica\" class=\"black-text\">Pessoa Jurídica</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <!--Início pessoa física-->\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"input-field col s12 m10 offset-m1 pf black-text\">\n");
      out.write("                                            <input id=\"cpf\" type=\"text\" class=\"\">\n");
      out.write("                                            <label for=\"cpf\" class=\"black-text\">CPF</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"input-field col s12 m10 offset-m1 pf black-text\">\n");
      out.write("                                            <input id=\"dtaNasc\" type=\"text\" class=\"\">\n");
      out.write("                                            <label for=\"dtaNasc\" class=\"black-text\">Data de Nascimento</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!--Fim pessoa física-->\n");
      out.write("\n");
      out.write("                                    <!--Início pessoa jurídica-->\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"input-field col s12 m10 offset-m1 not-display pj black-text\">\n");
      out.write("                                            <input id=\"cnpj\" type=\"text\" class=\"\">\n");
      out.write("                                            <label for=\"cnpj\" class=\"black-text\">CNPJ</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!--Fim pessoa jurídica-->\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col s10 center offset-m1\">\n");
      out.write("                                            <button class=\"btn waves-effect waves-light center\" type=\"submit\" id=\"salvar\" name=\"action\">Cadastrar\n");
      out.write("                                                <i class=\"material-icons right\">send</i>\n");
      out.write("                                            </button>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <!--Início mensagens de erros-->\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <p class=\"red-text not-display col s10 offset-m1\" id=\"error-name\">Nome incompleto ou com caracteres não permitidos.</p>\n");
      out.write("                                        <p class=\"red-text not-display col s10 offset-m1\" id=\"error-rua\">Rua incompleta</p>\n");
      out.write("                                        <p class=\"red-text not-display col s10 offset-m1\" id=\"error-email\">Email incompleto ou incorreto.</p>\n");
      out.write("                                        <p class=\"red-text not-display col s10 offset-m1\" id=\"error-phone\">Telefone incompleto.</p>\n");
      out.write("                                        <p class=\"red-text not-display col s10 offset-m1\" id=\"error-pass\">Senhas incompletas ou não coincidem.</p>\n");
      out.write("                                        <p class=\"red-text not-display col s10 offset-m1\" id=\"error-habilidades\">Habilidades incompletas.</p>\n");
      out.write("                                        <p class=\"red-text not-display col s10 offset-m1\" id=\"error-cpf\">Preencha o CPF.</p>\n");
      out.write("                                        <p class=\"red-text not-display col s10 offset-m1\" id=\"error-cnpj\">Preencha o CNPJ.</p>\n");
      out.write("                                        <p class=\"red-text not-display col s10 offset-m1\" id=\"error-cep\">CEP incompleto ou com caracteres não permitidos.</p>\n");
      out.write("                                        <p class=\"red-text not-display col s10 offset-m1\" id=\"error-city\">Escolha um estado e uma cidade.</p>\n");
      out.write("                                        <p class=\"red-text not-display col s10 offset-m1\" id=\"error-date\">Preencha sua data de nascimento.</p>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!--Fim mensagens de erros-->\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.maskedinput.js\"></script>\n");
      out.write("    <script src=\"js/materialize.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"js/main.js\" type=\"text/javascript\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
