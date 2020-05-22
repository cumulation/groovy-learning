package com.monical.groovy.learning.tutorial

@Grab(group = 'org.codehaus.groovy.modules.http-builder', module = 'http-builder', version = '0.7')
@Grab(group = 'org.apache.httpcomponents', module = 'httpclient', version = '4.5.3')
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.RESTClient
import org.apache.http.auth.AuthScope
import org.apache.http.auth.UsernamePasswordCredentials
import org.apache.http.client.config.RequestConfig
import org.apache.http.config.SocketConfig
import org.apache.http.conn.ssl.NoopHostnameVerifier
import org.apache.http.conn.ssl.SSLConnectionSocketFactory
import org.apache.http.conn.ssl.TrustSelfSignedStrategy
import org.apache.http.impl.client.AbstractHttpClient
import org.apache.http.impl.client.BasicCredentialsProvider
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.impl.conn.PoolingClientConnectionManager
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager
import org.apache.http.params.HttpParams
import org.apache.http.ssl.SSLContextBuilder

/**
 * @author monical* @date 2020-05-22 17:00:31
 */
// Groovy's HTTP Client usage, examples and pitfalls
// 注意@grab 的位置要在import 之前

try {
    def restClient = new RESTClient("http://weathers.co")
    def response = restClient.get(path: '/api.php', query: ['city': 'Prague'])
    println "Status : ${response.status}"
    println "Body : ${response.data.text}"
} catch (Exception e) {
    println "Error : ${e.statusCode}"
    println "Message : ${e.response.data}"
}

class ThreadSafeHTTPBuilder extends HTTPBuilder {

    protected AbstractHttpClient createClient(HttpParams params) {
        PoolingClientConnectionManager cm = new PoolingClientConnectionManager()
        cm.setMaxTotal(200) // Increase max total connection to 200
        cm.setDefaultMaxPerRoute(20) // Increase default max connection per route to 20
        new DefaultHttpClient(cm, params)
    }


}
/**
 * ********************* =============== another timeout way* ********************* ===============
 */
def timeout = 10000 // millis
SocketConfig sc = SocketConfig.custom().setSoTimeout(timeout).build()
RequestConfig rc = RequestConfig.custom().setConnectTimeout(timeout).setSocketTimeout(timeout).build()
def hc = HttpClients.custom().setDefaultSocketConfig(sc).setDefaultRequestConfig(rc).build()
def http = new HTTPBuilder('https://search.yahoo.com/search?q=foobar')
http.client = hc
def restClient = new RESTClient("hostname")

// another timeout way
def TIMEOUT = 5000
def defaultRequestConfig = RequestConfig.custom()
        .setConnectionRequestTimeout(TIMEOUT)
        .setConnectTimeout(TIMEOUT)
        .setSocketTimeout(TIMEOUT)
        .build()

//basic user/password authentication
def credentials = new UsernamePasswordCredentials("admin", "password")
def credentialsProvider = new BasicCredentialsProvider()
credentialsProvider.setCredentials(AuthScope.ANY, credentials)

//set ssl trust all, no ssl exceptions
def sslContext = new SSLContextBuilder().loadTrustMaterial(null, TrustSelfSignedStrategy.INSTANCE).build()
def sslSocketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE)

//multithreaded connection manager
def multithreadedConnectionManager = new PoolingHttpClientConnectionManager()

//build client with all this stuff
restClient.setClient(HttpClients.custom()
        .setConnectionManager(multithreadedConnectionManager)
        .setDefaultCredentialsProvider(credentialsProvider)
        .setDefaultRequestConfig(defaultRequestConfig)
        .setSSLSocketFactory(sslSocketFactory)
        .build())
def client = new ThreadSafeHTTPBuilder()