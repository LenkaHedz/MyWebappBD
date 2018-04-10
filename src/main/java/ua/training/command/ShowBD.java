package ua.training.command;

import ua.training.dao.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class ShowBD implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        /*

         String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        System.out.println(name + " " + pass);
        if( name == null || name.equals("") || pass == null || pass.equals("")  ){
            return "/login.jsp";
        }
        return "/login.jsp";

         */


        CarDriverDao cd = new CarDriverDaoImpl();
        List<Car> lc = cd.getListCars();
        List<Driver> ld = cd.getListDrivers();
        Map<Car, Driver> mcd = cd.getListCarDriver();
        return "/showbd.jsp";
    }
}
