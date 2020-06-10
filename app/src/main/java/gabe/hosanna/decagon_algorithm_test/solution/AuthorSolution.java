package gabe.hosanna.decagon_algorithm_test.solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import gabe.hosanna.decagon_algorithm_test.model.Author;
import gabe.hosanna.decagon_algorithm_test.model.PageData;
import gabe.hosanna.decagon_algorithm_test.service.AuthorService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparingLong;

/**
 * Author: Hosanna Gabe-Oji
 * Project: Decagon_Algorithm_Test
 * Date: 6/10/2020
 */
public class AuthorSolution {

    private static final String BASE_URL = "https://jsonmock.hackerrank.com/";
    private AuthorService authorService;
    //integer max number of 2147483647
    private int totalPages = Integer.MAX_VALUE;

    public AuthorSolution() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        authorService = retrofit.create(AuthorService.class);
    }

    //get active authors
    public List<String> getUsernames(int threshold){
        List<Author> toBeSorted = new ArrayList<>();
        for (Author user : getAllUsers()) {
            toBeSorted.add(user);
        }
        toBeSorted.sort(comparingInt((Author author) -> author.getSubmitted()).reversed());
        List<String> usernames = new ArrayList<>();
        long limit = threshold;
        for (Author user : toBeSorted) {
            if (limit-- == 0) break;
            String username = user.getUsername();
            usernames.add(username);
        }

        return usernames;
    }

    // get authors with highest comment count.
    public String getUsernameWithHighestCommentCount() throws IOException {
        boolean seen = false;
        Author best = null;
        Comparator<Author> comparator = comparingInt(Author::getCommentCount);
        for (Author author1 : getAllUsers()) {
            if (!seen || comparator.compare(author1, best) > 0) {
                seen = true;
                best = author1;
            }
        }
        Optional<Author> author = seen ? Optional.of(best) : Optional.empty();
        if(author.isPresent()){
            return author.get().getUsername();
        }else{
            return null;
        }
    }

    // get authors usernames sort by created at & threshold.
    public List<String> getUsernamesSortedByRecordDate(int threshold) throws IOException {
        List<Author> toBeSorted = new ArrayList<>();
        for (Author author : getAllUsers()) {
            toBeSorted.add(author);
        }
        toBeSorted.sort(comparingLong(Author::getCreatedAt));
        List<String> usernames = new ArrayList<>();
        long limit = threshold;
        for (Author author : toBeSorted) {
            if (limit-- == 0) break;
            String username = author.getUsername();
            usernames.add(username);
        }

        return usernames;
    }

    // get all author usernames
    private List<Author> getAllUsers(){

        List<Author> authors = new ArrayList<>();
        int startPage = 1;

        while (startPage <= totalPages) {
            authors.addAll(getUsers(startPage));
            startPage++;
        }

        return authors;
    }

    //get author usernames with page threshold
    private List<Author> getUsers(int page){
        Call<PageData> callApi = authorService.getArticleUsers(page);
        Response<PageData> response = null;
        try {
            response = callApi.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response.isSuccessful()) {
            PageData pagedResponse = response.body();
            totalPages = pagedResponse.getTotalPages();
            return pagedResponse.getAuthors();
        }

        return Collections.emptyList();
    }


}
