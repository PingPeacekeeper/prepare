package com.example.prepare.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {
//
//    @Mock
//    ArrayList list = Mockito.mock(ArrayList.class);
//
//    @Test
//    void compute() {
//        // create a mock object
//        Random random = Mockito.mock(Random.class, "test");
//
//        // stubbing to return 100
//        when(random.nextInt()).thenReturn(100);
//        // stubbing to throw exception
//        when(random.nextInt()).thenThrow(new RuntimeException("mockito test exception"));
//        // use matcher to match args
//        when(list.get(anyInt())).thenReturn("element");
//
//        // expect nextInt() to be call 2 times
//        Mockito.verify(random, Mockito.times(1)).nextInt();
//        // assert nextInt() return 100
//        Assertions.assertEquals(100, random.nextInt());
//
//        // spy for real func calls
//        List<String> list = new LinkedList<>();
//        List<String> spy = spy(list);
//        //optionally, you can stub out some methods:
//        when(spy.size()).thenReturn(100);
//        //using the spy calls *real* methods
//        spy.add("one");
//        spy.add("two");
//        //prints "one" - the first element of a list
//        System.out.println(spy.get(0));
//        //size() method was stubbed - 100 is printed
//        System.out.println(spy.size());
//        //optionally, you can verify
//        Mockito.verify(spy).add("one");
//        Mockito.verify(spy).add("two");
//        //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
//        when(spy.get(0)).thenReturn("foo");
//        //You have to use doReturn() for stubbing
//        Mockito.doReturn("foo").when(spy).get(0);
//
//
//
//
//
//    }
}