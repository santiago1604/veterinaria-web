/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import model.*;
/**
 *
 * @author User
 */
@WebServlet(name = "servletMascota", urlPatterns = {"/servletMascota"})
public class servletMascota extends HttpServlet {

  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ArrayList mascotas = new ArrayList();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int indice = Integer.parseInt(request.getParameter("id"));
        mascotas.remove(indice);
        response.sendRedirect("listadoMascotas.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("tipoMascota");
        String nombre = request.getParameter("nombre");
        String raza = request.getParameter("raza");
        String color = request.getParameter("color");
        int edad = Integer.parseInt(request.getParameter("edad"));
        
        if (tipo.equals("canino")) {
            int nivelEntrenamiento = Integer.parseInt(request.getParameter("entrenamiento"));
            Canino canino = new Canino(nombre, raza, color, edad, nivelEntrenamiento);
            mascotas.add(canino);
        } else if (tipo.equals("felino")) {
            boolean libreDeToxoplasmosis = Boolean.parseBoolean(request.getParameter("libreDeToxoplasmosis"));
            Felino felino = new Felino(nombre, raza, color, edad, libreDeToxoplasmosis);
            mascotas.add(felino);
        }
        
        request.getSession().setAttribute("promedio", obtenerEdadPromedio());
        request.getSession().setAttribute("numPerros", obtenerCantidadCanino());
        request.getSession().setAttribute("numGatos", obtenerCantidadFelinos());
        request.getSession().setAttribute("array", mascotas);
        response.sendRedirect("listadoMascotas.jsp");
        
        
        
        
    }
    public double obtenerEdadPromedio() {
        int sumEdad=0;
        double promedio = 0;
        Iterator it = mascotas.iterator();
        while(it.hasNext()){
            Mascota objeto =(Mascota) it.next();
            sumEdad+=objeto.getEdad();
        }
        promedio=sumEdad/mascotas.size();
        return promedio;
    }
    
    public int obtenerCantidadFelinos() {
        int cantidad = 0;
        Iterator it = mascotas.iterator();
        while(it.hasNext()){
            Mascota objeto =(Mascota) it.next();
            if(objeto instanceof Felino){
                cantidad++;
            }
        }

        return cantidad;
    }
    public int obtenerCantidadCanino() {
        int cantidad = 0;
        Iterator it = mascotas.iterator();
        while(it.hasNext()){
            Mascota objeto =(Mascota) it.next();
            if(objeto instanceof Canino){
                cantidad++;
            }
        }

        return cantidad;
    }
    
    
    
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
