package steps.NewPets;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
public class PetsCustomer {
    Integer id;
    Category category;
    String name;
    List<String> photoUrls;
    List<Tags> tags;
    String status;


}
