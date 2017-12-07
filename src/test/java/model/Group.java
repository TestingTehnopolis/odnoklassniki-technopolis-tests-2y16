package model;

/**
 * Created by germanium on 30.11.17.
 */
public class Group {
    private final String name;
    private final String description;
    private final String category;
    private final String ageRestriction;


    public Group(String name, String description, String category, String ageRestriction) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.ageRestriction = ageRestriction;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getAgeRestriction() {
        return ageRestriction;
    }
}
