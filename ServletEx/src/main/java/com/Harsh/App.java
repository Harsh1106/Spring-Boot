package com.Harsh;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App 
{
    public static void main( String[] args ) throws LifecycleException {
        System.out.println( "Hello World!" );
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addContext("", null); //the first parameter tells the application name of the application, and here we are working with the same application so I will leave it for default which is "".
        //the second parameter creates a new directory structure that's why keep it as null.
        Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
        //the first parameter is context, then servlet name, then the object of servlet.
        context.addServletMappingDecoded("/hello", "HelloServlet"); //the second parameter can be user defined for this line as well as the above lines.
        //in the above parameter the second one should be same.

        tomcat.start();
        tomcat.getServer().await(); //this tells tomcat to wait and hold on the server
        //in console we can see that our tomcat is getting shutdown but after writing the above line we can say that tomcat is asked to wait.

    }
}
