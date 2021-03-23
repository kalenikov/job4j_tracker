package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void whenCollectAddresses() {
        List<Profile> profiles = List.of(
                new Profile(new Address("city1", "street1", 1, 1)),
                new Profile(new Address("city2", "street2", 2, 2)),
                new Profile(new Address("city3", "street3", 3, 3))
        );
        List<Address> expected = List.of(
                new Address("city1", "street1", 1, 1),
                new Address("city2", "street2", 2, 2),
                new Address("city3", "street3", 3, 3)
        );
        List<Address> rsl = new Profiles().collect(profiles);
        assertThat(rsl, is(expected));
    }

}