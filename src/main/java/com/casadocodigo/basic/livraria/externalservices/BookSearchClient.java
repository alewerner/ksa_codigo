package com.casadocodigo.basic.livraria.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;

@FeignClient(value = "openlibrary", url = "http://openlibrary.org")
public interface BookSearchClient {

    @RequestMapping(method = RequestMethod.GET, value = "api/books?bibkeys={isbn}")
    String getBooksById(@PathVariable("isbn") String isbn);


    //private static final String url = "";
    // http://openlibrary.org/api/books?bibkeys=ISBN:0201558025,LCCN:93005405

//    private RestTemplate client;
//
//    private String getApiUrl(String relativeUrl) {
//        return url + relativeUrl;
//    }
//
//    public void getBooks(final String query, JsonHttpResponseHandler handler) {
//
//        ResponseEntity<String> reponse = client.getForEntity(getApiUrl("teste"), String.class);
//
//        try {
//            String url = getApiUrl("search.json?q=");
//            client.get(url + URLEncoder.encode(query, "utf-8"), handler);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void getExtraBookDetails(String openLibraryId, JsonHttpResponseHandler handler) {
//        String url = getApiUrl("books/");
//        client.get(url + openLibraryId + ".json", handler);
//
//    }

//    public String getBookByIsbn(String isbn) {
//
//        WebClient client = WebClient.builder()
//                .baseUrl(url)
//                //.defaultCookie("cookieKey", "cookieValue")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultUriVariables(Collections.singletonMap("url", url))
//                .build();
//
//        WebClient.UriSpec<WebClient.RequestBodySpec> uriSpec = client.method(HttpMethod.GET);
//        WebClient.RequestBodySpec bodySpec = uriSpec.uri(
//                uriBuilder -> uriBuilder.pathSegment("api/books/").build());
//
//    }




}
