package com.n1ar4.agent.test;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

import javax.servlet.ServletException;
import java.io.IOException;

public class TestValve extends ValveBase {

    @Override
    public void invoke(Request request, Response response)
            throws IOException, ServletException {
        this.getNext().invoke(request, response);
    }
}
