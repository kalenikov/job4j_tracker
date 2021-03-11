package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    private Job[] jobs;

    @Before
    public void setUp() {
        jobs = new Job[]{
                new Job("aaa", 10),
                new Job("bbb", 50),
                new Job("aaa", 1)
        };
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAsc() {
        Comparator<Job> cmp = new JobAscByName();
        assertThat(cmp.compare(jobs[0], jobs[1]), lessThan(0));
    }

    @Test
    public void whenCompatorByNameDesc() {
        Comparator<Job> cmp = new JobDescByName();
        assertThat(cmp.compare(jobs[0], jobs[1]), greaterThan(0));
    }


    @Test
    public void whenCompatorByPriorityAsc() {
        Comparator<Job> cmp = new JobAscByPriority();
        assertThat(cmp.compare(jobs[0], jobs[1]), lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityDesc() {
        Comparator<Job> cmp = new JobDescByPriority();
        assertThat(cmp.compare(jobs[0], jobs[1]), greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAscAndProrityDesc() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobDescByPriority());
        assertThat(cmp.compare(jobs[0], jobs[2]), lessThan(0));
    }
}