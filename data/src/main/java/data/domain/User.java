package data.domain;

import javax.persistence.Entity;

/**
 * @author Dmitry Tsydzik
 * @since Date: 22.08.2014
 */
@Entity
public class User extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
