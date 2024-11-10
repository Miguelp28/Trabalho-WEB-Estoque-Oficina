<%-- 
/****************************************************
 * @author Miguel Henrique dos Santos Correa        *
 * RGM: 11231101499                                 *
 * Turma: B                                         *
 * Período: 04                                      *
 ***************************************************/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.dao.PecaDAO, model.Peca" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));

    PecaDAO pecaDAO = new PecaDAO();
    Peca peca = pecaDAO.pesqPeca(id);

    if (peca != null) {
        out.println("<p>ID: " + peca.getId() + "</p>");
        out.println("<p>Nome: " + peca.getNome() + "</p>");
        out.println("<p>Descrição: " + peca.getDescricao() + "</p>");
        out.println("<p>Quantidade: " + peca.getQuantidade() + "</p>");
    } else {
        out.println("<p>Peça não encontrada.</p>");
    }
%>
