package com.example.groupq;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private String link = "Home page";

    public void init() {
        message = "Group Q members";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Create a HashMap to store student names and student numbers
        Map<String, String> studentMap = new HashMap<>();
        studentMap.put("Hannah Wamuhu", "BSCLMR162223");
        studentMap.put("Colin Ado", "BSCLMR107123");
        studentMap.put("Eddyjoy Matemo", "BSCLMR162523");
        studentMap.put("Beth Njoki", "BSCLMR208022");

        // Iterate through the HashMap entries and print them
        PrintWriter out = response.getWriter();

        out.println("<link rel='stylesheet' type='text/css' href='style.css'>");

        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Names</th>");
        out.println("<th>Student Number</th>");
        out.println("</tr>");

        for (Map.Entry<String, String> entry : studentMap.entrySet()) {
            String name = entry.getKey();
            String number = entry.getValue();

            out.println("<tr>");
            out.println("<td>" + name + "</td>");
            out.println("<td>" + number + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
        out.println("<a href='index.jsp'>"+ link + " </a>");
    }

    public void destroy() {
    }
}