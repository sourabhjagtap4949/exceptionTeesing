package com.example.mokitoExample;


import com.example.mokitoExample.utils.MyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(value = MockitoExtension.class)
public class MyMultiTest {

    @Test
    public void test(){
        MyUtils myUtils = Mockito.mock(MyUtils.class);
        myUtils.add(10,20);
        Mockito.verify(myUtils).add(10,20);
        Mockito.verify(myUtils,Mockito.times(1)).add(10,20);

        Mockito.verify(myUtils,Mockito.atLeast(1)).add(10,20);

        MyUtils myUtils1 = Mockito.mock(MyUtils.class);

        Mockito.verifyNoInteractions(myUtils1);
    }

    @Test
    void testWithArgumentCaptor(){
        List mock = Mockito.mock(List.class);
        mock.add("test");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        Mockito.verify(mock).add(captor.capture());
        Assertions.assertEquals("test",captor.getValue());
    }

    @Test
    void doAnswerTestCase(){
        List mock = Mockito.mock(List.class);

        Mockito.doAnswer(ans -> "hello working on doAnswer").when(mock).get(Mockito.anyInt());

        Assertions.assertEquals("hello working on doAnswer",mock.get(5));







    }


}
