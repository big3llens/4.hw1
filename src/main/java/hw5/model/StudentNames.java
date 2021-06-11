package hw5.model;

import java.util.ArrayList;
import java.util.List;

public class StudentNames {
    private List<String> names;

    public StudentNames() {
        names = new ArrayList<>();
        names.add("Петр");
        names.add("Мария");
        names.add("Алексей");
        names.add("Екатерина");
        names.add("Михаил");
        names.add("Ксения");
        names.add("Александр");
        names.add("Сергей");
        names.add("Ольга");
        names.add("Николай");
        names.add("Евгения");
        names.add("Олег");
    }

    public List<String> getNames() {
        return names;
    }
}
