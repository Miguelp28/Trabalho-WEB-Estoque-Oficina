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
    String nome = request.getParameter("nome");
    String descricao = request.getParameter("descricao");
    int quantidade = Integer.parseInt(request.getParameter("quantidade"));

    PecaDAO pecaDAO = new PecaDAO();
    pecaDAO.alterPeca(id, nome, descricao, quantidade);

    out.println("<p>Peça alterada com sucesso!</p>");
%>
