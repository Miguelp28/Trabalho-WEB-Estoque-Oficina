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
    String nome = request.getParameter("nome");
    String descricao = request.getParameter("descricao");
    int quantidade = Integer.parseInt(request.getParameter("quantidade"));

    PecaDAO pecaDAO = new PecaDAO();
    Peca peca = new Peca();
    peca.setNome(nome);
    peca.setDescricao(descricao);
    peca.setQuantidade(quantidade);

    boolean sucesso = pecaDAO.insPeca(peca);

    if (sucesso) {
        out.println("<p>Peça adicionada com sucesso!</p>");
    } else {
        out.println("<p>Erro ao adicionar a peça.</p>");
    }
%>
