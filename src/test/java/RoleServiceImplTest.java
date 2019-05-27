import com.mateacademy.springmvc.entity.Role;
import com.mateacademy.springmvc.repository.RoleRepository;
import com.mateacademy.springmvc.service.RoleServiceImpl;
import org.junit.Test;
import static org.mockito.Mockito.verify;

public class RoleServiceImplTest {
    private RoleRepository roleRepository;
    private Role role;
    private RoleServiceImpl service;

    @Test
    public void testFindByRole() {
        role = new Role();
        role.setRole("user");
        service.findByRole(role.getRole());
        verify(roleRepository).findByRole(role.getRole());
    }
}
