package ru.sakaev.webclient.acpect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Around("@annotation(ru.sakaev.webclient.acpect.LogLeadTime)")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed;
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Вызван метод: " + joinPoint.getSignature().getName());
            Instant startTime = Instant.now();

            proceed = joinPoint.proceed();

            Instant finishTime = Instant.now();
            long timeElapsed = Duration.between(startTime, finishTime).toMillis();
            logger.info(String.format("Метод выполнен за: %d миллисекунд.", timeElapsed));
        } else {
            proceed = joinPoint.proceed();
        }
        return proceed;
    }
}

