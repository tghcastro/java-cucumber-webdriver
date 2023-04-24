package tghcastro.pageobjects.support;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class InstancesRepository {
    private static Map<Class, Object> instances = new HashMap<>();
    private static WebDriver uiAutomationDriver;

    public static <T> T loadInstance(Class type) {
        Object instance = instances.get(type);
        if (instance == null) {
            instance = createInstance(type);
        }
        return (T) instance;
    }

    private static <T> T createInstance(Class type) {
        //TODO: Improve exception handling
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

    public static void setUIAutomationDriver(WebDriver driver) {
        uiAutomationDriver = driver;
    }

    public static WebDriver getUIAutomationDriver() {
        return uiAutomationDriver;
    }

}
