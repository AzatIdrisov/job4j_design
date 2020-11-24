package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean working = true;
            while (working) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String message = "";
                    str = in.readLine();
                    while (!str.isEmpty()) {
                        System.out.println(str);
                        if (str.contains("msg") && str.contains("GET")) {
                            str = str.substring(str.indexOf(" ") + 1);
                            message = str.substring(str.indexOf('=') + 1, str.indexOf(" "));
                            if (message.equals("Exit")) {
                                working = false;
                            }
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(message.getBytes());
                }
            }
        } catch (IOException e) {
            LOG.error("Exception: ", e);
        }
    }
}