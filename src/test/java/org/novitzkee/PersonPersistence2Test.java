package org.novitzkee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PersonPersistence2Test.Test2ContextConfiguration.class)
@Transactional
public class PersonPersistence2Test {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    void testSavePerson2() {
        final Person person = new Person();
        person.setName("novitzkee");

        final Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    // Force creating new context in DefaultContextCache due to different key
    @Import(PersistenceTestConfiguration.class)
    static class Test2ContextConfiguration { }
}
