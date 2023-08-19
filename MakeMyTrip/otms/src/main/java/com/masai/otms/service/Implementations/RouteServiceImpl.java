package com.masai.otms.service.Implementations;


import com.masai.otms.exceptions.RouteException;
import com.masai.otms.models.Route;
import com.masai.otms.repository.RouteRepo;
import com.masai.otms.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl  implements RouteService {

    @Autowired
    private RouteRepo routeRepo;
    @Override
    public Route addRoute(Route route) {

        return routeRepo.save(route);
    }

    @Override
    public Route updateRoute(Integer id, Route route) throws RouteException{

       Route saveRoute = routeRepo.findById(id).orElseThrow(()-> new RouteException("Invalid Route Id" +id));
       saveRoute.setRouteFrom(route.getRouteFrom());
       saveRoute.setRouteTo(route.getRouteTo());
       saveRoute.setDoj(route.getDoj());
       saveRoute.setPickupPoint(route.getPickupPoint());
       saveRoute.setFare(route.getFare());

       routeRepo.save(saveRoute);
        return route;

    }

    @Override
    public Route deleteRoute(Integer id) throws RouteException {
        Route saveRoute = routeRepo.findById(id).orElseThrow(()-> new RouteException("Invalid Route Id" +id));
        routeRepo.delete(saveRoute);

        return saveRoute;
    }

    @Override
    public Route getRouteById(Integer id) throws RouteException {
        Optional<Route> opt = routeRepo.findById(id);
        return opt.orElseThrow(()-> new RouteException("Invalid Route Id" +id));
    }

    @Override
    public List<Route> getAllRoutes() throws RouteException {
        List<Route> allRoutes = routeRepo.findAll();
        if(allRoutes.isEmpty()){
            throw new RouteException("No Routes found");
        }else{
            return allRoutes;
        }

    }
}
