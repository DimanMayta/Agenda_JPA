package com.emergentes.controller;

import com.emergentes.bean.BeanContacto;
import com.emergentes.entidades.Contacto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diman
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ESTAMOS EN EL SERVLET");
        String action = request.getParameter("action");
        if (action == null) {
            action = "listar";
        }

        switch (action) {
            case "nuevo":
                request.setAttribute("contacto", new Contacto());
                request.getRequestDispatcher("frmcontacto.jsp").forward(request, response);
                break;
            case "editar":
                Integer id = Integer.parseInt(request.getParameter("id"));
                BeanContacto dao = new BeanContacto();
                Contacto contacto = dao.buscar(id);
                request.setAttribute("contacto", contacto);
                request.getRequestDispatcher("frmcontacto.jsp").forward(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            default:
                mostrar(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");

        Contacto contacto = new Contacto();
        contacto.setId(id);
        contacto.setNombre(nombre);
        contacto.setCorreo(correo);
        contacto.setTelefono(telefono);

        BeanContacto dao = new BeanContacto();
        if (id == 0) {
            dao.insertar(contacto);
        } else {
            dao.editar(contacto);
        }

        response.sendRedirect("MainController");
    }

    private void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanContacto dao = new BeanContacto();
        List<Contacto> lista = dao.listarTodos();
        request.setAttribute("contactos", lista);
        request.getRequestDispatcher("contactos.jsp").forward(request, response);
    }

    private void nuevo() {
        BeanContacto dao = new BeanContacto();
        Contacto c = new Contacto();
        c.setNombre("Maria Antonieta");
        c.setTelefono("11223311");
        c.setCorreo("maria@gmail.com");

        dao.insertar(c);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        BeanContacto dao = new BeanContacto();
        dao.eliminar(id);
        response.sendRedirect("MainController");
    }

    private void editar() {
        BeanContacto dao = new BeanContacto();
        //Id para editar d
        Integer id = 2;
        Contacto c = dao.buscar(id);
        c.setNombre("Rodrigo Mamani Mamani");
        c.setCorreo("rodri@gmail.com");
        dao.editar(c);
    }

}
