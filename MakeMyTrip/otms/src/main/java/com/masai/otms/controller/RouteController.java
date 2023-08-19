package com.masai.otms.controller;

import com.masai.otms.models.Route;
import com.masai.otms.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/routes")
    public ResponseEntity<Route> addRouteHandler(@RequestBody Route route){
        Route saveRoute = routeService.addRoute(route);
        return new ResponseEntity<>(saveRoute, HttpStatus.CREATED);
    }

    @GetMapping("/routes/{id}")
    public ResponseEntity<Route> getRouteByIdHandler(@PathVariable Integer id){
        Route saveRoute = routeService.getRouteById(id);
        return new ResponseEntity<>(saveRoute, HttpStatus.FOUND);
    }

    @GetMapping("/routes")
    public ResponseEntity<List<Route>> getAllRoutesHandler(){
        List<Route> allRoutes = routeService.getAllRoutes();
        return new ResponseEntity<>(allRoutes, HttpStatus.ACCEPTED);
    }

    @PutMapping("/routes/{id}")
    public ResponseEntity<Route> updateRouteByIdHandler(@PathVariable Integer id, @RequestBody Route route){

        Route saveRoute = routeService.updateRoute(id,route);
        return new ResponseEntity<>(saveRoute, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/routes/{id}")
    public ResponseEntity<Route> deleteRouteHandler(@PathVariable Integer id){
        Route saveRoute = routeService.deleteRoute(id);
        return new ResponseEntity<>(saveRoute, HttpStatus.OK);
    }

}
