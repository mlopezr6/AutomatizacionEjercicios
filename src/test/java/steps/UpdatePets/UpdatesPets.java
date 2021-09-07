package steps.UpdatePets;

import lombok.Data;

@Data
public class UpdatesPets {
    String petId;
    String name;
    String status;

    public static void put(String name, String status) {
    }
}
