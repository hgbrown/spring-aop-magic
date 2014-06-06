package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aspect to increment the value of the {@link demo.Calculator#add(int, int)} method by one.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201406061221
 * @since 0.1201406061221
 */
@Aspect
public class IncrementAspect {

    /**
     * The pointcut method to select the {@link demo.Calculator#add(int, int)} method.
     */
    @Pointcut("execution(public * demo.Calculator.add(..))")
    public void add() {
    }

    /**
     * The advice to be applied to the {@link demo.Calculator#add(int, int)} method.
     *
     * @param pjp the join point.
     * @return the value incremented by one.
     * @throws Throwable never.
     */
    @Around("add()")
    public Object increment(ProceedingJoinPoint pjp) throws Throwable {
        final Object[] args = pjp.getArgs();

        return argsShouldBeIntercepted(args) ?
                ((Integer) pjp.proceed()) + 1 : pjp.proceed();

    }

    /**
     * Checks if the method should be intercepted based on the arguments to the method. We only want to intercept the
     * method if both arguments are {@literal 2}.
     *
     * @param args the arguments sent to the method.
     * @return {@code true} if both arguments are {@literal 2} otherwise {@code false}.
     */
    private boolean argsShouldBeIntercepted(Object[] args) {
        return args.length == 2 && ((Integer) args[0]) == 2 && ((Integer) args[1]) == 2;
    }

}