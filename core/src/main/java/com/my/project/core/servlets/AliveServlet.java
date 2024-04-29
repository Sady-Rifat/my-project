package com.my.project.core.servlets;

//import com.aem.demo.core.services.ServerInfoService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.apache.sling.api.servlets.ServletResolverConstants.*;

import com.aem.demo.core.services.ServerInfoService;
@Component(service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Alive Servlet",
                SLING_SERVLET_METHODS + "=[" + HttpConstants.METHOD_GET + "]",
                SLING_SERVLET_EXTENSIONS + "=txt",
                SLING_SERVLET_PATHS + "=" + "/bin/public/my-project/alive"
        })
public class AliveServlet extends SlingAllMethodsServlet {
    @Reference
    protected ServerInfoService serverInfoService;

    private transient Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {

        String hostname;
        try {


            PrintWriter writer = response.getWriter();
            InetAddress ip = serverInfoService.getHostAddress();
            writer.write("Server IP address : " + ip.getHostAddress() + "\nServer Hostname : " + ip.getHostName());

            writer.flush();
            writer.close();

        } catch (UnknownHostException e) {

            logger.info("Unknown Host exception {}", e.getMessage());
        } catch (IOException e) {
            logger.info("IO exception {}", e.getMessage());
        }
    }
}
