package com.itacademy.database.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

@FixMethodOrder
public class EntitiesTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @Test
    public void saveCarChecker() {
        try (Session session = FACTORY.openSession()) {
            Car bmw = Car.builder()
                    .model("X4")
                    .supplier("BMW")
                    .price(150)
                    .build();

            Serializable id = session.save(bmw);
            assertNotNull(id);
            System.out.println(bmw);
        }
    }

    @Test
    public void getCarChecker() {
        try (Session session = FACTORY.openSession()) {
            Car car = session.get(Car.class, 1);

            assertNotNull(car.getId());
            System.out.println(car);
        }
    }

    @Test
    public void saveAddressChecker() {
        try (Session session = FACTORY.openSession()) {
            Address address = Address.builder()
                    .city("Moscow")
                    .street("Lenina")
                    .build();

            Serializable id = session.save(address);
            assertNotNull(id);
            System.out.println(address);
        }
    }

    @Test
    public void getAddressChecker() {
        try (Session session = FACTORY.openSession()) {
            Address address = session.get(Address.class, 1);

            assertNotNull(address.getId());
            System.out.println(address);
        }
    }

    @Test
    public void saveUserChecker() {
        try (Session session = FACTORY.openSession()) {

            Passport passport = Passport.builder()
                    .series("SB")
                    .number("afsdaFsdj")
                    .build();

            User user = User.builder()
                    .name("Alex")
                    .login("Alex228FF")
                    .passport(passport)
                    .password("*******")
                    .build();

            passport.setOwner(user);
            Serializable id = session.save(user);
            assertNotNull(id);
            System.out.println(user);
        }
    }

    @Test
    public void getUserChecker() {
        try (Session session = FACTORY.openSession()) {
            User user = session.get(User.class, 8);

            assertNotNull(user.getId());
            System.out.println(user);
        }
    }

    @Test
    public void savePassportChecker() {
        try (Session session = FACTORY.openSession()) {
            User user = User.builder()
                    .name("Alexx")
                    .login("AlexzxF228")
                    .password("*******")
                    .build();

            Passport passport = Passport.builder()
                    .number("KL")
                    .series("12F4576")
                    .owner(user)
                    .build();

            user.setPassport(passport);
            session.save(user);

            Serializable id = session.save(passport);
            assertNotNull(id);
            System.out.println(passport);
        }
    }

    @Test
    public void getPassportChecker() {
        try (Session session = FACTORY.openSession()) {
            Passport passport = session.get(Passport.class, 5);

            assertNotNull(passport.getId());
            System.out.println(passport);
        }
    }
}
