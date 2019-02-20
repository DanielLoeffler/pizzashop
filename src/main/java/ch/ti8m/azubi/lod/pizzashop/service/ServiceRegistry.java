package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.persistence.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ServiceRegistry {

    private static ServiceRegistry instance;

    private final Map<Class<?>, Class<?>> mappings = new HashMap<>();
    private final Map<Class<?>, Object> services = new HashMap<>();

    private ServiceRegistry() {
        mappings.put(PizzaService.class, PizzaServiceImpl.class);
        mappings.put(OrderService.class, OrderServiceImpl.class);
        mappings.put(PizzaDAO.class, PizzaDAOJdbc.class);
        mappings.put(OrderDAO.class, OrderDAOJdbc.class);
        mappings.put(PizzaOrderDAO.class, PizzaOrderDAOJdbc.class);

    }

    public static synchronized ServiceRegistry getInstance() {
        if (instance == null) {
            instance = new ServiceRegistry();
        }
        return instance;
    }

    public synchronized <S> S get(Class<S> serviceClass) {
        if (!mappings.containsKey(serviceClass)) {
            throw new NoSuchElementException("Service not found: " + serviceClass.getName());
        }
        if (!services.containsKey(serviceClass)) {
            Class<?> implClass = mappings.get(serviceClass);
            try {
                Object instance = implClass.newInstance();
                services.put(serviceClass, instance);
            } catch (Exception ex) {
                throw new RuntimeException("Cannot create service instance for " + serviceClass.getName(), ex);
            }
        }
        return serviceClass.cast(services.get(serviceClass));
    }
}
