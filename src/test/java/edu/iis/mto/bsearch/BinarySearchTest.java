package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void search_ElementIsInOneElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(1,new int[]{1});
        assertTrue(searchResult.isFound());
        assertTrue(searchResult.getPosition() == 0);
    }

    @Test
    public void search_ElementIsNotInOneElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(1,new int[]{0});
        assertFalse(searchResult.isFound());
        assertTrue(searchResult.getPosition() == -1);
    }

    @Test
    public void search_SearchElementIsFirstInMultiElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(1,new int[]{1,2,3});
        assertTrue(searchResult.isFound());
        assertTrue(searchResult.getPosition() == 0);
    }

    @Test
    public void search_ElementIsLastInMultiElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(3,new int[]{1,2,3});
        assertTrue(searchResult.isFound());
        assertTrue(searchResult.getPosition() == 2);
    }

    @Test
    public void search_ElementIsMiddleInMultiElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(2,new int[]{1,2,3});
        assertTrue(searchResult.isFound());
        assertTrue(searchResult.getPosition() == 1);
    }

    @Test
    public void search_ElementIsNotInMultiElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(4,new int[]{1,2,3});
        assertFalse(searchResult.isFound());
        assertTrue(searchResult.getPosition() == -1);
    }
}
