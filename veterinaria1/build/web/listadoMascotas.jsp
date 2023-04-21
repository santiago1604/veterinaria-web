<%-- 
    Document   : listadoMascotas
    Created on : 20/04/2023, 10:56:16 a. m.
    Author     : User
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    ArrayList lista = new ArrayList();
    lista = (ArrayList) session.getAttribute("array");
    double prom = (double) session.getAttribute("promedio");
    int nPerros = (int) session.getAttribute("numPerros");
    int nGatos = (int) session.getAttribute("numGatos");
    
    
    int tamaño = lista.size();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Listado de Mascotas</title>
        <link rel="stylesheet" href="estilo.css"/>
    </head>
    <body>
        <h1>Listado de Mascotas</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Raza</th>
                    <th>Color</th>
                    <th>Edad</th>
                    <th>Entrenamiento (solo para perros)</th>
                    <th>Libre de toxoplasmosis (solo para gatos)</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%  Iterator it = lista.iterator();
                    int id=0;
                    while(it.hasNext()){
                        Mascota objeto = (Mascota) it.next();
                        id= lista.indexOf(objeto);%>
                 <tr>
                        <td><%= id %></td>
                        <td><%= objeto.getNombre() %></td>
                        <td><%= objeto.getRaza() %></td>
                        <td><%= objeto.getColor() %></td>
                        <td><%= objeto.getEdad() %></td>
                        <%if(objeto instanceof Canino){ %>
                            <td><%= ((Canino)objeto).getNivelEntrenamiento() %></td>
                        <%}else{ %>
                            <td>NULL</td>
                        <% } %>
                        <%if(objeto instanceof Felino){ %>
                            <td><%= ((Felino)objeto).isLibreDeToxoplasmosis() %></td>
                        <%}else{ %>
                            <td>NULL</td>
                        <% } %>
                        <td>
                            <form action="servletMascota" method="GET">
                                <input type="hidden" name="id" value="<%= id %>">
                                <input type="submit" name="eliminar" value="Eliminar">
                            </form>
                        </td>
                 </tr>
                
               
                
                <% } %>
            </tbody>
        </table>
                        <p>Total de animales: <%= tamaño %></p>
                        <p>Promedio edad: <%= prom %></p>
                        <p>Cantidad perros: <%= nPerros %></p>
                        <p>Cantidad gatos: <%= nGatos %></p>
                        
                   <a href="index.html">ingresa otra mascota</a>     
    </body>
</html>

