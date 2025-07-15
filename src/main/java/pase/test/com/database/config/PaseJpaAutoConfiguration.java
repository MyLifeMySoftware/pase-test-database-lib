package pase.test.com.database.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@AutoConfiguration
@AutoConfigureBefore({
        HibernateJpaAutoConfiguration.class,
        JpaRepositoriesAutoConfiguration.class,
})
@ComponentScan(
        basePackages = {
                "pase.test.com.database.mapper"
        }
)
@EnableJpaRepositories(
        repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class,
        basePackages = {
                "pase.test.com.database.repository",
        }
)
@EnableEnversRepositories(
        basePackages = {
                "pase.test.com.database.repository",
        }
)
@EnableTransactionManagement
@EntityScan(
        basePackages = {
                "pase.test.com.database.entity",
        }
)
public class PaseJpaAutoConfiguration {
}