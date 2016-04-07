package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class BinarySearchTest {

    @Test
    public void search_ElementIsInOneElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(1,new int[]{1});
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(0));
    }

    @Test
    public void search_ElementIsNotInOneElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(0,new int[]{1});
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(-1));
    }

    @Test
    public void search_SearchElementIsFirstInMultiElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(1,new int[]{1,2,3});
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(0));
    }

    @Test
    public void search_ElementIsLastInMultiElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(3,new int[]{1,2,3});
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(2));
    }

    @Test
    public void search_ElementIsMiddleInMultiElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(2,new int[]{1,2,3});
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(1));
    }

    @Test
    public void search_ElementIsNotInMultiElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(4,new int[]{1,2,3});
        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(-1));
    }
}
