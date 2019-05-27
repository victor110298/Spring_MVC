import com.mateacademy.springmvc.entity.User;
import com.mateacademy.springmvc.service.UserService;
import lombok.AllArgsConstructor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImplTest {
    private final UserService service;

    @Before
    public void init() {
        User user = new User();
        user.setName("Pavlo")
                .setEmail("pavlo11@test.net")
                .setActive(1)
                .setPassword("1111")
                .setAge(24);
        service.createUser(user);
    }

    @After
    public void drop() {
        service.deleteUserById(1L);
    }

    @Test
    public void createUser() {
        assertTrue(service.getAllUsers().contains(service.getUserById(1L)));
    }

    @Test
    public void deleteUser() {
        service.deleteUserById(1L);
        assertTrue(service.getAllUsers().isEmpty());
    }

    @Test
    public void findUserById() {
        String expectedName = "Pavlo";
        User user = service.getUserById(1L);
        assertEquals(user.getName(), expectedName);
    }

    @Test
    public void getAllUsers() {
        User user = new User()
                .setName("Petro")
                .setEmail("petro22@test.net")
                .setActive(1)
                .setPassword("2222")
                .setAge(26);
        int expectedSize = 2;
        assertEquals(service.getAllUsers().size(), expectedSize);
    }
}
