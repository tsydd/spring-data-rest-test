package data.config;

import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.hibernate.jmx.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.persistence.EntityManagerFactory;
import java.lang.management.ManagementFactory;

/**
 * @author Dmitry Tsydzik
 * @since Date: 26.08.2014
 */
@Configuration
public class HibernateStatisticsMBeanInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateStatisticsMBeanInitializer.class);

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void init() {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        SessionFactory sessionFactory = ((HibernateEntityManagerFactory) entityManagerFactory).getSessionFactory();
        StatisticsService statisticsService = new StatisticsService();
        statisticsService.setSessionFactory(sessionFactory);
        statisticsService.setStatisticsEnabled(true);

        try {
            server.registerMBean(statisticsService, new ObjectName("Hibernate:application=Statistics"));
        } catch (InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException | MalformedObjectNameException e) {
            LOGGER.error("Failed to initialize statistics MBean", e);
        }
    }
}
