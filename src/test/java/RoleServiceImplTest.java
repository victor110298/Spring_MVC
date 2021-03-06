
import com.mateacademy.springmvc.entity.Role;
import com.mateacademy.springmvc.entity.User;
import com.mateacademy.springmvc.repository.RoleRepository;
import com.mateacademy.springmvc.service.RoleServiceImpl;
import org.hamcrest.core.IsSame;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class RoleServiceImplTest {
    @Mock
    private RoleRepository repository;

    @InjectMocks
    private RoleServiceImpl service;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByRole() {
        Role role=new Role();
        when(repository.findByRole(anyString())).thenReturn(java.util.Optional.of(role));
        Role result = service.findByRole("user");
        assertThat("result", result, is(IsSame.sameInstance(role)));
        verify(repository).findByRole("user");
    }
}
