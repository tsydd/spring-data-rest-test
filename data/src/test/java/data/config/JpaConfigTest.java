package data.config;

import data.domain.User;
import data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = {
        JpaConfig.class,
        TestDataSourceConfig.class
})
@ActiveProfiles("test")
public class JpaConfigTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        User user = new User();
        user.setName("Dmitry Tsydzik");
        assertThat(userRepository.save(user).getId()).isNotNull();
    }
}