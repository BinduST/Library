package com.sample.lib.controllers;

import com.mongodb.DBObject;
import com.sample.lib.dao.BaseDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProfilePageControllerTest {
    @InjectMocks
    ProfilePageController controller;

    @Mock
    BaseDao mockBaseDao;

    @Test
    public void shouldCallGetAllBookDetailsAtLeastOnce() throws Exception {
        List<DBObject> expected = new ArrayList<>();
        controller.getAllBookDetails();

        verify(mockBaseDao, atLeastOnce()).showAll();
    }

    @Test
    public void shouldGetAllTheBooksAvailableAsAList() throws Exception {
        List<DBObject> expected = new ArrayList<>();
        when(mockBaseDao.showAll()).thenReturn(expected);
        List<DBObject> actual = controller.getAllBookDetails();

        System.out.println(actual + " ---- " + expected);
        assertEquals(actual, expected);
    }
}