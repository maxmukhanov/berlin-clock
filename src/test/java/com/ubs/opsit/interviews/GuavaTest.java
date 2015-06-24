package com.ubs.opsit.interviews;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Throwables;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.TreeMultiset;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class GuavaTest {

    @Test
    public void testToString() throws Exception {
        Person person = createPerson(1, "max", "mukhanov");

        String result = person.toString();

        Assertions.assertThat(result).isEqualTo("Person{firstName=max, lastName=mukhanov}");

    }

    @Test
    public void shouldComparePeopleByFirstAndLastName() throws Exception {
        Person person2 = createPerson(1, "max", "m2");
        Person person1 = createPerson(2, "max", "m1");
        Person person3 = createPerson(3, "max", "m3");
        List<Person> people = Lists.newArrayList(person2,
                person1,
                person3
        );

        Collections.sort(people);

        Assertions.assertThat(people.get(0)).isEqualTo(person1);
        Assertions.assertThat(people.get(1)).isEqualTo(person2);
        Assertions.assertThat(people.get(2)).isEqualTo(person3);

    }

    @Test
    public void shouldReorderWithGuavaOrdering() throws Exception {
        Person person1 = createPerson(2, "max", "m0");
        Person person2 = createPerson(1, "max", "m2");
        Person person3 = createPerson(3, "max", "m3");
        List<Person> people = Lists.newArrayList(person2,
                person3,
                person1
        );


        Collections.sort(people, Ordering.natural().onResultOf(new Function<Person, Integer>() {
            @Override
            public Integer apply(Person input) {
                return input.getId();
            }
        }));

        Assertions.assertThat(people.get(0)).isEqualTo(person2);
        Assertions.assertThat(people.get(1)).isEqualTo(person1);
        Assertions.assertThat(people.get(2)).isEqualTo(person3);
    }

    @Test
    public void shouldSortStringWithOrdering() throws Exception {
        List<String> list = Lists.newArrayList("b", null, "a", null);


        Ordering<String> ordering = Ordering.natural().nullsFirst();

        Collections.sort(list, ordering);

        Assertions.assertThat(list.size()).isEqualTo(4);

        Assertions.assertThat(list.get(0)).isEqualTo(null);
        Assertions.assertThat(list.get(1)).isEqualTo(null);
        Assertions.assertThat(list.get(2)).isEqualTo("a");
        Assertions.assertThat(list.get(3)).isEqualTo("b");

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldPropagateException() throws Exception {

        try {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            Throwables.propagate(e);
        }

    }

    @Test
    public void testGuavaCollections() throws Exception {
        ImmutableList<String> list = ImmutableList.of("a", "b", "c");

        Collections.sort(list);
    }

    @Test
    public void testMuldtiSetGuava() throws Exception {
        TreeMultiset<String> multiset = TreeMultiset.create();

        multiset.add("a");
        multiset.add("b");
        multiset.add("a");


        for (String item : multiset) {
            System.out.println(item);
        }






    }

    private Person createPerson(Integer id, String firstName, String lastName) {
        return new Person(id, firstName, lastName);
    }


}
