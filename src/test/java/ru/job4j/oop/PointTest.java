package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void distance11to22() {
        Point x = new Point(1,1);
        Point y = new Point(2,2);
        assertThat(x.distance(y), closeTo(1.41, 0.01));
    }
}