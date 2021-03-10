package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    static Job job1 = new Job("aaa", 10);
    static Job job2 = new Job("bbb", 50);

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAsc() {
        Comparator<Job> cmp = new JobAscByName();
        assertThat(cmp.compare(job1, job2), lessThan(0));
    }

    @Test
    public void whenCompatorByNameDesc() {
        Comparator<Job> cmp = new JobDescByName();
        assertThat(cmp.compare(job1, job2), greaterThan(0));
    }


    @Test
    public void whenCompatorByPriorityAsc() {
        Comparator<Job> cmp = new JobAscByPriority();
        assertThat(cmp.compare(job1, job2), lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityDesc() {
        Comparator<Job> cmp = new JobDescByPriority();
        assertThat(cmp.compare(job1, job2), greaterThan(0));
    }

       @Test
    public void whenCompatorByNameAscAndProrityAsc() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobAscByPriority());
        assertThat(cmp.compare(job1, job2), lessThan(0));
    }
}