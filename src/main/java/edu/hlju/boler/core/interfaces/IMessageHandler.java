package edu.hlju.boler.core.interfaces;

@FunctionalInterface
public interface IMessageHandler {

    void handle(Object message);

}
