import java.util.ArrayList;
import java.util.List;

public class EducationMaterial {
    private List<String> materials = new ArrayList<>();

    // View educational materials
    public void viewMaterial() {
        for (String material : materials) {
            System.out.println(material);
        }
    }

    // Add educational material (Admin only)
    public void addMaterial(String material) {
        materials.add(material);
    }

    // Update existing educational material (Admin only)
    public void updateMaterial(int index, String newMaterial) {
        if (index >= 0 && index < materials.size()) {
            materials.set(index, newMaterial);
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Delete educational material (Admin only)
    public void deleteMaterial(int index) {
        if (index >= 0 && index < materials.size()) {
            materials.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public List<String> getMaterials() {
        return materials;
    }
}
