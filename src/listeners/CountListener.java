package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class CountListener implements ServletContextListener, ServletRequestListener {
	
	ServletContext ctx = null;
	
    public void requestDestroyed(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void requestInitialized(ServletRequestEvent arg)  { 
    	Integer icount = (Integer) ctx.getAttribute("count");
    	icount ++;
    	ctx.setAttribute("count", icount);
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent arg)  { 
    	 ctx = arg.getServletContext();
         ctx.setAttribute("count", 0);
    }
	
}
