package com.green.board7.test;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;

@Controller
@RequestMapping("/view")
public class ViewControlloer {
    @GetMapping
    public void getView(HttpServletRequest req, HttpServletResponse res) throws Exception {
        PrintWriter pw = res.getWriter();
        pw.print("<html>");
        pw.print("<h1><h1>");
    }
}
