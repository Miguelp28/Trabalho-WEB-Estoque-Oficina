<%-- 
/****************************************************
 * @author Miguel Henrique dos Santos Correa        *
 * RGM: 11231101499                                 *
 * Turma: B                                         *
 * Período: 04                                      *
 ***************************************************/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.dao.PecaDAO, model.Peca, java.util.List" %>
<%
    PecaDAO pecaDAO = new PecaDAO();
    List<Peca> pecas = pecaDAO.pesqPecaAll();

    if (pecas != null && !pecas.isEmpty()) {
        for (Peca peca : pecas) {
            out.println("<p>ID: " + peca.getId() + 
                        "<br><br>"+
                        "Nome: " + peca.getNome() + 
                        "<br><br>"+
                        "Descrição: " + peca.getDescricao() + 
                        "<br><br>"+
                        "Quantidade: " + peca.getQuantidade() + 
                        "<br><br>"+
                        "</p>");
        }
    } else {
        out.println("<p>Nenhuma peça encontrada.</p>");
    }
%>
