/*
 * Copyright 2011- Per Wendel
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package spark;

import java.util.Map;

import static spark.Service.ignite;

/**
 * The main building block of a Spark application is a set of routes. A route is
 * made up of three simple pieces:
 * <ul>
 * <li>A verb (get, post, put, delete, head, trace, connect, options)</li>
 * <li>A path (/hello, /users/:name)</li>
 * <li>A callback (request, response)</li>
 * </ul>
 * Example:
 * get("/hello", (request, response) -&#62; {
 * return "Hello World!";
 * });
 * The public methods and fields in this class should be statically imported for the semantic to make sense.
 * Ie. one should use:
 * 'post("/books")' without the prefix 'Spark.'
 *
 * @author Per Wendel
 */
public class Spark {

    // Hide constructor
    protected Spark() {
    }

    /**
     * Initializes singleton.
     */
    private static class SingletonHolder {
        private static final Service INSTANCE = ignite();
    }

    private static Service getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Statically import this for redirect utility functionality, see {@link spark.Redirect}
     */
    public static final Redirect redirect = getInstance().redirect;

    /**
     * Statically import this for static files utility functionality, see {@link spark.Service.StaticFiles}
     */
    public static final Service.StaticFiles staticFiles = getInstance().staticFiles;

    /**
     * Map the route for HTTP GET requests
     *
     * @param path  the path
     * @param route The route
     */
    public static void get(String path, Route route) {
        getInstance().get(path, route);
    }

    /**
     * Map the route for HTTP POST requests
     *
     * @param path  the path
     * @param route The route
     */
    public static void post(String path, Route route) {
        getInstance().post(path, route);
    }

    /**
     * Map the route for HTTP PUT requests
     *
     * @param path  the path
     * @param route The route
     */
    public static void put(String path, Route route) {
        getInstance().put(path, route);
    }

    /**
     * Map the route for HTTP PATCH requests
     *
     * @param path  the path
     * @param route The route
     */
    public static void patch(String path, Route route) {
        getInstance().patch(path, route);
    }

    /**
     * Map the route for HTTP DELETE requests
     *
     * @param path  the path
     * @param route The route
     */
    public static void delete(String path, Route route) {
        getInstance().delete(path, route);
    }

    /**
     * Map the route for HTTP HEAD requests
     *
     * @param path  the path
     * @param route The route
     */
    public static void head(String path, Route route) {
        getInstance().head(path, route);
    }

    /**
     * Map the route for HTTP TRACE requests
     *
     * @param path  the path
     * @param route The route
     */
    public static void trace(String path, Route route) {
        getInstance().trace(path, route);
    }

    /**
     * Map the route for HTTP CONNECT requests
     *
     * @param path  the path
     * @param route The route
     */
    public static void connect(String path, Route route) {
        getInstance().connect(path, route);
    }

    /**
     * Map the route for HTTP OPTIONS requests
     *
     * @param path  the path
     * @param route The route
     */
    public static void options(String path, Route route) {
        getInstance().options(path, route);
    }

    /**
     * Maps a filter to be executed before any matching routes
     *
     * @param path   the path
     * @param filter The filter
     */
    public static void before(String path, Filter filter) {
        getInstance().before(path, filter);
    }

    /**
     * Maps an array of filters to be executed before any matching routes
     *
     * @param path    the path
     * @param filters the filters
     */

    public static void before(String path, Filter... filters) {
        for (Filter filter : filters) {
            getInstance().before(path, filter);
        }
    }

    /**
     * Maps a filter to be executed after any matching routes
     *
     * @param path   the path
     * @param filter The filter
     */
    public static void after(String path, Filter filter) {
        getInstance().after(path, filter);
    }

    /**
     * Maps an array of filters to be executed after any matching routes
     *
     * @param path    the path
     * @param filters The filters
     */

    public static void after(String path, Filter... filters) {
        for (Filter filter : filters) {
            getInstance().after(path, filter);
        }
    }

    //////////////////////////////////////////////////
    // BEGIN route/filter mapping with accept type
    //////////////////////////////////////////////////

