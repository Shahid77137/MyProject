package com.masai.otms.service;

import com.masai.otms.exceptions.RouteException;
import com.masai.otms.models.Route;

import java.util.List;

public interface RouteService {

    public Route addRoute(Route route);

    public Route updateRoute(Integer id, Route route) throws RouteException;

    public Route deleteRoute(Integer id) throws RouteException;

    public Route getRouteById(Integer id) throws RouteException;

    public List<Route> getAllRoutes() throws RouteException;

}
