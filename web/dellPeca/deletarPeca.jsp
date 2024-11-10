<%-- 
/****************************************************
 * @author Miguel Henrique dos Santos Correa        *
 * RGM: 11231101499                                 *
 * Turma: B                                         *
 * Período: 04                                      *
 ***************************************************/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.dao.PecaDAO" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));

    PecaDAO pecaDAO = new PecaDAO();
    pecaDAO.dellPeca(id);

    out.println("<p>Peça deletada com sucesso!</p>");
%>
