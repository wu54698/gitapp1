package iSpancar.dforum.model;

import javax.persistence.*;

@Entity
@Table(name = "forum_member")
public class ForumMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ForumMember() {
    }

    public ForumMember(Integer id) {
        this.id = id;
    }


}
