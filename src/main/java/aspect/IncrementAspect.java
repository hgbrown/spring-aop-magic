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
     * @param pjp           the join point.
     * @return              the value incremented by one.
     * @throws Throwable    never.
     */
    @Around("add()")
    public Object increment(ProceedingJoinPoint pjp) throws Throwable {
        return ((Integer) pjp.proceed()) + 1;
    }

}