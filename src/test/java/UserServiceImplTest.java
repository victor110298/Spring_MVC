import com.mateacademy.springmvc.entity.Role;
import com.mateacademy.springmvc.entity.User;
import com.mateacademy.springmvc.repository.UserRepository;
import com.mateacademy.springmvc.service.UserServiceImpl;
import org.hamcrest.core.IsSame;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl service;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createUser() {
        User user = new User();
        when(userRepository.save(any(User.class))).thenReturn(user);
        service.createUser(user);
        assertThat(service.createUser(user), is(notNullValue()));
    }

    @Test
    public void deleteUser() {
        User user = new User();
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
        service.deleteUserById(1L);
        assert (service.getAllUsers().isEmpty());
        verify(userRepository, never()).delete(any(User.class));
    }

    @Test
    public void findUserById() {
        User user = new User();
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
        User result = service.getUserById(1L);
        assertThat("result", result, is(IsSame.sameInstance(user)));
        verify(userRepository).findById(1L);
    }


    @Test
    public void getAllUsers() {
        User users = new User();
        when(userRepository.findAll()).thenReturn((List<User>) users);
        List<User> result = service.getAllUsers();
        assertThat(result, is(IsSame.sameInstance(users)));
        verify(userRepository).findAll();
    }
}
