package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class BinarySearchTest {

    public static final int[] ONE_ELEMENT_SEQUENCE = new int[]{1};
    public static final int[] MULTI_ELEMENT_SEQUENCE = new int[]{1,2,3};
    public static final int[] ZERO_LENGTH_SEQUENCE = new int[]{};
    public static final int[] NOT_SORTED_SEQUENCE = new int[]{3,1,2};
    public static final int DUMMY_ELEMENT = 1;
    public static final int NOT_FOUND_POSITION = -1;
    

    @Test
    public void search_ElementIsInOneElementSequence() throws Exception {
        int indexOfFirstElement = 0;
        int firstElement = ONE_ELEMENT_SEQUENCE[indexOfFirstElement];

        SearchResult searchResult = BinarySearch.search(firstElement,ONE_ELEMENT_SEQUENCE);
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(indexOfFirstElement));
    }

    @Test
    public void search_ElementIsNotInOneElementSequence() throws Exception {
        int elementNotInSequence = 0;

        SearchResult searchResult = BinarySearch.search(elementNotInSequence,ONE_ELEMENT_SEQUENCE);
        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(NOT_FOUND_POSITION));
    }

    @Test
    public void search_SearchElementIsFirstInMultiElementSequence() throws Exception {
        int indexOfFirstElement = 0;
        int firstElement = MULTI_ELEMENT_SEQUENCE[indexOfFirstElement];

        SearchResult searchResult = BinarySearch.search(firstElement,MULTI_ELEMENT_SEQUENCE);
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(indexOfFirstElement));
    }

    @Test
    public void search_ElementIsLastInMultiElementSequence() throws Exception {
        int indexOfLastElement = 2;
        int lastElement = MULTI_ELEMENT_SEQUENCE[indexOfLastElement];

        SearchResult searchResult = BinarySearch.search(lastElement,MULTI_ELEMENT_SEQUENCE);
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(indexOfLastElement));
    }

    @Test
    public void search_ElementIsMiddleInMultiElementSequence() throws Exception {
        int indexOfMiddleElement = 0;
        int middleElement = ONE_ELEMENT_SEQUENCE[indexOfMiddleElement];

        SearchResult searchResult = BinarySearch.search(middleElement,MULTI_ELEMENT_SEQUENCE);
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(indexOfMiddleElement));
    }

    @Test
    public void search_ElementIsNotInMultiElementSequence() throws Exception {
        int elementNotInSequence = 4;

        SearchResult searchResult = BinarySearch.search(elementNotInSequence,MULTI_ELEMENT_SEQUENCE);
        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(NOT_FOUND_POSITION));
    }

    @Test(expected = IllegalArgumentException.class)
    public void search_SequenceIsZeroLength() throws Exception{
        BinarySearch.search(DUMMY_ELEMENT, ZERO_LENGTH_SEQUENCE);
    }
    
    @Test(expected = NullPointerException.class)
    public void search_SequenceIsNull() throws Exception{
    	BinarySearch.search(DUMMY_ELEMENT, null);
    }
    
    @Test
    public void search_SequenceIsNotSorted() throws Exception{
    	int indexOfElementToFind = 0;
    	int elementToFind = NOT_SORTED_SEQUENCE[indexOfElementToFind];
    	
    	SearchResult searchResult = BinarySearch.search(elementToFind, NOT_SORTED_SEQUENCE);
    	assertThat(searchResult.isFound(), is(false));
    	assertThat(searchResult.getPosition(), is(NOT_FOUND_POSITION));
    }
}
