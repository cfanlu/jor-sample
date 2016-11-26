package com.jatools.jor.sample.controller;

import jatools.data.reader.sql.ModelsQuery;
import jatools.designer.App;
import jatools.engine.ReportJob;
import jatools.server.FileFinder;
import jatools.server.ReportExporter;
import jatools.server.ReportWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MainController {

    @RequestMapping("/")
    public ModelAndView demo() {
        ModelAndView modelAndView = new ModelAndView("reportViewer");
        modelAndView.addObject("template", "report/demo.xml");
        modelAndView.addObject("id", "-1");
        return modelAndView;
    }

    @RequestMapping("/jor/export")
    public void export(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        jrservice(request, response);
    }

    private void jrservice(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String action = request.getParameter(ReportJob.ACTION_TYPE);

        if ("export".equals(action)) {
            ReportExporter.service(request, response);
        }else if ("querymodel".equals(action)) {
            try {
                ModelsQuery.service(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action == null) {
            ReportWriter.service(request, response);
        } else if ("tempfile".equals(action)) {
            FileFinder.service(request, response);
        } else {
            throw new ServletException(App.messages.getString("res.42") + action + ".");
        }
    }
}
