package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testSearchElementIsInOneElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(1,new int[]{1});
        assertTrue(searchResult.isFound());
        assertTrue(searchResult.getPosition() == 0);
    }

    @Test
    public void testSearchElementIsNotInOneElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(1,new int[]{0});
        assertFalse(searchResult.isFound());
        assertTrue(searchResult.getPosition() == -1);
    }

    @Test
    public void testSearchElementIsFirstInMultiElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(1,new int[]{1,2,3});
        assertTrue(searchResult.isFound());
        assertTrue(searchResult.getPosition() == 0);
    }

    @Test
    public void testSearchElementIsLastInMultiElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(3,new int[]{1,2,3});
        assertTrue(searchResult.isFound());
        assertTrue(searchResult.getPosition() == 2);
    }

    @Test
    public void testSearchElementIsMiddleInMultiElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(2,new int[]{1,2,3});
        assertTrue(searchResult.isFound());
        assertTrue(searchResult.getPosition() == 1);
    }

    @Test
    public void testSearchElementIsNotInMultiElementSequence() throws Exception {
        SearchResult searchResult = BinarySearch.search(4,new int[]{1,2,3});
        assertFalse(searchResult.isFound());
        assertTrue(searchResult.getPosition() == -1);
    }
}
