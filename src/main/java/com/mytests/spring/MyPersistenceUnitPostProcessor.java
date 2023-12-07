package com.mytests.spring;

import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyPersistenceUnitPostProcessor implements PersistenceUnitPostProcessor {

@Override
public void postProcessPersistenceUnitInfo(final MutablePersistenceUnitInfo pui) {

pui.addManagedClassName("com.mytests.spring.Car");

}}