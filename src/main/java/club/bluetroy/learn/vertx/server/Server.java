package club.bluetroy.learn.vertx.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

/**
 * @author heyixin 2019-07-30 11:11.
 */
public class Server extends AbstractVerticle {
    public static void main(String[] args) {
        Server server = new Server();
        server.init(Vertx.vertx(), null);
        server.start();
    }

    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(req -> {
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from Vert.x!");
        }).listen(8080);
    }
}
