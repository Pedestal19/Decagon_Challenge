package gabe.hosanna.decagon_algorithm_test.solution;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Author: Hosanna Gabe-Oji
 * Project: Decagon_Algorithm_Test
 * Date: 6/10/2020
 */
public class AuthorSolutionTest {

    private static final String GET_USERNAME_CONTAINS_EXPECTED = "olalonde";
    private static final int GET_USERNAME_THRESHOLD = 5;
    private static final int GET_USERNAME_EXPECTED_SIZE = 5;
    private static final String GET_USERNAME_WITH_HIGHEST_COMMENT_EXPECTED = "guelo";
    private static final int GET_USERNAME_SORTEDBY_RECORDDATE_THRESHOLD = 3;
    private static final int GET_USERNAME_SORTEDBY_RECORD_DATE_EXPECTED_SIZE = 3;
    private static final String GET_USERNAME_SORTEDBY_RECORDDATE_EXPECTED = "coloneltcb";



    @Test
    public void testGetUsernames() throws IOException {
        List<String> authorsUsernames = new AuthorSolution().getUsernames(GET_USERNAME_THRESHOLD);
        assertEquals(GET_USERNAME_EXPECTED_SIZE, authorsUsernames.size());
        assertTrue(authorsUsernames.contains(GET_USERNAME_CONTAINS_EXPECTED));
    }

    @Test
    public void testGetUsernameWithHighestCommentCount() throws IOException {
        assertEquals(GET_USERNAME_WITH_HIGHEST_COMMENT_EXPECTED, new AuthorSolution().getUsernameWithHighestCommentCount());
    }

    @Test
    public void testGetUsernamesSortedByRecordDate() throws IOException {
        List<String> authorsUsernames = new AuthorSolution().getUsernamesSortedByRecordDate(GET_USERNAME_SORTEDBY_RECORDDATE_THRESHOLD);
        assertEquals(GET_USERNAME_SORTEDBY_RECORD_DATE_EXPECTED_SIZE, authorsUsernames.size());
        assertTrue(authorsUsernames.contains(GET_USERNAME_SORTEDBY_RECORDDATE_EXPECTED));
    }
}
