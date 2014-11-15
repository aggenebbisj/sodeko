
package nl.rdj.boundary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import nl.rdj.entity.User;

@Path("users")
public class UserResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsers() throws IOException {
        return Files.lines(Paths.get("/tmp/users.txt")).collect(Collectors.toList()).toString();
    }
    
    @POST
    public void addUser(User user) throws IOException {
        Files.write(Paths.get("/tmp/users.txt"), Arrays.asList(user.getName()), CREATE, APPEND);
        System.out.println("User added: " + user);
    }
}
