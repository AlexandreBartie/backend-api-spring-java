package br.com.bartie.app.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

public class ModelBase<T extends ModelEntity, Repo extends JpaRepository<T, Long>> {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    public final Repo repository;

    public ModelBase(Class<Repo> repo) {
        this.repository = context.getBean(repo);
    }

}
