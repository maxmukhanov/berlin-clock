package com.ubs.opsit.interviews.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
    private static final Object ELEMENT = new Object();
    private static final int INITIAL_CAPACITY = 2;
    private Stack<Object> subjectUnderTesting;

    @Before
    public void setUp() throws Exception {
        subjectUnderTesting = new Stack<>(INITIAL_CAPACITY);
    }

    @Test
    public void shouldPushElement() throws Exception {
        subjectUnderTesting.push(ELEMENT);

        Assert.assertEquals(1, subjectUnderTesting.size());
    }

    @Test
    public void shouldPopElement() throws Exception {
        subjectUnderTesting.push(ELEMENT);

        Object actual = subjectUnderTesting.pop();

        Assert.assertEquals(ELEMENT, actual);
    }

    @Test(expected = StackEmptyException.class)
    public void shouldThrowStackEmptyExceptionIfStackIsEmpty() throws Exception {
        subjectUnderTesting.pop();
    }

    @Test
    public void shouldStackBeEmpty() throws Exception {
        Assert.assertTrue(subjectUnderTesting.isEmpty());
    }

    @Test
    public void shouldStackBeIsNotEmpty() throws Exception {
        subjectUnderTesting.push(ELEMENT);

        Assert.assertFalse(subjectUnderTesting.isEmpty());
    }

    @Test
    public void shouldCoverFirstInLastOutAlgorithm() throws Exception {
        Object first = new Object();
        Object second = new Object();

        subjectUnderTesting.push(first);
        subjectUnderTesting.push(second);

        Assert.assertEquals(second, subjectUnderTesting.pop());
        Assert.assertEquals(first, subjectUnderTesting.pop());
    }

    @Test
    public void shouldCapacityIncreasedIfOverhead() throws Exception {
        int initialCapacity = 20;
        int additionalNumberOfElements = 10;
        subjectUnderTesting = new Stack<>(initialCapacity);
        for (int i = 0; i < initialCapacity + additionalNumberOfElements; i++) {
            subjectUnderTesting.push(ELEMENT);
        }

        Assert.assertEquals(initialCapacity + additionalNumberOfElements, subjectUnderTesting.size());
    }
}
