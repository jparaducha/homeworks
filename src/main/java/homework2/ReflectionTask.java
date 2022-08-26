package homework2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionTask {

    private static final Logger LOGGER = LogManager.getLogger(ReflectionTask.class);

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class reflectionClass = Building.class;

        Field[] fields = reflectionClass.getDeclaredFields();

        LOGGER.info("\nFields inside building class:\n");
        for (Field field : fields) {
            LOGGER.info((field.getModifiers() == 0 ? "default " : field.getModifiers() == 1 ? "public " : "private ") + field.getType() + " " + field.getName());
        }

        Method[] methods = reflectionClass.getDeclaredMethods();

        LOGGER.info("\nmethods inside building class:\n");
        for (Method method : methods) {
            LOGGER.info((method.getModifiers() == 0 ? "default " : method.getModifiers() == 1 ? "public " : "private ") + method.getReturnType() + " " + method.getName() + (method.getParameterTypes().length == 0 ? "()" : "( " + Arrays.toString(method.getParameterTypes()) + " )"));
        }
        Constructor[] constructors = reflectionClass.getConstructors();

        Method something = reflectionClass.getDeclaredMethod("includesPlumbing");
        LOGGER.info("Calling method using reflection: " + something.invoke(constructors[2].newInstance()));

        LOGGER.info("\nConstructors in Building class:\n");
        for (Constructor constructor : constructors) {
            LOGGER.info(constructor);
        }
    }
}