    /**
     * Map the route for HTTP GET requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public static void get(String path, String acceptType, Route route) {
        getInstance().get(path, acceptType, route);
    }

    /**
     * Map the route for HTTP POST requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public static void post(String path, String acceptType, Route route) {
        getInstance().post(path, acceptType, route);
    }

    /**
     * Map the route for HTTP PUT requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public static void put(String path, String acceptType, Route route) {
        getInstance().put(path, acceptType, route);
    }

    /**
     * Map the route for HTTP PATCH requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public static void patch(String path, String acceptType, Route route) {
        getInstance().patch(path, acceptType, route);
    }

    /**
     * Map the route for HTTP DELETE requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public static void delete(String path, String acceptType, Route route) {
        getInstance().delete(path, acceptType, route);
    }

    /**
     * Map the route for HTTP HEAD requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public static void head(String path, String acceptType, Route route) {
        getInstance().head(path, acceptType, route);
    }

    /**
     * Map the route for HTTP TRACE requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public static void trace(String path, String acceptType, Route route) {
        getInstance().trace(path, acceptType, route);
    }

    /**
     * Map the route for HTTP CONNECT requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public static void connect(String path, String acceptType, Route route) {
        getInstance().connect(path, acceptType, route);
    }

    /**
     * Map the route for HTTP OPTIONS requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public static void options(String path, String acceptType, Route route) {
        getInstance().options(path, acceptType, route);
    }


    /**
     * Maps one or many filters to be executed before any matching routes
     *
     * @param filters The filters
     */
    public static void before(Filter... filters) {
        for (Filter filter : filters) {
            getInstance().before(filter);
        }
    }

    /**
     * Maps one or many filters to be executed after any matching routes
     *
     * @param filters The filters
     */
    public static void after(Filter... filters) {
        for (Filter filter : filters) {
            getInstance().after(filter);
        }
    }

    /**
     * Maps one or many filters to be executed before any matching routes
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param filters    The filters
     */
    public static void before(String path, String acceptType, Filter... filters) {
        for (Filter filter : filters) {
            getInstance().before(path, acceptType, filter);
        }
    }


    /**
     * Maps one or many filters to be executed after any matching routes
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param filters    The filters
     */
    public static void after(String path, String acceptType, Filter... filters) {
        for (Filter filter : filters) {
            getInstance().after(path, acceptType, filter);
        }
    }

    //////////////////////////////////////////////////
    // END route/filter mapping with accept type
    //////////////////////////////////////////////////

    //////////////////////////////////////////////////
    // EXCEPTION mapper
    //////////////////////////////////////////////////

    /**
     * Maps an exception handler to be executed when an exception occurs during routing
     *
     * @param exceptionClass the exception class
     * @param handler        The handler
     */
    public static void exception(Class<? extends Exception> exceptionClass, ExceptionHandler handler) {
        getInstance().exception(exceptionClass, handler);
    }

    //////////////////////////////////////////////////
    // HALT methods
    //////////////////////////////////////////////////

    /**
     * Immediately stops a request within a filter or route
     * NOTE: When using this don't catch exceptions of type HaltException, or if catched, re-throw otherwise
     * halt will not work
     */
    public static void halt() {
        getInstance().halt();
    }

    /**
     * Immediately stops a request within a filter or route with specified status code
     * NOTE: When using this don't catch exceptions of type HaltException, or if catched, re-throw otherwise
     * halt will not work
     *
     * @param status the status code
     */
    public static void halt(int status) {
        getInstance().halt(status);
    }

    /**
     * Immediately stops a request within a filter or route with specified body content
     * NOTE: When using this don't catch exceptions of type HaltException, or if catched, re-throw otherwise
     * halt will not work
     *
     * @param body The body content
     */
    public static void halt(String body) {
        getInstance().halt(body);
    }

    /**
     * Immediately stops a request within a filter or route with specified status code and body content
     * NOTE: When using this don't catch exceptions of type HaltException, or if catched, re-throw otherwise
     * halt will not work
     *
     * @param status The status code
     * @param body   The body content
     */
    public static void halt(int status, String body) {
        getInstance().halt(status, body);
    }

