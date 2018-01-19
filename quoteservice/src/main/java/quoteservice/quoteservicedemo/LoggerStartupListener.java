package quoteservice.quoteservicedemo;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;

public class LoggerStartupListener extends ContextAwareBase implements LoggerContextListener, LifeCycle {
    private boolean isRunning = false;

    @Override
    public void start() {
        if (isRunning) return;
        context.putProperty("instance_id", System.getenv("INSTANCE_ID"));
        isRunning = true;
    }

    @Override
    public void stop() {
    }

    @Override
    public boolean isStarted() {
        return isRunning;
    }

    @Override
    public boolean isResetResistant() {
        return true;
    }

    @Override
    public void onStart(LoggerContext context) {
    }

    @Override
    public void onReset(LoggerContext context) {
    }

    @Override
    public void onStop(LoggerContext context) {
    }

    @Override
    public void onLevelChange(Logger logger, Level level) {
    }
}
