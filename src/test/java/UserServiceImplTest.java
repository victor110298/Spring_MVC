import com.mateacademy.springmvc.entity.User;
import com.mateacademy.springmvc.repository.UserRepository;
import com.mateacademy.springmvc.service.UserService;
import com.mateacademy.springmvc.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserServiceImplTest {

    private  UserService userService;
    private  UserRepository userRepository;
    private User user;

    @Before
    public void init() {
        userRepository = mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }
    @After
    public void drop() {
        userService.deleteUserById(1L);
    }

    @Test
    public void createUser() {
         user = new User();
        user.setName("Pavlo")
                .setEmail("pavlo11@test.net")
                .setActive(1)
                .setPassword("1111")
                .setAge(24);
        userService.createUser(user);
        verify(userRepository).save(user);
        assertTrue(userService.getAllUsers().contains(userService.getUserById(1L)));
    }

    @Test
    public void deleteUser() {
        userService.deleteUserById(1L);
        assertTrue(userService.getAllUsers().isEmpty());
    }

    @Test
    public void findUserById() {
        String expectedName = "Pavlo";
       User user = userService.getUserById(1L);
        assertEquals(user.getName(), expectedName);
    }

    @Test
    public void getAllUsers() {
         user = new User()
                .setName("Petro")
                .setEmail("petro22@test.net")
                .setActive(1)
                .setPassword("2222")
                .setAge(26);
        int expectedSize = 2;
        assertEquals(userService.getAllUsers().size(), expectedSize);
    }
}