    /**
     * Set the IP address that Spark should listen on. If not called the default
     * address is '0.0.0.0'. This has to be called before any route mapping is
     * done.
     *
     * @param ipAddress The ipAddress
     */
    public static void ipAddress(String ipAddress) {
        getInstance().ipAddress(ipAddress);
    }

    /**
     * Set the port that Spark should listen on. If not called the default port
     * is 4567. This has to be called before any route mapping is done.
     * If provided port = 0 then the an arbitrary available port will be used.
     *
     * @param port The port number
     */
    public static void port(int port) {
        getInstance().port(port);
    }

    /**
     * Retrieves the port that Spark is listening on.
     *
     * @return The port Spark server is listening on.
     * @throws IllegalStateException when the server is not started
     */
    public static int port() {
        return getInstance().port();
    }

    /**
     * Set the connection to be secure, using the specified keystore and
     * truststore. This has to be called before any route mapping is done. You
     * have to supply a keystore file, truststore file is optional (keystore
     * will be reused).
     * This method is only relevant when using embedded Jetty servers. It should
     * not be used if you are using Servlets, where you will need to secure the
     * connection in the servlet container
     *
     * @param keystoreFile       The keystore file location as string
     * @param keystorePassword   the password for the keystore
     * @param truststoreFile     the truststore file location as string, leave null to reuse
     *                           keystore
     * @param truststorePassword the trust store password
     */
    public static void secure(String keystoreFile,
                              String keystorePassword,
                              String truststoreFile,
                              String truststorePassword) {
        getInstance().secure(keystoreFile, keystorePassword, truststoreFile, truststorePassword);
    }

    /**
     * Configures the embedded web server's thread pool.
     *
     * @param maxThreads max nbr of threads.
     */
    public static void threadPool(int maxThreads) {
        getInstance().threadPool(maxThreads);
    }

    /**
     * Configures the embedded web server's thread pool.
     *
     * @param maxThreads        max nbr of threads.
     * @param minThreads        min nbr of threads.
     * @param idleTimeoutMillis thread idle timeout (ms).
     */
    public static void threadPool(int maxThreads, int minThreads, int idleTimeoutMillis) {
        getInstance().threadPool(maxThreads, minThreads, idleTimeoutMillis);
    }

    /**
     * Waits for the spark server to be initialized.
     * If it's already initialized will return immediately
     */
    public static void awaitInitialization() {
        getInstance().awaitInitialization();
    }

    /**
     * Stops the Spark server and clears all routes
     */
    public static void stop() {
        getInstance().stop();
    }

    ////////////////
    // Websockets //

    /**
     * Maps the given path to the given WebSocket handler.
     * <p>
     * This is currently only available in the embedded server mode.
     *
     * @param path    the WebSocket path.
     * @param handler the handler class that will manage the WebSocket connection to the given path.
     */
    public static void webSocket(String path, Class<?> handler) {
        getInstance().webSocket(path, handler);
    }

    public static void webSocket(String path, Object handler) {
        getInstance().webSocket(path, handler);
    }

    /**
     * Sets the max idle timeout in milliseconds for WebSocket connections.
     *
     * @param timeoutMillis The max idle timeout in milliseconds.
     */
    public static void webSocketIdleTimeoutMillis(int timeoutMillis) {
        getInstance().webSocketIdleTimeoutMillis(timeoutMillis);
    }

    /**
     * Initializes the Spark server. SHOULD just be used when using the Websockets functionality.
     */
    public static void init() {
        getInstance().init();
    }

    /**
     * Set the template engine used to render templates
     *
     * @param templateEngine the template engine to use
     */
    public static void setTemplateEngine(TemplateEngine templateEngine) {
        getInstance().setTemplateEngine(templateEngine);
    }

    /**
     * Render a template with the specified model
     *
     * @param templatePath the path to the template file
     * @param model        the model to use for the template
     * @return the rendered template
     */
    public static String renderTemplate(String templatePath, Map<String, Object> model) {
        return getInstance().renderTemplate(templatePath, model);
    }

}
