package tghcastro.pageobjects.support;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class InstancesRepository {
    private static Map<Class, Object> instances = new HashMap<>();

    public static <T> T loadInstance(Class type) {
        Object instance = instances.get(type);
        if (instance == null) {
            instance = createInstance(type);
        }
        return (T) instance;
    }

    private static <T> T createInstance(Class type) {
        try {
            Constructor constructor = type.getConstructor();
            Object instanceOfMyClass = constructor.newInstance();
            instances.put(type, instanceOfMyClass);
            return (T) instanceOfMyClass;
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
